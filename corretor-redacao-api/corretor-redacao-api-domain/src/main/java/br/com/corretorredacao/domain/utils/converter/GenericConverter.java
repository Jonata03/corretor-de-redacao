package br.com.corretorredacao.domain.utils.converter;

import br.com.corretorredacao.domain.utils.date.DateUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class GenericConverter<L, R> {

    private static final String GET = "get";
    private static final String IS = "is";
    private static final String SET = "set";

    private final Class leftClass;
    private final Class rightClass;

    public GenericConverter() {
        Type[] actualTypeArguments = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
        this.leftClass = (Class) actualTypeArguments[0];
        this.rightClass = (Class) actualTypeArguments[1];
    }

    public R to(L source) throws Exception {
        Object target = callConstructor(this.rightClass);
        copyProperties(source, target);
        return (R) target;
    }

    public L from(R source) throws Exception {
        Object target = callConstructor(this.leftClass);
        copyProperties(source, target);
        return (L) target;
    }

    private static Object callConstructor(Class returnClass) throws Exception {
        try {
            Constructor constructor = returnClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new Exception("Não foi possivel criar instacia do construtos");
        }
    }

    private static void copyProperties(Object source, Object target) {
        List<Method> methodsGet = findMethods(GET, source);
        methodsGet.addAll(findMethods(IS, source));
        List<Method> methodsSet = findMethods(SET, target);

        methodsSet.forEach(
                methodSet -> discoverOriginMethod(methodSet, methodsGet, source, target)
                        .ifPresent(methodGet -> forceCopy(methodGet, methodSet, source, target))
        );
    }

    private static Optional<Method> discoverOriginMethod(Method methodSet, List<Method> methodsGet, Object source, Object target) {
        return methodsGet.stream()
                .filter(methodGet -> methodGet.getName().equals(inferOriginMethodName(methodSet.getName(), methodGet.getName())))
                .findFirst();
    }

    private static void forceCopy(Method methodGet, Method methodSet, Object source, Object target) {
        try {
            if (isTheSameType(methodGet, methodSet))
                methodSet.invoke(target, methodGet.invoke(source));
            else if (isEnumToString(methodGet, methodSet))
                methodSet.invoke(target, ((Enum) methodGet.invoke(source)).name());
            else if (isStringToEnum(methodGet, methodSet))
                copyStringToEnum(methodGet, methodSet, source, target);
            else if (isDateToDateTime(methodGet, methodSet))
                methodSet.invoke(target, DateUtils.asLocalDateTime(methodGet.invoke(source)));
            else if (isDateTimeToDate(methodGet, methodSet))
                methodSet.invoke(target, DateUtils.asDate(methodGet.invoke(source)));
        } catch (Exception e) {
            Logger.getLogger(GenericConverter.class.getName())
                    .log(Level.FINEST, String.format("%s: %s", e.getClass().toGenericString(), e.getMessage()));
        }
    }

    private static void copyStringToEnum(Method methodGet, Method methodSet, Object source, Object target) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> methodSetType = methodSet.getParameterTypes()[0];
        Object value = methodSetType
                .getMethod("valueOf", String.class)
                .invoke(methodSetType, ((String) methodGet.invoke(source)));
        methodSet.invoke(target, value);
    }

    private static boolean isEnumToString(Method methodGet, Method methodSet) {
        return methodGet.getReturnType().isEnum() && methodSet.getParameterTypes()[0].equals(String.class);
    }

    private static boolean isStringToEnum(Method methodGet, Method methodSet) {
        return methodGet.getReturnType().equals(String.class) && methodSet.getParameterTypes()[0].isEnum();
    }

    private static boolean isDateToDateTime(Method methodGet, Method methodSet) {
        return methodGet.getReturnType().equals(Date.class) && methodSet.getParameterTypes()[0].equals(LocalDateTime.class);
    }

    private static boolean isDateTimeToDate(Method methodGet, Method methodSet) {
        return methodGet.getReturnType().equals(LocalDateTime.class) && methodSet.getParameterTypes()[0].equals(Date.class);
    }

    private static boolean isTheSameType(Method methodGet, Method methodSet) {
        return methodSet.getParameterTypes()[0].equals(methodGet.getReturnType());
    }

    private static List<Method> findMethods(String preffix, Object object) {
        return List.of(object.getClass().getMethods())
                .stream()
                .filter(method -> method.getName().startsWith(preffix))
                .collect(Collectors.toList());
    }

    private static String inferOriginMethodName(String destinationMethodName, String originMethodName) {
        return String.format("%s%s", (originMethodName.startsWith(IS) ? IS : GET), destinationMethodName.substring(SET.length()));
    }
}
