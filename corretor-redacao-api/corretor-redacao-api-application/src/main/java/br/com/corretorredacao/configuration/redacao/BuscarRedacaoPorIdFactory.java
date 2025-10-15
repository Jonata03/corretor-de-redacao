package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdUseCase;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.converter.BuscarRedacaoPorIdOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class BuscarRedacaoPorIdFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    @Bean("BuscarRedacaoPorIdUseCase")
    @DependsOn("BuscarRedacaoPorIdOutputDataConverter")
    public BuscarRedacaoPorIdUseCase createUseCase(BuscarRedacaoPorIdOutputDataConverter outputDataConverter){
        return new BuscarRedacaoPorIdUseCaseImpl(
                redacaoDataProvider,
                outputDataConverter
        );
    }

    @Bean("BuscarRedacaoPorIdOutputDataConverter")
    public BuscarRedacaoPorIdOutputDataConverter BuscarRedacaoPorIdOutputDataConverter(){
        return new BuscarRedacaoPorIdOutputDataConverter();
    }
}
