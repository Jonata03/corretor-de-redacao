package br.com.corretorredacao.domain.usecase.redacao.salvar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalvarRedacaoOutputData {
    Long id;
    Tema tema;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tema {
        Long id;
        String titulo;
    }
}
