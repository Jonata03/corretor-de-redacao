package br.com.corretorredacao.domain.usecase.redacao.buscarPorId.converter;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdOutputData;

public class BuscarRedacaoPorIdOutputDataConverter {
    public BuscarRedacaoPorIdOutputData to(Redacao redacao) {
        return BuscarRedacaoPorIdOutputData.builder()
                .redacao(BuscarRedacaoPorIdOutputData.Redacao.builder()
                        .id(redacao.getId())
                        .titulo(redacao.getTitulo())
                        .texto(redacao.getTexto())
                        .build())
                .tema(BuscarRedacaoPorIdOutputData.Tema.builder()
                        .id(redacao.getTema().getId())
                        .titulo(redacao.getTema().getTitulo())
                        .textosInformativos(redacao.getTema().getTextosInformativos().stream().map(texto ->
                                BuscarRedacaoPorIdOutputData.Texto.builder()
                                        .id(texto.getId())
                                        .titulo(texto.getTitulo())
                                        .textosInformativos(texto.getTexto())
                                        .fonte(texto.getFonte())
                                        .imagem(texto.getImagem())
                                        .build()).toList())
                        .build())
                .build();
    }
}
