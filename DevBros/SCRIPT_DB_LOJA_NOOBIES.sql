DROP DATABASE db_loja_noobies;

CREATE DATABASE DB_LOJA_NOOBIES;

USE DB_LOJA_NOOBIES;

DROP TABLE TB_CLIENTES;

CREATE TABLE TB_CLIENTES(
	COD_CLIENTE INT NOT NULL AUTO_INCREMENT,
	NOME_CLIENTE VARCHAR(100) NOT NULL,
	CPF_CLIENTE VARCHAR(11) NOT NULL UNIQUE,    
    TELEFONE_CLIENTE INT(20) NOT NULL,
    EMAIL_CLIENTE VARCHAR(50) NOT NULL,
    
    CONSTRAINT PK_CLIENTE PRIMARY KEY(COD_CLIENTE)
);

CREATE TABLE TB_FUNCIONARIOS(
	COD_FUNCIONARIO INT NOT NULL AUTO_INCREMENT,
    LOGIN_SIST VARCHAR(20) NOT NULL,
    SENHA_SIST VARCHAR(20) NOT NULL,
	NOME_FUNCIONARIO VARCHAR(100) NOT NULL,
    CPF_FUNCIONARIO BIGINT(11) NOT NULL,
	RG_FUNCIONARIO INT(9) NOT NULL,
	DATA_NASCIMENTO DATE,
    FILIAL_FUNCIONARIO VARCHAR (28),
    CARGO_FUNCIONARIO VARCHAR (20) NOT NULL,

	CONSTRAINT PK_FUNCIONARIOS PRIMARY KEY(COD_FUNCIONARIO)
);
    
CREATE TABLE TB_PRODUTOS(
	COD_PRODUTO INT NOT NULL AUTO_INCREMENT,
    
    NOME_PRODUTO VARCHAR(100) NOT NULL,
    DESCRICAO VARCHAR(100) NOT NULL,
    VALOR_COMPRA DECIMAL (10,2) NOT NULL,
    VALOR_VENDA DECIMAL (10,2) NOT NULL,
    QUANTIDADE INT NOT NULL,
    CATEGORIA VARCHAR(100) NOT NULL,
    
	CONSTRAINT PK_PRODUTOS PRIMARY KEY(COD_PRODUTO)
);
    
SELECT * FROM TB_CLIENTES;


INSERT INTO TB_CLIENTES (NOME_CLIENTE, CPF_CLIENTE, TELEFONE_CLIENTE, EMAIL_CLIENTE) VALUES ("Gb", "36799329873", "11973111852", "gabriela@plusoft.com.br");