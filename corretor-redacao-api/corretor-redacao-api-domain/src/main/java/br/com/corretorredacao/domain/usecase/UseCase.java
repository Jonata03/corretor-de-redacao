package br.com.corretorredacao.domain.usecase;

public interface UseCase<INPUT, OUTPUT>{
    OUTPUT execute(INPUT input);
}
