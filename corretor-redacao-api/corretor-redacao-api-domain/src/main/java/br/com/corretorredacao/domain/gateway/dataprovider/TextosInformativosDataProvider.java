package br.com.corretorredacao.domain.gateway.dataprovider;

import br.com.corretorredacao.domain.entity.TextosInformativos;

import java.util.List;

public interface TextosInformativosDataProvider {

    List<TextosInformativos> buscarTextosInformativosPorTemaId(Long temaId);

}
