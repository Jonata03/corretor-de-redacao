package br.com.corretorredacao.domain.usecase.redacao.buscarPorId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BuscarRedacaoPorIdOutputData {
    Redacao redacao;
    Tema tema;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Redacao {
        Long id;
        String titulo;
        String texto;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Tema {
        Long id;
        String titulo;
        List<Texto> textosInformativos;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class Texto {
        Long id;
        String titulo;
        String textosInformativos;
        String fonte;
        String imagem;
    }

}
