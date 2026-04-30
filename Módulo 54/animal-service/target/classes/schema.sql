CREATE TABLE animal (
  id INT AUTO_INCREMENT NOT NULL,
  nome_provisorio VARCHAR(255) NOT NULL,
  idade_estimada INT NOT NULL,
  raca VARCHAR(255) NOT NULL,
  data_entrada date NOT NULL,
  data_adocao date,
  condicoes_chegadas VARCHAR(255) NOT NULL,
  nome_recebedor VARCHAR(255) NOT NULL,
  porte VARCHAR(255) NOT NULL,
  CONSTRAINT pk_animal PRIMARY KEY (id)
);