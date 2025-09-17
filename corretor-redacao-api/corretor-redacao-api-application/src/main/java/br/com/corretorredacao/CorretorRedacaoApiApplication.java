package br.com.corretorredacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "br.com.corretorredacao")
public class CorretorRedacaoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CorretorRedacaoApiApplication.class, args);
    }

}
