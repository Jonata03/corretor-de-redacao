package br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuscarUltimaAvaliacaoRedacaoOutputData {
    private Long avaliacaoId;
    private competencias competencias;
    private Float notaFinal;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencias {
        private competencia1 competencia1;
        private competencia2 competencia2;
        private competencia3 competencia3;
        private competencia4 competencia4;
        private competencia5 competencia5;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencia1 {
        private Float nota;
        private String justificativa;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencia2 {
        private Float nota;
        private String justificativa;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencia3 {
        private Float nota;
        private String justificativa;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencia4 {
        private Float nota;
        private String justificativa;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class competencia5 {
        private Float nota;
        private String justificativa;
    }
}
