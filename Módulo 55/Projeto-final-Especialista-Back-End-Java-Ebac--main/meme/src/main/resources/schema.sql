CREATE SEQUENCE sequence_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE meme (
    id BIGINT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_cadastro date NOT NULL,
    url VARCHAR(255) NOT NULL,
    categoria_meme_id BIGINT,
    usuario_id BIGINT,
    CONSTRAINT pk_meme PRIMARY KEY (id)
    );
INSERT
INTO
  meme
  (nome, descricao, data_cadastro, url, usuario_id, categoria_meme_id)
VALUES
  ('MemeTeste', 'rir muito', current_date, 'https://images.app.goo.gl/wVCM7SWpgPG7g9WW8', 1, 1);