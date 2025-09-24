package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.editar.EditarRedacaoInputData;
import br.com.corretorredacao.domain.usecase.redacao.editar.EditarRedacaoOutputData;
import br.com.corretorredacao.domain.usecase.redacao.editar.EditarRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/redacao/escrita/editar/{redacaoId}")
public class EditarRedacaoController {

    private final EditarRedacaoUseCase editarRedacaoUseCase;

    @PutMapping
    @Transactional
    public EditarRedacaoOutputData execute(@PathVariable("redacaoId") Long redacaoId, @RequestBody EditarRedacaoInputData inputData){
        inputData.setRedacaoId(redacaoId);

        return editarRedacaoUseCase.execute(inputData);
    }
}
