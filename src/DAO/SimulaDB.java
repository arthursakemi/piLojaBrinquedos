/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ClienteModel;
import model.ProdutoModel;
import java.util.ArrayList;
import model.VendaModel;
import view.VendaView;

public class SimulaDB {

    private static SimulaDB mockdb;

    private ArrayList<ClienteModel> listaClientes;
    private ArrayList<ProdutoModel> listaProdutos;
    private ArrayList<VendaModel> listaVendas;
    private ArrayList<String[]> carrinho;

    private SimulaDB() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaVendas = new ArrayList<>();

        int[] data = {01 / 01 / 2001};

        ProdutoModel p1 = new ProdutoModel(10, "LesPaul", "Gibson", "Gibson", 5000, 2, ""),
                p2 = new ProdutoModel(11, "Explorer", "Gibson", "Gibson", 4500, 2, ""),
                p3 = new ProdutoModel(12, "FlyingV", "Gibson", "Gibson", 4000, 2, ""),
                p4 = new ProdutoModel(13, "Stratocaster", "Fender", "Fender", 3500, 2, ""),
                p5 = new ProdutoModel(14, "Telecaster", "Fender", "Fender", 3000, 2, "");

        ClienteModel c1 = new ClienteModel(10, "Bob", "bob@mail.com", "11111111111", "01/01/2001", "Masculino", "Solteiro", "11111111111", "", "Rua 1, 01"),
                c2 = new ClienteModel(11, "Zack", "zack@mail.com", "22222222222", "02/02/2002", "Masculino", "Divorciado", "12222222222", "", "Rua 2, 02"),
                c3 = new ClienteModel(12, "Jack", "jack@mail.com", "33333333333", "03/03/2003", "Masculino", "Casado", "1333333333", "", "Rua 3, 03"),
                c4 = new ClienteModel(13, "Meggy", "meggy@mail.com", "44444444444", "04/04/2004", "Feminino", "Solteira", "14444444444", "", "Rua 4, 04"),
                c5 = new ClienteModel(14, "Laura", "laura@mail.com", "55555555555", "05/05/2005", "Feminino", "Viuva", "15555555555", "", "Rua 5, 05");

        VendaModel v1 = new VendaModel(10, data, "Bob", carrinho, 500.0),
                v2 = new VendaModel(11, data, "Zack", carrinho, 500.0),
                v3 = new VendaModel(12, data, "Jack", carrinho, 500.0),
                v4 = new VendaModel(13, data, "Meggy", carrinho, 500.0),
                v5 = new VendaModel(14, data, "Laura", carrinho, 500.0);

        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);

        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        listaClientes.add(c4);
        listaClientes.add(c5);

        listaVendas.add(v1);
        listaVendas.add(v2);
        listaVendas.add(v3);
        listaVendas.add(v4);
        listaVendas.add(v5);

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

    public ArrayList<VendaModel> buscaVenda(int id) {
        ArrayList<VendaModel> resultado = new ArrayList<>();

        for (VendaModel v : listaVendas) {
            if (v.getId() == id) {
                resultado.add(v);
            }
        }

        return resultado;
    }

//    public ArrayList<ClienteModel> buscaVenda(String[] data) {
//        ArrayList<VendaModel> resultado = new ArrayList<>();
//
//        for (VendaModel v : listaVendas) {
//            if (v.getNome().toLowerCase().contains(nome)) {
//                resultado.add(v);
//            }
//        }
//
//        return resultado;
//    }
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
                item.setQuantidade(p.getQuantidade());
                item.setDescricao(p.getDescricao());
            }
        }
        return true;
    }

    public boolean atualizarVenda(VendaModel v) {
        for (VendaModel item : listaVendas) {
            if (item.getId() == v.getId()) {
                item.setData(v.getData());
                item.setNomeCliente(v.getNomeCliente());
                item.setProdutos(v.getProdutos());
                item.setValorTotal(v.getValorTotal());
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

}
