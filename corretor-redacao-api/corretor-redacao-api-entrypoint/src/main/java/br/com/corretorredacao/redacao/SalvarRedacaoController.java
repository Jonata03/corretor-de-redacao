package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoInputData;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoOutputData;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redacao/escrita/salvar/{redacao}")
public class SalvarRedacaoController {
    private final SalvarRedacaoUseCase salvarRedacaoUseCase;

    @PostMapping
    @Transactional
    public SalvarRedacaoOutputData execute(@PathVariable Long redacao, @RequestBody SalvarRedacaoInputData inputData){
        inputData.setRedacaoId(redacao);

        return salvarRedacaoUseCase.execute(inputData);
    }
}
