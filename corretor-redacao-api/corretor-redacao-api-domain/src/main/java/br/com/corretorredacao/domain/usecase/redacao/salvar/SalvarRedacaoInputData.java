package br.com.corretorredacao.domain.usecase.redacao.salvar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalvarRedacaoInputData {
    private Long redacaoId;
}
