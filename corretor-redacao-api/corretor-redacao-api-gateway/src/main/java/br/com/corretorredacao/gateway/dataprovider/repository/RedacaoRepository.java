package br.com.corretorredacao.gateway.dataprovider.repository;

import br.com.corretorredacao.domain.entity.Redacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedacaoRepository extends JpaRepository<Redacao, Long> {
}
