package br.com.corretorredacao.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "TB_REDACAO", schema = "CORRETOR_REDACAO")
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "dataCadastro", column = @Column(name = "re_dthr_cadastro")),
})

public class Redacao implements Serializable {
    @Id
    @Column(name = "re_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "re_titulo")
    private String titulo;

    @Column(name = "re_tema")
    private String tema;

    @Column(name = "re_texto")
    private String texto;

    @Column(name = "re_status")
    private Situacao status;

    @Column(name = "re_dthr_cadastro")
    private LocalDateTime dataCadastro;

    public enum Situacao {
        PENDENTE,
        EM_AVALIACAO,
        AVALIADA,
        EM_ELABORACAO,
        FINALIZADA
    }
}
