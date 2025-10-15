package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.buscar.converter.BuscarRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class BuscarRedacaoFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    @Bean("BuscarRedacaoUseCase")
    @DependsOn("BuscarRedacaoOutputDataConverter")
    public BuscarRedacaoUseCase createUseCase(BuscarRedacaoOutputDataConverter outputDataConverter){
        return new BuscarRedacaoUseCaseImpl(
                redacaoDataProvider,
                outputDataConverter
        );
    }

    @Bean("BuscarRedacaoOutputDataConverter")
    public BuscarRedacaoOutputDataConverter createOutputDataConverter(){
        return new BuscarRedacaoOutputDataConverter();
    }
}
