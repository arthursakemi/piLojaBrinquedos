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
        listaClientes = new ArrayList<ClienteModel>();
        listaProdutos = new ArrayList<ProdutoModel>();
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

    public boolean atualizarCliente(ClienteModel c) {
        for (ClienteModel item : listaClientes) {
            if (item.getId() == c.getId()) {
                item.setNome(c.getNome());
                item.setEmail(c.getEmail());
                item.setCpf(c.getCpf());
                item.setRg(c.getRg());
                item.setNascimento(c.getNascimento());
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