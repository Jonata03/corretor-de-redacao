package br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar;

import br.com.corretorredacao.domain.entity.Avaliacao;
import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.gateway.dataprovider.AvaliacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.converter.AvaliarRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class AvaliarRedacaoUseCaseImpl  implements AvaliarRedacaoUseCase{

    AvaliarRedacaoOutputDataConverter avaliarRedacaoOutputDataConverter;

    RedacaoDataProvider redacaoDataProvider;

    AvaliacaoDataProvider avaliacaoDataProvider;

    @Override
    public AvaliarRedacaoOutputData execute(AvaliarRedacaoInputData inputData) {

        Redacao redacao = redacaoDataProvider.buscarRedacaoPorId(inputData.getRedacaoId()).orElseThrow(() -> new RuntimeException("Redação não encontrada."));

        Avaliacao avaliacao = criarEntidadeAvaliacao(inputData, redacao);

        salvarAvaliacao(avaliacao);

        return null;
    }

    private void salvarAvaliacao(Avaliacao avaliacao) {
        avaliacaoDataProvider.SalvarAvaliacao(avaliacao);
    }

    private static Avaliacao criarEntidadeAvaliacao(AvaliarRedacaoInputData inputData, Redacao redacao) {
        return Avaliacao.builder()
                .redacao(redacao)
                .competenciaUmNota(inputData.getCompetencia1().getNota())
                .competenciaDoisNota(inputData.getCompetencia2().getNota())
                .competenciaTresNota(inputData.getCompetencia3().getNota())
                .competenciaQuatroNota(inputData.getCompetencia4().getNota())
                .competenciaCincoNota(inputData.getCompetencia5().getNota())
                .competenciaUmJustificativa(inputData.getCompetencia1().getJustificativa())
                .competenciaDoisJustificativa(inputData.getCompetencia2().getJustificativa())
                .competenciaTresJustificativa(inputData.getCompetencia3().getJustificativa())
                .competenciaQuatroJustificativa(inputData.getCompetencia4().getJustificativa())
                .competenciaCincoJustificativa(inputData.getCompetencia5().getJustificativa())
                .notaTotal(inputData.getCompetencia5().getNota()+
                        inputData.getCompetencia4().getNota()+
                        inputData.getCompetencia3().getNota()+
                        inputData.getCompetencia2().getNota()+
                        inputData.getCompetencia1().getNota()
                )
                .dataAvaliacao(LocalDateTime.now())
                .build();
    }
}
