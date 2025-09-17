package br.com.corretorredacao.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.TextosInformativos;
import br.com.corretorredacao.domain.gateway.dataprovider.TextosInformativosDataProvider;
import br.com.corretorredacao.gateway.dataprovider.repository.TextoRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TextosInformativosDataProviderImpl implements TextosInformativosDataProvider {
    private final TextoRepository textoRepository;

    private final EntityManager entityManager;

    @Override
    public List<TextosInformativos> buscarTextosInformativosPorTemaId(Long temaId){
        return textoRepository.findByTemasId(temaId);
    }
}
