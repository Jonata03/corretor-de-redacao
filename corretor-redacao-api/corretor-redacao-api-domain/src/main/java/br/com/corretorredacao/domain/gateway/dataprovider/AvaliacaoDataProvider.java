package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Avaliacao;

import java.util.Optional;

public interface AvaliacaoDataProvider {
    Avaliacao SalvarAvaliacao(Avaliacao redacao);

    Optional<Avaliacao> BuscarAvaliacaoPorId(Long id);

    Optional<Avaliacao> BuscarUltimaAvaliacaoPorRedacaoId(Long id);
}
