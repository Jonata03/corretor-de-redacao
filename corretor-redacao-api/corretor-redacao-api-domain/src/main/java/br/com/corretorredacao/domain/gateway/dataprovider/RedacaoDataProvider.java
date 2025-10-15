package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Redacao;

import java.util.List;
import java.util.Optional;

public interface RedacaoDataProvider {
    Redacao salvarRedacao(Redacao redacao);

    Optional<Redacao> buscarRedacaoPorId(Long id);

    List<Redacao> buscarTodasRedacoes();
}
