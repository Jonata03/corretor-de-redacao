package br.com.corretorredacao.domain.usecase.redacao.salvar.converter;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoOutputData;

public class SalvarRedacaoOutputDataConverter {
    public SalvarRedacaoOutputData to (Redacao redacao){
        return SalvarRedacaoOutputData.builder()
                .id(redacao.getId())
                .tema(SalvarRedacaoOutputData.Tema.builder()
                        .id(redacao.getTema().getId())
                        .titulo(redacao.getTema().getTitulo())
                        .build()
                )
                .build();
    }
}
