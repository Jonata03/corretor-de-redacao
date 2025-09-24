package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.salvar.converter.SalvarRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class SalvarRedacaoFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    private final TemaDataProvider temaDataProvider;

    @Bean("SalvarRedacaoUseCase")
    @DependsOn("SalvarRedacaoOutputDataConverter")
    public SalvarRedacaoUseCase createUseCase(SalvarRedacaoOutputDataConverter outputDataConverter){
        return new SalvarRedacaoUseCaseImpl(
                outputDataConverter,
                redacaoDataProvider,
                temaDataProvider
        );
    }

    @Bean("SalvarRedacaoOutputDataConverter")
    public SalvarRedacaoOutputDataConverter createOutputDataConverter(){
        return new SalvarRedacaoOutputDataConverter();
    }
}
