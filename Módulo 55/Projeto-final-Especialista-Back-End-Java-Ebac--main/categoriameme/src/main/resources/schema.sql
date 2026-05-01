CREATE SEQUENCE sequence_category START WITH 1 INCREMENT BY 50;

CREATE TABLE category_meme (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(100) NOT NULL,
   descricao VARCHAR(100) NOT NULL,
   data_cadastro date DEFAULT CURRENT_DATE,
   usuario_id BIGINT,
   CONSTRAINT pk_categorymeme PRIMARY KEY (id)
);

INSERT
INTO
  category_meme
  (name, descricao, data_cadastro, usuario_id)
VALUES
  ('CategoriaMemeTest', 'Rir muito', current_date, 1);