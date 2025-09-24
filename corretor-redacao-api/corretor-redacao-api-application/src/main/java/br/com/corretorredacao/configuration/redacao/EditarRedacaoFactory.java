package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.editar.EditarRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.editar.EditarRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.editar.converter.EditarRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class EditarRedacaoFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    private final TemaDataProvider temaDataProvider;

    @Bean("EditarRedacaoUseCase")
    @DependsOn("EditarRedacaoOutputDataConverter")
    public EditarRedacaoUseCase createUseCase(EditarRedacaoOutputDataConverter outputDataConverter){
        return new EditarRedacaoUseCaseImpl(
                outputDataConverter,
                redacaoDataProvider,
                temaDataProvider
        );
    }

    @Bean("EditarRedacaoOutputDataConverter")
    public EditarRedacaoOutputDataConverter createOutputDataConverter(){
        return new EditarRedacaoOutputDataConverter();
    }
}
