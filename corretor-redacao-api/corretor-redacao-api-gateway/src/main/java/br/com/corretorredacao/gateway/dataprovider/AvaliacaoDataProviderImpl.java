package br.com.corretorredacao.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Avaliacao;
import br.com.corretorredacao.domain.gateway.dataprovider.AvaliacaoDataProvider;
import br.com.corretorredacao.gateway.dataprovider.repository.AvaliacaoRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AvaliacaoDataProviderImpl implements AvaliacaoDataProvider {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public Avaliacao SalvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    @Override
    public Optional<Avaliacao> BuscarAvaliacaoPorId(Long id) {
        return avaliacaoRepository.findById(id);
    }

    @Override
    public Optional<Avaliacao> BuscarUltimaAvaliacaoPorRedacaoId(Long id) {
        return avaliacaoRepository.buscarUltimaAvaliacaoPorRedacaoId(id);
    }
}
