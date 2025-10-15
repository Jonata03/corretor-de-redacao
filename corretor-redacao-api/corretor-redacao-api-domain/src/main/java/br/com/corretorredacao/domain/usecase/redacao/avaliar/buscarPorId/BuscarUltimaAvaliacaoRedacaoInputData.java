package br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuscarUltimaAvaliacaoRedacaoInputData {
    private Long redacaoId;
}
