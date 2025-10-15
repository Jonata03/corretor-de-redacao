package br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.converter;

import br.com.corretorredacao.domain.entity.Avaliacao;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoOutputData;

public class BuscarUltimaAvaliacaoRedacaoOutputDataConverter {
    public BuscarUltimaAvaliacaoRedacaoOutputData to(Avaliacao avaliacao){
        return BuscarUltimaAvaliacaoRedacaoOutputData.builder()
                .avaliacaoId(avaliacao.getId())
                .competencias(
                        buildarCompetencias(avaliacao)
                )
                .notaFinal(avaliacao.getNotaTotal())
                .build();
    }

    private static BuscarUltimaAvaliacaoRedacaoOutputData.competencias buildarCompetencias(Avaliacao avaliacao) {
        return BuscarUltimaAvaliacaoRedacaoOutputData.competencias.builder()
                .competencia1(
                        BuscarUltimaAvaliacaoRedacaoOutputData.competencia1.builder()
                                .nota(avaliacao.getCompetenciaUmNota())
                                .justificativa(avaliacao.getCompetenciaUmJustificativa())
                                .build()
                )
                .competencia2(
                        BuscarUltimaAvaliacaoRedacaoOutputData.competencia2.builder()
                                .nota(avaliacao.getCompetenciaDoisNota())
                                .justificativa(avaliacao.getCompetenciaDoisJustificativa())
                                .build()
                )
                .competencia3(
                        BuscarUltimaAvaliacaoRedacaoOutputData.competencia3.builder()
                                .nota(avaliacao.getCompetenciaTresNota())
                                .justificativa(avaliacao.getCompetenciaTresJustificativa())
                                .build()
                )
                .competencia4(
                        BuscarUltimaAvaliacaoRedacaoOutputData.competencia4.builder()
                                .nota(avaliacao.getCompetenciaQuatroNota())
                                .justificativa(avaliacao.getCompetenciaQuatroJustificativa())
                                .build()
                )
                .competencia5(
                        BuscarUltimaAvaliacaoRedacaoOutputData.competencia5.builder()
                                .nota(avaliacao.getCompetenciaCincoNota())
                                .justificativa(avaliacao.getCompetenciaCincoJustificativa())
                                .build()
                )
                .build();
    }
}
