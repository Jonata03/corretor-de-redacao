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
@Table(name = "TB_AVALIACAO", schema = "CORRETOR_REDACAO")
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "dataAvaliacao", column = @Column(name = "av_dthr_avaliacao")),
})

public class Avaliacao implements Serializable {
    @Id
    @Column(name = "av_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "av_competencia1_nota")
    private Float competenciaUmNota;

    @Column(name = "av_competencia1_justificativa")
    private String competenciaUmJustificativa;

    @Column(name = "av_competencia2_nota")
    private Float competenciaDoisNota;

    @Column(name = "av_competencia2_justificativa")
    private String competenciaDoisJustificativa;

    @Column(name = "av_competencia3_nota")
    private Float competenciaTresNota;

    @Column(name = "av_competencia3_justificativa")
    private String competenciaTresJustificativa;

    @Column(name = "av_competencia4_nota")
    private Float competenciaQuatroNota;

    @Column(name = "av_competencia4_justificativa")
    private String competenciaQuatroJustificativa;

    @Column(name = "av_competencia5_nota")
    private Float competenciaCincoNota;

    @Column(name = "av_competencia5_justificativa")
    private String competenciaCincoJustificativa;

    @Column(name = "av_nota_total")
    private Float notaTotal;

    @Column(name = "av_dthr_cadastro")
    private LocalDateTime dataAvaliacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "re_id")
    private Redacao redacao;

}
