CREATE TABLE corretor_redacao.tb_redacao (
    re_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    re_titulo VARCHAR(255),
    re_tema VARCHAR(255),
    re_texto TEXT NOT NULL,
    re_status VARCHAR(50),
    re_dthr_cadastro DATETIME NULL
);

CREATE TABLE corretor_redacao.tb_avaliacao (
    av_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    re_id BIGINT NOT NULL,
    av_competencia1_nota DECIMAL(14,3),
    av_competencia1_justificativa TEXT,
    av_competencia2_nota DECIMAL(14,3),
    av_competencia2_justificativa TEXT,
    av_competencia3_nota DECIMAL(14,3),
    av_competencia3_justificativa TEXT,
    av_competencia4_nota DECIMAL(14,3),
    av_competencia4_justificativa TEXT,
    av_competencia5_nota DECIMAL(14,3),
    av_competencia5_justificativa TEXT,
    av_nota_total DECIMAL(14,3),
    av_dthr_avaliacao DATETIME NULL,
    CONSTRAINT fk_avaliacao_redacao FOREIGN KEY (re_id) REFERENCES corretor_redacao.tb_redacao(re_id)
);

