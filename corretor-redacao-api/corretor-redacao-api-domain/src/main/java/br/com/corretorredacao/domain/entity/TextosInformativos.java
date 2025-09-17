package br.com.corretorredacao.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "TB_TEXTOS_INFORMATIVOS", schema = "CORRETOR_REDACAO")
@AllArgsConstructor
public class TextosInformativos implements Serializable {
    @Id
    @Column(name = "tx_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tx_titulo")
    private String titulo;

    @Column(name = "tx_texto")
    private String texto;

    @Column(name = "tx_fonte")
    private String fonte;

    @Column(name = "tx_imagem")
    private String imagem;

    @ManyToMany
    @JoinTable(
            name = "tb_tema_texto_informativo",
            joinColumns = @JoinColumn(name = "tx_id"),
            inverseJoinColumns = @JoinColumn(name = "tm_id")
    )

    private List<Tema> temas;
}
