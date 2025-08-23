package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.salvar.converter.SalvarRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class SalvarRedacaoFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    @Bean("SalvarRedacaoUseCase")
    @DependsOn("SalvarRedacaoOutputDataConverter")
    public SalvarRedacaoUseCase createUseCase(SalvarRedacaoOutputDataConverter outputDataConverter){
        return new SalvarRedacaoUseCaseImpl(
                outputDataConverter,
                redacaoDataProvider
        );
    }

    @Bean("SalvarRedacaoOutputDataConverter")
    public SalvarRedacaoOutputDataConverter createOutputDataConverter(){
        return new SalvarRedacaoOutputDataConverter();
    }
}
