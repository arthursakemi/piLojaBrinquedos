/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.ClienteModel;
import model.ProdutoModel;
import model.VendaModel;
import util.Utilidades;

public class SimulaDB {

    private static SimulaDB mockdb;

    private ArrayList<ClienteModel> listaClientes;
    private ArrayList<ProdutoModel> listaProdutos;
    private ArrayList<VendaModel> listaVendas;
    private ArrayList<String[]> carrinho1;
    private ArrayList<String[]> carrinho2;

    private SimulaDB() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaVendas = new ArrayList<>();
        carrinho1 = new ArrayList<>();
        carrinho2 = new ArrayList<>();

        listaProdutos.add(new ProdutoModel(10, "Boneco Homem Aranha", "Pizi Toys", "Pizi Toys", 2, 59.99, " Apresenta um visual inspirado no cinema com cinco pontos de articulação"));
        listaProdutos.add(new ProdutoModel(11, "War - Tabuleiro", "Grow", "Grow", 2, 74.61, "Cada jogador precisa usar toda sua habilidade militar para conquistar territórios e continentes e derrotar seus adversários."));
        listaProdutos.add(new ProdutoModel(12, "Imagem & Ação - Tabuleiro", "Grow", "Grow", 2, 87.99, "Jogo de desenho e adivinhação, agora com um timer que derruba uma carta por vez, fazendo de cada partida uma corrida contra o tempo!"));
        listaProdutos.add(new ProdutoModel(13, "Gurps - RPG", "Steve Jackson Games", "Devir", 2, 89.00, "GURPS – ou Generic Universal Role-Playing System – foi criado para ser um game universal, totalmente genérico e que permite muitas adaptações. Com um dos livros da série em mãos, os jogadores aproveitam qualquer gênero de jogo (desde fantasia até terror) em mundos infinitos e com diversas variações."));
        listaProdutos.add(new ProdutoModel(14, "Vampiro A Máscara - RPG", "White Wolf", "Devir", 2, 149.90, "Criado em 1991 pelo designer de jogos Mark Rein-Hagen, o jogo, que foi percursor do sistema Storyteller, foca na temática dos vampiros e explora diversas nuances em um mundo punk-gótico, como: horror, depravação, salvação e a condição humana."));

        listaClientes.add(new ClienteModel(10, "Bob", "bob@mail.com", "11111111111", "Masculino", "01/01/2001", "Solteiro", "11111111111", "", "Rua 1, 01"));
        listaClientes.add(new ClienteModel(11, "Zakk", "zakk@mail.com", "22222222222", "Masculino", "02/02/2002", "Divorciado", "12222222222", "", "Rua 2, 02"));
        listaClientes.add(new ClienteModel(12, "Jack", "jack@mail.com", "33333333333", "Masculino", "03/03/2003", "Casado", "1333333333", "", "Rua 3, 03"));
        listaClientes.add(new ClienteModel(13, "Meggy", "meggy@mail.com", "44444444444", "Feminino", "04/04/2004", "Solteira", "14444444444", "", "Rua 4, 04"));
        listaClientes.add(new ClienteModel(14, "Laura", "laura@mail.com", "55555555555", "Feminino", "05/05/2005", "Viuva", "15555555555", "", "Rua 5, 05"));

        String[] item1 = {"13", "Gurps - RPG", "1", "89.00", "89.00"},
                item2 = {"14", "Vampiro A Máscara - RPG", "1", "149.90", "149.90"},
                item3 = {"11", "War - Tabuleiro", "1", "74.61", "74.61"};

        carrinho1.add(item1);
        carrinho1.add(item2);

        carrinho2.add(item3);

