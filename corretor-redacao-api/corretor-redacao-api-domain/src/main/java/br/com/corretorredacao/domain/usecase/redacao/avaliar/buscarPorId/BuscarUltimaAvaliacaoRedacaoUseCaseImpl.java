package br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId;

import br.com.corretorredacao.domain.entity.Avaliacao;
import br.com.corretorredacao.domain.gateway.dataprovider.AvaliacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.converter.BuscarUltimaAvaliacaoRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class BuscarUltimaAvaliacaoRedacaoUseCaseImpl implements BuscarUltimaAvaliacaoRedacaoUseCase {

    BuscarUltimaAvaliacaoRedacaoOutputDataConverter avaliarRedacaoOutputDataConverter;

    AvaliacaoDataProvider avaliacaoDataProvider;

    @Override
    public BuscarUltimaAvaliacaoRedacaoOutputData execute(BuscarUltimaAvaliacaoRedacaoInputData inputData) {

        Avaliacao avaliacao = avaliacaoDataProvider.BuscarUltimaAvaliacaoPorRedacaoId(inputData.getRedacaoId()).orElseThrow(() -> new RuntimeException("Avaliação não encontrada."));
        return avaliarRedacaoOutputDataConverter.to(avaliacao);
    }

}
