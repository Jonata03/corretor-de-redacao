package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.AvaliacaoDataProvider;
import br.com.corretorredacao.domain.gateway.dataprovider.RedacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.AvaliarRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.AvaliarRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.converter.AvaliarRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class AvaliarRedacaoFactory {

    private final RedacaoDataProvider redacaoDataProvider;

    private final AvaliacaoDataProvider avaliacaoDataProvider;

    @Bean("AvaliarRedacaoUseCase")
    @DependsOn("AvaliarRedacaoOutputDataConverter")
    public AvaliarRedacaoUseCase createUseCase(AvaliarRedacaoOutputDataConverter outputDataConverter){
        return new AvaliarRedacaoUseCaseImpl(
                outputDataConverter,
                redacaoDataProvider,
                avaliacaoDataProvider
        );
    }

    @Bean("AvaliarRedacaoOutputDataConverter")
    public AvaliarRedacaoOutputDataConverter createOutputDataConverter(){
        return new AvaliarRedacaoOutputDataConverter();
    }
}
