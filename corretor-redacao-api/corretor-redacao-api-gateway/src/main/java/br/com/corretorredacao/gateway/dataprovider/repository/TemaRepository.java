package br.com.corretorredacao.gateway.dataprovider.repository;

import br.com.corretorredacao.domain.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {


}
