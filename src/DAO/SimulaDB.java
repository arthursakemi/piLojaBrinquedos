/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ClienteModel;
import model.ProdutoModel;
import java.util.ArrayList;

public class SimulaDB {

    private static SimulaDB mockdb;

    private ArrayList<ClienteModel> listaClientes;
    private ArrayList<ProdutoModel> listaProdutos;

    private SimulaDB() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();

        listaProdutos.add(new ProdutoModel(10, "LesPaul", "Gibson", "Gibson", 5000, 2, ""));
        listaProdutos.add(new ProdutoModel(11, "Explorer", "Gibson", "Gibson", 4500, 2, ""));
        listaProdutos.add(new ProdutoModel(12, "FlyingV", "Gibson", "Gibson", 4000, 2, ""));
        listaProdutos.add(new ProdutoModel(13, "Stratocaster", "Fender", "Fender", 3500, 2, ""));
        listaProdutos.add(new ProdutoModel(14, "Telecaster", "Fender", "Fender", 3000, 2, ""));
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

    public ArrayList<ClienteModel> getClientes() {
        return this.listaClientes;
    }

    public ArrayList<ProdutoModel> getProdutos() {
        return this.listaProdutos;
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
            System.out.println(p.getNome());
            System.out.println(nome);
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
