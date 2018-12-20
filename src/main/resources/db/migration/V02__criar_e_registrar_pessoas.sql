CREATE TABLE pessoa(
	codigo BIGINT(20) primary key AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
    numero VARCHAR(10) not null,
    complemento VARCHAR(20),
    bairro VARCHAR(20),
    cep varchar(10) not null,
    cidade varchar(20),
    estado varchar(20),
    ativo boolean
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Elias', 'Dezenove de Fevereiro', '10A','067676-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Jenny', 'Silviano Junuir', '22','332214-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Rogerio', 'Juliano silva', '33','232131-19', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Roberto', 'favio souza', '46','176892-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Kety', 'salvo otaviano', '29','190456-99', false);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Maria', 'Joao pereira', '66','312345-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Douglas', 'fernando araujo', '72','121325-39', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Fernando', 'Jd.Aracati', '11','311914-99', false);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Miria', 'cardoso silva', '73','123414-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('Vanda', 'capao redondo', '3','058810-99', true);
INSERT INTO pessoa (NOME, LOGRADOURO, NUMERO, CEP, ATIVO) VALUES('flavio', 'jair souza', '2','997214-99',false);