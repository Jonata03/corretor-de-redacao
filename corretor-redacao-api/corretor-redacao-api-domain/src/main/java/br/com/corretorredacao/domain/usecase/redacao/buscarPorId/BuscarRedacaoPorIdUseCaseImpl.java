package br.com.corretorredacao.domain.usecase.redacao.buscarPorId;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.converter.BuscarRedacaoPorIdOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;


@AllArgsConstructor
@Builder
public class BuscarRedacaoPorIdUseCaseImpl implements BuscarRedacaoPorIdUseCase {

    RedacaoDataProvider redacaoDataProvider;

    BuscarRedacaoPorIdOutputDataConverter buscarRedacaoOutputDataConverter;

    @Override
    public BuscarRedacaoPorIdOutputData execute(BuscarRedacaoPorIdInputData inputData) {
        Redacao redacao = buscarRedacao(inputData.getRedacaoId());

        return buscarRedacaoOutputDataConverter.to(redacao);
    }

    private Redacao buscarRedacao(Long redacaoId) {
        return redacaoDataProvider.buscarRedacaoPorId(redacaoId).orElseThrow(() -> new RuntimeException("Redação Não Encontrada"));
    }
}
