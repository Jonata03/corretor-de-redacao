package br.com.corretorredacao.redacao;

import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoOutputData;
import br.com.corretorredacao.domain.usecase.redacao.buscar.BuscarRedacaoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/redacao/buscar")
@RequiredArgsConstructor
public class BuscarRedacaoController {

    private final BuscarRedacaoUseCase buscarRedacaoUseCase;

    @GetMapping
    public BuscarRedacaoOutputData execute(){
        return buscarRedacaoUseCase.execute();
    }
}
