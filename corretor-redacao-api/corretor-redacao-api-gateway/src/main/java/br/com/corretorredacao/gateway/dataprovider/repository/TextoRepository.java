package br.com.corretorredacao.gateway.dataprovider.repository;

import br.com.corretorredacao.domain.entity.TextosInformativos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextoRepository extends JpaRepository<TextosInformativos, Long> {

    List<TextosInformativos> findByTemasId(Long temaId);
}
