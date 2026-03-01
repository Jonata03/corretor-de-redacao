CREATE DATABASE IF NOT EXISTS corretor_redacao;
USE corretor_redacao;

START TRANSACTION;
CREATE TABLE tb_tema
(
    tm_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    tm_titulo        VARCHAR(255),
    tm_dthr_cadastro DATETIME NULL
);

CREATE TABLE tb_textos_informativos
(
    tx_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    tx_titulo VARCHAR(255),
    tx_texto  TEXT,
    tx_fonte  TEXT,
    tx_imagem  VARCHAR(255)
);

CREATE TABLE tb_tema_texto_informativo
(
    tm_id BIGINT NOT NULL,
    tx_id BIGINT NOT NULL,
    PRIMARY KEY (tm_id, tx_id),
    CONSTRAINT fk_tema FOREIGN KEY (tm_id) REFERENCES tb_tema (tm_id) ON DELETE CASCADE,
    CONSTRAINT fk_texto_informativo FOREIGN KEY (tx_id) REFERENCES tb_textos_informativos (tx_id) ON DELETE CASCADE
);

CREATE TABLE tb_redacao
(
    re_id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    re_titulo        VARCHAR(255),
    tm_id            BIGINT   NOT NULL,
    re_texto         TEXT,
    re_situacao      VARCHAR(50),
    re_dthr_cadastro DATETIME NULL,
    re_dthr_alteracao DATETIME,
    CONSTRAINT fk_redacao_tema FOREIGN KEY (tm_id) REFERENCES tb_tema (tm_id)
);

CREATE TABLE tb_avaliacao
(
    av_id                         BIGINT AUTO_INCREMENT PRIMARY KEY,
    re_id                         BIGINT   NOT NULL,
    av_competencia1_nota          DECIMAL(14, 3),
    av_competencia1_justificativa TEXT,
    av_competencia2_nota          DECIMAL(14, 3),
    av_competencia2_justificativa TEXT,
    av_competencia3_nota          DECIMAL(14, 3),
    av_competencia3_justificativa TEXT,
    av_competencia4_nota          DECIMAL(14, 3),
    av_competencia4_justificativa TEXT,
    av_competencia5_nota          DECIMAL(14, 3),
    av_competencia5_justificativa TEXT,
    av_nota_total                 DECIMAL(14, 3),
    av_dthr_avaliacao             DATETIME NULL,
    CONSTRAINT fk_avaliacao_redacao FOREIGN KEY (re_id) REFERENCES tb_redacao (re_id)
);

INSERT INTO tb_tema (tm_titulo,
                     tm_dthr_cadastro)
VALUES ('Tema Livre',NOW()),
 ('Desafios para a valorização da herança africana no Brasil',NOW());

INSERT INTO tb_textos_informativos (tx_titulo,
                                    tx_texto,
                                    tx_fonte,
                                    tx_imagem)
VALUES ('História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
        'As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava
        em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra
        a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do
        período escravocrata. Não se falava na escola sobre temas como a história e a cultura
        afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama
        e Carolina Maria de Jesus.\n
        A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em
        sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas
        pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia
        da escola.',
        'Disponível em: https://jornal.unesp.br. Acesso em: 3 jun. 2024 (adaptado).',
        ''),

       ('Herança',
        'Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
        'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).',''),

    ('','','PAULINO, R.Ainda a lamentar. In: GONÇALVES,A. M. Um defeito de cor: romance. Rio de Janeiro: Record, 2024 (adaptado).','texto/tema1-texto3.png'),

       ('',
        'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito
        de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura
        a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu
        essa cultura.',
        'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.',
        ''),

       ('Histórias para ninar gente grande',
        'Brasil, meu nego\n
        Deixa eu te contar\n
        A história que a história não conta\n
        O avesso do mesmo lugar\n
        Na luta é que a gente se encontra\n\n
        Brasil, meu dengo\n
        A Mangueira chegou\n
        Com versos que o livro apagou\n
        Desde 1500 tem mais invasão do que descobrimento\n\n
        Tem sangue retinto pisado\n
        Atrás do herói emoldurado\n
        Mulheres, tamoios, mulatos\n
        Eu quero um país que não está no retrato\n\n
        Brasil, o teu nome é Dandara\n
        E a tua cara é de cariri\n
        Não veio do céu\n
        Nem das mãos de Isabel\n
        A liberdade é um dragão no mar de Aracati\n\n
        Salve os caboclos de julho\n
        Quem foi de aço nos anos de chumbo\n
        Brasil, chegou a vez\n
        De ouvir as Marias, Mahins, Marielles, malês',
        'Disponível em: www.mangueira.com.br. Acesso em: 30 maio 2024 (fragmento).',
        ''),

    ('Alunos de escola municipal conhecem pontos do Rio que retratam relação com a África',
     'Alunos admiram grafite de Zumbi dos Palmares na Pedra do Sal.',
     'Disponível em: www.oglobo.com. Acesso em: 29 maio 2024 (adaptado).',
     '/texto/tema1-texto6.png'),

    ('','Sinta-se à vontade para escrever sobre um tema qualquer.','','');


insert into tb_tema_texto_informativo (tm_id, tx_id)
    values
        (2, 1),
        (2, 2),
        (2, 3),
        (2, 4),
        (2, 5),
        (2, 6),
        (1, 7);

COMMIT;