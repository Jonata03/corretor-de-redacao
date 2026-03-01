package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.AvaliarRedacaoInputData;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.AvaliarRedacaoOutputData;
import br.com.corretorredacao.domain.usecase.redacao.avaliar.avaliar.AvaliarRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/redacao/avaliar/{redacaoId}")
public class AvaliarRedacaoController {

    private final AvaliarRedacaoUseCase avaliarRedacaoUseCase;

    @PutMapping
    @Transactional
    public AvaliarRedacaoOutputData execute(@PathVariable("redacaoId") Long redacaoId, @RequestBody AvaliarRedacaoInputData inputData){
        inputData.setRedacaoId(redacaoId);

        return avaliarRedacaoUseCase.execute(inputData);
    }
}
