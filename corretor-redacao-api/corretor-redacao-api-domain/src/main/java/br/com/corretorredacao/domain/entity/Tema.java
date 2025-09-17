package br.com.corretorredacao.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "TB_TEMA", schema = "CORRETOR_REDACAO")
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "dataCadastro", column = @Column(name = "tm_dthr_cadastro")),
})

public class Tema implements Serializable {
    @Id
    @Column(name = "tm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tm_titulo")
    private String titulo;

    @Column(name = "tm_dthr_cadastro")
    private LocalDateTime dataCadastro;

    @ManyToMany(mappedBy = "temas")
    private List<TextosInformativos> textosInformativos;
}
