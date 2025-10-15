package br.com.corretorredacao.domain.usecase.redacao.buscar;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.buscar.converter.BuscarRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;


@AllArgsConstructor
@Builder
public class BuscarRedacaoUseCaseImpl implements BuscarRedacaoUseCase {

    RedacaoDataProvider redacaoDataProvider;

    BuscarRedacaoOutputDataConverter buscarRedacaoOutputDataConverter;

    @Override
    public BuscarRedacaoOutputData execute() {
        List<Redacao> redacao = buscarTodasRedacoes();

        return buscarRedacaoOutputDataConverter.to(redacao);
    }

    private List<Redacao> buscarTodasRedacoes() {
        return redacaoDataProvider.buscarTodasRedacoes();
    }
}
