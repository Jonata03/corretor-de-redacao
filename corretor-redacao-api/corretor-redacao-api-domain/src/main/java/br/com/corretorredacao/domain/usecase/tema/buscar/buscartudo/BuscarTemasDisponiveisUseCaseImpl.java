package br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo;

import br.com.corretorredacao.domain.entity.Tema;
import br.com.corretorredacao.domain.entity.TextosInformativos;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TextosInformativosDataProvider;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.converter.BuscarTemasDisponiveisOutputDataConverter;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class BuscarTemasDisponiveisUseCaseImpl implements BuscarTemasDisponiveisUseCase {

    private final TemaDataProvider temaDataProvider;

    private final BuscarTemasDisponiveisOutputDataConverter converter;

    private final TextosInformativosDataProvider textosInformativosDataProvider;

    public BuscarTemasDisponiveisOutputData execute() {
        List<Tema> temas = temaDataProvider.buscarTemasComTextos();
        Map<Long, List<TextosInformativos>> textosPorTema = new HashMap<>();

        for (Tema tema : temas) {
            List<TextosInformativos> textos = textosInformativosDataProvider.buscarTextosInformativosPorTemaId(tema.getId());
            textosPorTema.put(tema.getId(), textos);
        }

        return converter.to(temas, textosPorTema);
    }
}
