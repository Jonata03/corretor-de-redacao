package br.com.corretorredacao.domain.usecase.redacao.buscar.converter;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoOutputData;

import java.util.List;

public class BuscarRedacaoOutputDataConverter {
    public BuscarRedacaoOutputData to(List<Redacao> redacoes) {
        return BuscarRedacaoOutputData.builder()
                .redacoes(redacoes.stream()
                        .map(this::mapearRedacao)
                        .toList())
                .build();
    }

    public BuscarRedacaoOutputData.Redacao mapearRedacao(Redacao redacao) {
        return BuscarRedacaoOutputData.Redacao.builder()
                .id(redacao.getId())
                .titulo(redacao.getTitulo())
                .texto(redacao.getTexto())
                .temaTitulo(redacao.getTema().getTitulo())
                .build();
    }
}