        listaVendas.add(new VendaModel(10, 13, "01/10/2016", "Meggy", "44444444444", carrinho2, 74.61));
        listaVendas.add(new VendaModel(11, 14, "16/07/2015", "Laura", "55555555555", carrinho1, 238.90));
        listaVendas.add(new VendaModel(12, 11, "30/10/2016", "Zakk", "22222222222", carrinho2, 74.61));

    }

    public static synchronized SimulaDB getInstance() {
        if (mockdb == null) {
            mockdb = new SimulaDB();
        }
        return mockdb;
    }

    public boolean salvarCliente(ClienteModel c) {
        listaClientes.add(c);

        return true;
    }

    public boolean salvarProduto(ProdutoModel p) {
        listaProdutos.add(p);

        return true;
    }

    public boolean salvarVenda(VendaModel v) {
        listaVendas.add(v);

        return true;
    }

    public ArrayList<ClienteModel> getClientes() {
        return this.listaClientes;
    }

    public ArrayList<ProdutoModel> getProdutos() {
        return this.listaProdutos;
    }

    public ArrayList<VendaModel> getVendas() {
        return this.listaVendas;
    }

    public ArrayList<ProdutoModel> buscaProduto(int id) {
        ArrayList<ProdutoModel> resultado = new ArrayList<>();

        for (ProdutoModel p : listaProdutos) {
            if (p.getId() == id) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public ArrayList<ProdutoModel> buscaProduto(String nome) {
        ArrayList<ProdutoModel> resultado = new ArrayList<>();

        for (ProdutoModel p : listaProdutos) {
            if (p.getNome().toLowerCase().contains(nome)) {
                resultado.add(p);
            }
        }

        return resultado;
    }

    public ArrayList<ClienteModel> buscaCliente(int id) {
        ArrayList<ClienteModel> resultado = new ArrayList<>();

        for (ClienteModel c : listaClientes) {
            if (c.getId() == id) {
                resultado.add(c);
            }
        }

        return resultado;
    }

    public ArrayList<ClienteModel> buscaCliente(String nome) {
        ArrayList<ClienteModel> resultado = new ArrayList<>();

        for (ClienteModel c : listaClientes) {
            if (c.getNome().toLowerCase().contains(nome)) {
                resultado.add(c);
            }
        }

        return resultado;
    }

    public ArrayList<ClienteModel> buscaCliente(long cpfLong) {
        ArrayList<ClienteModel> resultado = new ArrayList<>();

        String cpf = String.valueOf(cpfLong);

        for (ClienteModel c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                resultado.add(c);
            }
        }

        return resultado;
    }

    public ArrayList<VendaModel> buscaVenda(int id) {
        ArrayList<VendaModel> resultado = new ArrayList<>();

        for (VendaModel v : listaVendas) {
            if (v.getIdVenda() == id) {
                resultado.add(v);
            }
        }

        return resultado;
    }

    public ArrayList<VendaModel> buscaVenda(String cpf) {
        ArrayList<VendaModel> resultado = new ArrayList<>();

        for (VendaModel v : listaVendas) {
            if (v.getCpfCliente().equals(cpf)) {
                resultado.add(v);
            }
        }

        return resultado;
    }

    public ArrayList<VendaModel> buscaVenda(String dataInicio, String dataFim) {
        ArrayList<VendaModel> resultado = new ArrayList<>();

        for (VendaModel v : listaVendas) {
            if (Utilidades.buscaPeriodo(v.getData(), dataInicio, dataFim)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public boolean atualizarCliente(ClienteModel c) {
        for (ClienteModel item : listaClientes) {
            if (item.getId() == c.getId()) {
                item.setNome(c.getNome());
                item.setEmail(c.getEmail());
                item.setCpf(c.getCpf());
                item.setNascimento(c.getNascimento());
                item.setSexo(c.getSexo());
                item.setEstadoCivil(c.getEstadoCivil());
                item.setCelular(c.getCelular());
                item.setTelefone(c.getTelefone());
                item.setEndereco(c.getEndereco());
            }
        }
        return true;
    }

    public boolean atualizarProduto(ProdutoModel p) {
        for (ProdutoModel item : listaProdutos) {
            if (item.getId() == p.getId()) {
                item.setNome(p.getNome());
                item.setMarca(p.getMarca());
                item.setFornecedor(p.getFornecedor());
                item.setValor(p.getValor());
                item.setEstoque(p.getEstoque());
                item.setDescricao(p.getDescricao());
            }
        }
        return true;
    }

    public boolean excluirCliente(int i) {
        ClienteModel clienteExcluir = new ClienteModel();
        boolean exists = false;

        for (ClienteModel c : listaClientes) {
            if (c.getId() == i) {
                clienteExcluir = c;
                exists = true;
            }
        }

        if (exists) {
            listaClientes.remove(clienteExcluir);
        }

        return true;
    }

    public boolean excluirProduto(int i) {
        ProdutoModel produtoExcluir = new ProdutoModel();
        boolean exists = false;

        for (ProdutoModel p : listaProdutos) {
            if (p.getId() == i) {
                produtoExcluir = p;
                exists = true;
            }
        }

        if (exists) {
            listaProdutos.remove(produtoExcluir);
        }

        return true;
    }

    public boolean alterarEstoque(int id, int vendido) {
        for (ProdutoModel p : listaProdutos) {
            if (p.getId() == id) {
                p.setEstoque(p.getEstoque() - vendido);
            }
        }

        return true;
    }

}
