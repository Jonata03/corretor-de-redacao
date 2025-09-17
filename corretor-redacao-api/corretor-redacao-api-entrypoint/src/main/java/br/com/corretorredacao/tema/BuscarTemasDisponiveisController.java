package br.com.corretorredacao.tema;

import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.BuscarTemasDisponiveisOutputData;
import br.com.corretorredacao.domain.usecase.tema.buscar.buscartudo.BuscarTemasDisponiveisUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/redacao/temas")
@RequiredArgsConstructor
public class BuscarTemasDisponiveisController {
    private final BuscarTemasDisponiveisUseCase buscarTemasDisponiveisUseCase;

    @GetMapping
    public BuscarTemasDisponiveisOutputData execute(){
        return buscarTemasDisponiveisUseCase.execute();
    }
}
