package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoInputData;
import br.com.corretorredacao.domain.usecase.redacao.salvar.SalvarRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/redacao/escrita/salvar")
public class SalvarRedacaoController {

    private final SalvarRedacaoUseCase salvarRedacaoUseCase;

    @PostMapping
    @Transactional
    public void execute(@RequestBody SalvarRedacaoInputData inputData){

        salvarRedacaoUseCase.execute(inputData);
    }
}
