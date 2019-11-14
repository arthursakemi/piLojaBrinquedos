CREATE DATABASE lojaBrinquedos;

USE lojaBrinquedos;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    marca VARCHAR(20) NOT NULL,
    fornecedor VARCHAR(20) NOT NULL,
    estoque INT NOT NULL,
    valor DOUBLE NOT NULL,
    descricao TEXT,
    PRIMARY KEY (id)
);
 
 CREATE TABLE clientes (
    id INT AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    email VARCHAR(20) NOT NULL,
    cpf NUMERIC(11) NOT NULL UNIQUE,
    sexo VARCHAR(10) NOT NULL,
    nascimento DATE NOT NULL,
    estado_civil VARCHAR(10) NOT NULL,
    celular NUMERIC(11) NOT NULL,
    telefone NUMERIC(10),
    endereco VARCHAR(60) NOT NULL,
    ativo BOOLEAN DEFAULT true,
    PRIMARY KEY (id)
);

CREATE TABLE vendas (
    id INT AUTO_INCREMENT,
    id_cliente INT NOT NULL,
    data_venda DATE NOT NULL,
    valor DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente)
        REFERENCES clientes (id)
);

CREATE TABLE venda_produto (
    id INT AUTO_INCREMENT,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_venda)
        REFERENCES vendas (id),
    FOREIGN KEY (id_produto)
        REFERENCES produtos (id)
);

CREATE VIEW clientes_ativos AS
	SELECT * FROM clientes
    WHERE ativo = true;
    
CREATE VIEW clientes_inativos AS
	SELECT * FROM clientes
    WHERE ativo = false;