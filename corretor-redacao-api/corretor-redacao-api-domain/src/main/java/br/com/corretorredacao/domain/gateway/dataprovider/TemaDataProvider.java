package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.Tema;

import java.util.List;

public interface TemaDataProvider {
    List<Tema> buscarTemasComTextos();
}
