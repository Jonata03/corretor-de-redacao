package br.com.corretorredacao.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Tema;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.gateway.dataprovider.repository.TemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TemaDataProviderImpl implements TemaDataProvider {

    private final TemaRepository repository;

    @Override
    public List<Tema> buscarTemasComTextos() {
        return repository.findAll();
    }
}