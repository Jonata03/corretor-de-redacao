package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Redacao;

import java.util.Optional;

public interface RedacaoDataProvider {
    Redacao SalvarRedacao(Redacao redacao);

    Optional<Redacao> BuscarRedacaoPorId(Long id);
}
