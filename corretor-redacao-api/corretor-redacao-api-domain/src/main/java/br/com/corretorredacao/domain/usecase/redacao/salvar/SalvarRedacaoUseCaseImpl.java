package br.com.corretorredacao.domain.usecase.redacao.salvar;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.entity.Tema;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.salvar.converter.SalvarRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
public class SalvarRedacaoUseCaseImpl implements SalvarRedacaoUseCase {

    private final SalvarRedacaoOutputDataConverter salvarRedacaoOutputDataConverter;

    private final RedacaoDataProvider redacaoDataProvider;

    private final TemaDataProvider temaDataProvider;

    @Override
    public SalvarRedacaoOutputData execute(SalvarRedacaoInputData inputData) {
        Tema tema = retornarTemaSelecionado(inputData.getTemaId());

        Redacao entidadeRedacao = criarEntidadeRedacao(tema);

        Redacao redacaoSalva = salvarRedacao(entidadeRedacao);

        return salvarRedacaoOutputDataConverter.to(redacaoSalva);
    }

    private static Redacao criarEntidadeRedacao(Tema tema) {
        return Redacao.builder()
                .tema(tema)
                .dataCadastro(LocalDateTime.now())
                .dataAlteracao(LocalDateTime.now())
                .situacao(Redacao.Situacao.EM_ELABORACAO.name())
                .build();
    }

    private Tema retornarTemaSelecionado(Long temaId) {
        return temaDataProvider.buscarTemaPorId(temaId).orElseThrow(() -> new RuntimeException("Tema Não Encontrado"));
    }

    private Redacao salvarRedacao(Redacao redacao) {
        return redacaoDataProvider.salvarRedacao(redacao);
    }
}
