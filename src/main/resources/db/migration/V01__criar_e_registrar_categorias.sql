CREATE TABLE categoria(
	codigo BIGINT(20) primary key AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
);


INSERT INTO CATEGORIA (NOME) VALUES('Lazer');
INSERT INTO CATEGORIA (NOME) VALUES('Alimentação');
INSERT INTO CATEGORIA (NOME) VALUES('Supermercado');
INSERT INTO CATEGORIA (NOME) VALUES('Farmácia');
INSERT INTO CATEGORIA (NOME) VALUES('Outros');