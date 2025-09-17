package br.com.corretorredacao.configuration.tema;

import br.com.corretorredacao.domain.gateway.dataprovider.TemaDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.TextosInformativosDataProvider;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.BuscarTemasDisponiveisUseCase;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.BuscarTemasDisponiveisUseCaseImpl;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.converter.BuscarTemasDisponiveisOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class BuscarTemasDisponiveisFactory {

    private final TemaDataProvider temaDataProvider;

    private final TextosInformativosDataProvider textosInformativosDataProvider;

    @Bean("BuscarTemasDisponiveisUseCase")
    @DependsOn("BuscarTemasDisponiveisOutputDataConverter")
    public BuscarTemasDisponiveisUseCase createUseCase(BuscarTemasDisponiveisOutputDataConverter outputDataConverter){
        return new BuscarTemasDisponiveisUseCaseImpl(
                temaDataProvider,
                outputDataConverter,
                textosInformativosDataProvider
                );
    }

    @Bean("BuscarTemasDisponiveisOutputDataConverter")
    public BuscarTemasDisponiveisOutputDataConverter createConverter(){
        return new BuscarTemasDisponiveisOutputDataConverter();
    }
}
