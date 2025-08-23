package br.com.corretorredacao.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.gateway.dataprovider.repository.RedacaoRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RedacaoDataProviderImpl implements RedacaoDataProvider {

    private final RedacaoRepository redacaoRepository;

    private final EntityManager entityManager;

    @Override
    public Redacao SalvarRedacao(Redacao redacao) {
        return redacaoRepository.save(redacao);
    }

    @Override
    public Optional<Redacao> BuscarRedacaoPorId(Long id) {
        return redacaoRepository.findById( id);
    }
}
