package br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuscarTemasDisponiveisOutputData {
    List<Tema> tema;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tema {
        Long id;
        String titulo;
        List<Texto> textosInformativos;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Texto {
        Long id;
        String titulo;
        String textosInformativos;
        String fonte;
        String imagem;
    }
}

