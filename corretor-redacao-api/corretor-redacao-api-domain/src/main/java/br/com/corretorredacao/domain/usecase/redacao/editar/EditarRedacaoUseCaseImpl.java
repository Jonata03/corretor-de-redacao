package br.com.corretorredacao.domain.usecase.redacao.editar;

import br.com.corretorredacao.domain.entity.Redacao;
import br.com.corretorredacao.domain.entity.Tema;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.editar.converter.EditarRedacaoOutputDataConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Objects;


@Builder
@AllArgsConstructor
public class EditarRedacaoUseCaseImpl implements EditarRedacaoUseCase {

    private final EditarRedacaoOutputDataConverter salvarRedacaoOutputDataConverter;

    private final RedacaoDataProvider redacaoDataProvider;

    private final TemaDataProvider temaDataProvider;

    @Override
    public EditarRedacaoOutputData execute(EditarRedacaoInputData inputdata) {
        Redacao entidadeRedacao = buscarRedacao(inputdata);
        Tema tema = buscarTema(inputdata);

        salvarRedacao(setarDados(inputdata, tema, entidadeRedacao));

        return null;
    }

    private Redacao buscarRedacao(EditarRedacaoInputData inputdata) {
        return redacaoDataProvider.BuscarRedacaoPorId(inputdata.getRedacaoId()).orElseThrow(() -> new RuntimeException("Redação não encontrada."));
    }

    private Tema buscarTema(EditarRedacaoInputData inputdata) {
        return temaDataProvider.buscarTemaPorId(inputdata.getTemaId()).orElseThrow(() -> new RuntimeException("Tema não Encontrado."));
    }

    private static Redacao setarDados(EditarRedacaoInputData inputdata,
                                      Tema tema,
                                      Redacao entidadeRedacao) {

        if (Objects.nonNull(inputdata.getTexto())){
            entidadeRedacao.setTexto(inputdata.getTexto());
        }

        if(Objects.nonNull(inputdata.getTitulo())){
            entidadeRedacao.setTitulo(inputdata.getTitulo());
        }

        if (Objects.nonNull(tema)){
            entidadeRedacao.setTema(tema);
        }

        entidadeRedacao.setDataAlteracao(LocalDateTime.now());//TODO nao esta pegando o fuso horario correto daria para pegar do front
        entidadeRedacao.setSituacao(Redacao.Situacao.EM_ELABORACAO.name());
        return entidadeRedacao;
    }

    private void salvarRedacao(Redacao redacao) {
        redacaoDataProvider.SalvarRedacao(redacao);
    }
}
