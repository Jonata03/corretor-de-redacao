package br.com.corretorredacao.domain.usecase.redacao.buscarPorId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuscarRedacaoPorIdInputData {
    private Long redacaoId;
}
