package br.com.corretorredacao.domain.usecase.redacao.salvar;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.salvar.converter.SalvarRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor
public class SalvarRedacaoUseCaseImpl implements SalvarRedacaoUseCase {

    SalvarRedacaoOutputDataConverter salvarRedacaoOutputDataConverter;

    RedacaoDataProvider redacaoDataProvider;

    @Override
    public SalvarRedacaoOutputData execute(SalvarRedacaoInputData salvarRedacaoInputData) {
        Redacao entitdadeRedacao = redacaoDataProvider.BuscarRedacaoPorId(salvarRedacaoInputData.getRedacaoId()).orElseThrow(null);
         entitdadeRedacao = Redacao.builder()
                .id(salvarRedacaoInputData.getRedacaoId())
                .build();
        salvarRedacao(entitdadeRedacao);
//        return salvarRedacaoOutputDataConverter.to();
        return null;
    }

    private void salvarRedacao(Redacao redacao) {
        redacaoDataProvider.SalvarRedacao(redacao);
    }
}
