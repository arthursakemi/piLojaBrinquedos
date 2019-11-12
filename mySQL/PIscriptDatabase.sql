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

INSERT INTO clientes (nome, email, cpf, sexo, nascimento, estado_civil, celular, telefone, endereco)
VALUES
('Ozzy Osbourne', 'ozzy@mail.com', 11111111111, 'Masculino', '2001-01-01', 'Solteiro', 11111111111, NULL ,'Rua 1, 01'),
('Zakk Wylde', 'zakk@mail.com', 22222222222, 'Masculino', '2002-02-02', 'Divorciado', 22222222222, NULL ,'Rua 2, 02'),
('Corey Taylor', 'corey@mail.com', 33333333333, 'Masculino', '2003-03-03', 'Casado', 33333333333, NULL ,'Rua 3, 03'),
('Joan Jett', 'joan@mail.com', 44444444444, 'Masculino', '2004-04-04', 'Viuva', 44444444444, NULL ,'Rua 4, 04'),
('Floor Jansen', 'floor@mail.com', 55555555555, 'Masculino', '2005-05-05', 'Solteira', 55555555555, NULL ,'Rua 4, 04');

INSERT INTO produtos (nome, marca, fornecedor, estoque, valor, descricao)
VALUES
('Eldritch Horror - Tabuleiro', 'Fantasy Flight', 'Galapagos Jogos', 4, 349.90, 'O Fim do Mundo Se Aproxima! O ano é 1926, e um ser ancestral de poder incomensurável ameaça despertar de seu longo descanso, deixando um rastro de morte e loucura. Eldritch Horror é um jogo de aventura cooperativo de 1 a 8 jogadores inspirado no jogo best-seller Arkham Horror.' ),
('War - Tabuleiro', 'Grow', 'Grow', 3, 74.61, 'Cada jogador precisa usar toda sua habilidade militar para conquistar territórios e continentes e derrotar seus adversários.'),
('Imagem & Ação - Tabuleiro', 'Grow', 'Grow', 3, 87.99, 'Jogo de desenho e adivinhação, agora com um timer que derruba uma carta por vez, fazendo de cada partida uma corrida contra o tempo!'),
('Gurps - RPG', 'Steve Jackson Games', 'Devir', 2, 89.00, 'GURPS – ou Generic Universal Role-Playing System – foi criado para ser um game universal, totalmente genérico e que permite muitas adaptações. Com um dos livros da série em mãos, os jogadores aproveitam qualquer gênero de jogo (desde fantasia até terror) em mundos infinitos e com diversas variações.'),
('Vampiro A Máscara - RPG', 'White Wolf', 'Devir', 3, 149.90, 'Criado em 1991 pelo designer de jogos Mark Rein-Hagen, o jogo, que foi percursor do sistema Storyteller, foca na temática dos vampiros e explora diversas nuances em um mundo punk-gótico, como: horror, depravação, salvação e a condição humana.'),
('Pathfinder - RPG', 'Paizo', 'Devir', 1, 143.45, 'Na história, os jogadores assumem o papel de aventureiros que estão lutando para sobreviver em um mundo mergulhado em maldade e magia, com muitas possibilidades de cenários, histórias e personagens.');