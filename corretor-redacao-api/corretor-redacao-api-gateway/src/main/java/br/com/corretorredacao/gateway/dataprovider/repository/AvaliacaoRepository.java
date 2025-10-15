package br.com.corretorredacao.gateway.dataprovider.repository;

import br.com.corretorredacao.domain.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query("""
            SELECT avaliacao
                FROM Avaliacao avaliacao
                WHERE avaliacao.redacao.id = :redacaoId
                  AND avaliacao.dataAvaliacao = (
                    SELECT MAX(avaliacao2.dataAvaliacao)
                    FROM Avaliacao avaliacao2
                    WHERE avaliacao2.redacao.id = :redacaoId
                                ORDER BY avaliacao2.dataAvaliacao DESC
                  )
            """)
    Optional<Avaliacao> buscarUltimaAvaliacaoPorRedacaoId(@Param("redacaoId") Long redacaoId);
}
