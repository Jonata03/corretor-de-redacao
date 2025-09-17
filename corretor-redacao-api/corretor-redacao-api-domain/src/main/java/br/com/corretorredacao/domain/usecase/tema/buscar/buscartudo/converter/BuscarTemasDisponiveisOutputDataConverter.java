package br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.converter;

import br.com.corretorredacao.domain.entity.Tema;
import br.com.corretorredacao.domain.entity.TextosInformativos;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.BuscarTemasDisponiveisOutputData;

import java.util.List;
import java.util.Map;

public class BuscarTemasDisponiveisOutputDataConverter {
    public BuscarTemasDisponiveisOutputData to(List<Tema> source, Map<Long, List<TextosInformativos>> textosPorTema) {
        return BuscarTemasDisponiveisOutputData.builder()
                .tema(source.stream()
                        .map(tema -> mapTema(tema, textosPorTema.getOrDefault(tema.getId(), List.of())))
                        .toList())
                .build();
    }

    private BuscarTemasDisponiveisOutputData.Tema mapTema(Tema source, List<TextosInformativos> textos) {
        return BuscarTemasDisponiveisOutputData.Tema.builder()
                .id(source.getId())
                .titulo(source.getTitulo())
                .textosInformativos(textos.stream()
                        .map(this::mapTexto)
                        .toList())
                .build();
    }

    private BuscarTemasDisponiveisOutputData.Texto mapTexto(TextosInformativos source) {
        return BuscarTemasDisponiveisOutputData.Texto.builder()
                .id(source.getId())
                .titulo(source.getTitulo())
                .textosInformativos(source.getTexto())
                .fonte(source.getFonte())
                .imagem(source.getImagem())
                .build();
    }

}