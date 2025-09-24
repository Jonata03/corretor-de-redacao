package br.com.corretorredacao.domain.usecase.redacao.editar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditarRedacaoInputData {
    private Long redacaoId;
    private Long temaId;
    private String titulo;
    private String Texto;
}
