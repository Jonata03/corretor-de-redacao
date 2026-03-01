package br.com.corretorredacao.domain.usecase.redacao.buscar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuscarRedacaoOutputData {
    List<BuscarRedacaoOutputData.Redacao> redacoes;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Redacao {
        Long id;
        String titulo;
        String texto;
        String temaTitulo;
    }
}
