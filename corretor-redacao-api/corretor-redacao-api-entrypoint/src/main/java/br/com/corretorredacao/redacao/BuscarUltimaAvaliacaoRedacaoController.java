package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoInputData;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoOutputData;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.buscarPorId.BuscarUltimaAvaliacaoRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/redacao/avaliar/buscar/ultima/{redacaoId}")
public class BuscarUltimaAvaliacaoRedacaoController {

    private final BuscarUltimaAvaliacaoRedacaoUseCase buscarUltimaAvaliacaoRedacaoUseCase;

    @GetMapping
    public BuscarUltimaAvaliacaoRedacaoOutputData execute(@PathVariable("redacaoId") Long redacaoId,
                                                          BuscarUltimaAvaliacaoRedacaoInputData inputData){
        inputData.setRedacaoId(redacaoId);
        return buscarUltimaAvaliacaoRedacaoUseCase.execute(inputData);
    }
}
