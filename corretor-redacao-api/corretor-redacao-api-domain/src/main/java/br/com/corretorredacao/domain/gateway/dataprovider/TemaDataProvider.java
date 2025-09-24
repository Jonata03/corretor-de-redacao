package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Tema;

import java.util.List;
import java.util.Optional;

public interface TemaDataProvider {
    List<Tema> buscarTemasComTextos();

    Optional<Tema> buscarTemaPorId(Long temaId);
}
