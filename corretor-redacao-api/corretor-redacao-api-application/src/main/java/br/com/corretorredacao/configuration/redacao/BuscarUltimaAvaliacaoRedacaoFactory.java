package br.com.corretorredacao.configuration.redacao;

import br.com.corretorredacao.domain.gateway.dataprovider.AvaliacaoDataProvider;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoUseCase;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoUseCaseImpl;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.converter.BuscarUltimaAvaliacaoRedacaoOutputDataConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@RequiredArgsConstructor
public class BuscarUltimaAvaliacaoRedacaoFactory {

    private final AvaliacaoDataProvider avaliacaoDataProvider;

    @Bean("BuscarUltimaAvaliacaoRedacaoUseCase")
    @DependsOn("BuscarUltimaAvaliacaoRedacaoOutputDataConverter")
    public BuscarUltimaAvaliacaoRedacaoUseCase createUseCase(BuscarUltimaAvaliacaoRedacaoOutputDataConverter outputDataConverter){
        return new BuscarUltimaAvaliacaoRedacaoUseCaseImpl(
                outputDataConverter,
                avaliacaoDataProvider
        );
    }

    @Bean("BuscarUltimaAvaliacaoRedacaoOutputDataConverter")
    public BuscarUltimaAvaliacaoRedacaoOutputDataConverter createOutputDataConverter(){
        return new BuscarUltimaAvaliacaoRedacaoOutputDataConverter();
    }
}
