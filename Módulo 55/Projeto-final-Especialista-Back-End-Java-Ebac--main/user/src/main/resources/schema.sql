CREATE SEQUENCE sequence_user START WITH 1 INCREMENT BY 50;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   data_register DATE DEFAULT CURRENT_DATE,
   CONSTRAINT pk_users PRIMARY KEY (id)
);
--
--INSERT INTO users (name, email, data_register) VALUES ('BellaCMeireles', 'isac20@gmail.com', NOW());
