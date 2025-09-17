package br.com.corretorredacao.domain.utils.date;

import br.com.corretorredacao.domain.utils.date.exception.DateUtilsException;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public class DateUtils {

    public static Boolean mesCheio(Object startAt, Object finishAt) throws DateUtilsException {
        Date start = asDate(startAt);
        Date finish = asDate(finishAt);
        if(!finish.equals(start) && !finish.after(start)){
            throw new DateUtilsException("Data final é anterior a data inicial!");
        }
        Period periodo = Period.between(
                LocalDate.ofInstant(start.toInstant(), ZoneOffset.UTC),
                LocalDate.ofInstant(finish.toInstant(), ZoneOffset.UTC));

        return (periodo.getMonths() != 0 && periodo.getDays() == 0);
    }

    public static int totalDias(Object startAt, Object finishAt) throws Throwable {
        Date start = asDate(startAt);
        Date finish = asDate(finishAt);
        if(!finish.equals(start) && !finish.after(start)){
            throw new Throwable("Data final é anterior a data inicial!");
        }
        return (int) ChronoUnit.DAYS.between(
                LocalDateTime.ofInstant(start.toInstant(), ZoneOffset.UTC).minusDays(1),
                LocalDateTime.ofInstant(finish.toInstant(), ZoneOffset.UTC));
    }

    public static int totalMeses(Object startAt, Object finishAt) throws Throwable {
        Date start = asDate(startAt);
        Date finish = asDate(finishAt);
        if(!finish.after(start)){
            throw new Throwable("Data final é anterior a data inicial!");
        }
        return (int) ChronoUnit.MONTHS.between(
                LocalDateTime.ofInstant(start.toInstant(), ZoneOffset.UTC),
                LocalDateTime.ofInstant(finish.toInstant(), ZoneOffset.UTC).plusDays(1));
    }

    public static String formatarData(Object date) {
        if (Objects.nonNull(date)) {
            LocalDateTime data = asLocalDateTime(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return data.format(formatter);
        }
        return null;
    }

    public static String formatarData(Object date, String pattern) {
        if (Objects.nonNull(date)) {
            LocalDateTime data = asLocalDateTime(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return data.format(formatter);
        }
        return null;
    }


//    public static String formatarDataEmMesAno(Object date) {
//        if (Objects.nonNull(date)) {
//            LocalDateTime data = asLocalDateTime(date);
//            String mes = data.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt"));
//            String ano = String.valueOf(data.getYear());
//            return StringUtils.capitalize(mes)+ "/" + ano;
//        }
//        return null;
//    }

    public static LocalDate somaDias(LocalDate start, int days){
        return start.plusDays(days);

    }

    public static Boolean mesmoMesAno(Object date1, Object date2) {
        LocalDate dateA = asLocalDate(date1);
        LocalDate dateB = asLocalDate(date2);
        return dateA.getMonth().equals(dateB.getMonth()) && dateA.getYear() == dateB.getYear();
    }

    public static Boolean mesAnterior(Object date1, Object date2) {
        LocalDate dateA = asLocalDate(date1);
        LocalDate dateB = asLocalDate(date2);

        if (dateA.getYear() == dateB.getYear()) {
            return  dateA.getMonthValue() < dateB.getMonthValue();
        }else {
            return dateA.getYear() < dateB.getYear();
        }
    }

    public static Date asDate(Object date) {
        if (date instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) date;
            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        }
        if (date instanceof LocalDate) {
            LocalDate localDate = (LocalDate) date;
            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }else{
            return  (Date) date;
        }
    }

    public static LocalDate asLocalDate(Object date) {
        if (date instanceof LocalDateTime) {
            return ((LocalDateTime) date).toLocalDate();
        }
        if (date instanceof Date) {
            Date dateToConvert = (Date) date;
            return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }else{
            return  (LocalDate) date;
        }
    }

    public static LocalDateTime asLocalDateTime(Object date) {
        if (date instanceof LocalDateTime) {
            return (LocalDateTime) date;
        }
        if (date instanceof Date) {
            Date dateToConvert = (Date) date;
            return dateToConvert.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }else{
            return (LocalDateTime) date;
        }
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static Date stringToDate(String data) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            return formato.parse(data);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static LocalDateTime stringToLocalDateTime(String data) throws Throwable {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            return LocalDateTime.parse(data, formatter);
        }catch (Exception e) {
            throw new Throwable();
        }
    }

    public static String calcularTempoExecucao(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        final Duration tempoExecucao = Duration.between(dataInicial, dataFinal);

        return durationToString(tempoExecucao);
    }

    public static String durationToString(Duration tempoExecucao) {
        final long millis = Math.abs(tempoExecucao.toMillis());

        long horas = millis / 3600000;
        long minutos = (millis % 3600000) / 60000;
        long segundos = ((millis % 3600000) % 60000) / 1000;
        long milissegundos = millis % 1000;

        return String.format("%d:%02d:%02d.%03d", horas, minutos, segundos, milissegundos);
    }

    public static Boolean isAfterOrEqual(LocalDate data1, LocalDate data2) {
        return !data1.isBefore(data2);
    }

    public static Boolean isAfterOrEqualOnDate(LocalDateTime data1, LocalDateTime data2) {
        return !data1.toLocalDate().isBefore(data2.toLocalDate());
    }

    public static Boolean isAfterOrEqual(LocalDateTime data1, LocalDateTime data2) {
        return data1.compareTo(data2) >= 0;
    }

    public static Boolean isBeforeOrEqual(LocalDateTime data1, LocalDateTime data2) {
        return data1.compareTo(data2) <= 0;
    }

    public static LocalDateTime localDateTimeAtStartOfDay(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MIN);
    }

    public static LocalDateTime localDateTimeAtEndOfDay(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MAX).withNano(999);
    }

    public static LocalDateTime retornaDataInicial(String mesAnoReferencia) throws Throwable {
        String[] dataInput = mesAnoReferencia.split("/");
        int mes = Integer.parseInt(dataInput[0]);
        int ano = Integer.parseInt(dataInput[1]);

        try {
            return LocalDate.of(ano, mes, 1).atStartOfDay();
        } catch (Exception e) {
            throw new Throwable("Ano Referência Inválido");
        }
    }

    public static LocalDateTime retornaDataFinal(String mesAnoReferencia) throws Throwable {
        String[] dataInput = mesAnoReferencia.split("/");
        int mes = Integer.parseInt(dataInput[0]);
        int ano = Integer.parseInt(dataInput[1]);

        try {
            return YearMonth.from(LocalDate.of(ano, mes, 1))
                    .atEndOfMonth()
                    .atTime(23, 59, 59, 99);
        } catch (Exception e) {
            throw new Throwable("Ano Referência Inválido");
        }
    }

    public static LocalDateTime lastDateOfYear(int anoReferencia) throws Throwable {
        try {
            int currentYear = Year.now().getValue();
            if(anoReferencia == currentYear){
                return LocalDateTime.now();
            }
            return LocalDateTime.of(anoReferencia, Month.DECEMBER, 31, 23, 59, 59);
        } catch (Exception e) {
            throw new Throwable("Ano Referência Inválido");
        }
    }

    public static LocalDateTime firstDateOfYear(int anoReferencia) throws Throwable {
        try {
            return LocalDateTime.of(anoReferencia, Month.JANUARY, 1, 0, 0, 0);
        } catch (Exception e) {
            throw new Throwable("Ano Referência Inválido");
        }
    }

    public static LocalDate stringToLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

}
