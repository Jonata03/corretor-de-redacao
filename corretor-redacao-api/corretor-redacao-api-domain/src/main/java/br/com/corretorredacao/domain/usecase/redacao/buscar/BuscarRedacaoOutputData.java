package br.com.corretorredacao.domain.usecase.redacao.buscar;

import br.com.corretorredacao.domain.entity.Redacao;
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
    List<Redacao> redacoes;
}
