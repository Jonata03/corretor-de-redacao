package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdInputData;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdOutputData;
import br.com.corretorredacao.domain.usecase.redacao.buscarPorId.BuscarRedacaoPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/redacao/buscar/{redacaoId}")
@RequiredArgsConstructor
public class BuscarRedacaoPorIdController {

    private final BuscarRedacaoPorIdUseCase buscarRedacaoPorIdUseCase;

    @GetMapping
    public BuscarRedacaoPorIdOutputData execute(@PathVariable("redacaoId") Long redacaoId,
                                                BuscarRedacaoPorIdInputData inputData) {
        inputData.setRedacaoId(redacaoId);
        return buscarRedacaoPorIdUseCase.execute(inputData);
    }
}
