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
    sexo VARCHAR(20) NOT NULL,
    nascimento DATE NOT NULL,
    estado_civil VARCHAR(20) NOT NULL,
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
    
CREATE VIEW carrinho AS
	SELECT id_venda, id_produto, produtos.nome, quantidade, produtos.valor, (quantidade * produtos.valor) AS subtotal
	FROM venda_produto 
	INNER JOIN produtos ON produtos.id = id_produto;
    
CREATE VIEW relatorio_vendas AS
    SELECT vendas.id, clientes.cpf, data_venda, valor
	FROM vendas
	INNER JOIN clientes ON id_cliente = clientes.id;
    
CREATE VIEW relatorio_analitico AS
	SELECT vendas.id, data_venda, clientes.nome, clientes.cpf, valor
	FROM vendas
	INNER JOIN clientes ON id_cliente = clientes.id;

DELIMITER $$
CREATE 
    TRIGGER  atualiza_estoque
 AFTER INSERT ON venda_produto FOR EACH ROW 
    BEGIN
    UPDATE produtos 
    SET estoque = estoque - new.quantidade
    WHERE id = new.id_produto; 
    
    END $$
    
DELIMITER ;
    