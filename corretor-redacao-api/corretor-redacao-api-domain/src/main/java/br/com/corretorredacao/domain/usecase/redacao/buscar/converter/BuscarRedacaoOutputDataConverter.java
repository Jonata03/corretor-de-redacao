package br.com.corretorredacao.domain.usecase.redacao.buscar.converter;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoOutputData;

import java.util.List;

public class BuscarRedacaoOutputDataConverter {
    public BuscarRedacaoOutputData to (List<Redacao> redacao){
        return BuscarRedacaoOutputData.builder()
                .redacoes(redacao)
                .build();
    }
}
