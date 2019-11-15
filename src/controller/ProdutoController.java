/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.ProdutoModel;

public class ProdutoController {

    public static boolean salvar(String nome,
            String marca,
            String fornecedor,
            double valor,
            int quantidade,
            String descricao) {

        ProdutoModel p = new ProdutoModel(nome,
                marca,
                fornecedor,
                quantidade,
                valor,
                descricao);

        return ProdutoDAO.salvar(p);
    }

    public static boolean excluir(int id) {
        return ProdutoDAO.excluir(id);
    }

    public static boolean atualizar(int id,
            String nome,
            String marca,
            String fornecedor,
            double valor,
            int quantidade,
            String descricao) {

        ProdutoModel p = new ProdutoModel(id,
                nome,
                marca,
                fornecedor,
                quantidade,
                valor,
                descricao);

        return ProdutoDAO.atualizar(p);
    }

    public static ProdutoModel visualizar(int id) {
        return ProdutoDAO.buscaProduto(id);
    }

    public static ArrayList<ProdutoModel> loadProdutos() {
        return ProdutoDAO.loadProdutos();
    }

    public static ProdutoModel buscaProduto(int id) {
        return ProdutoDAO.buscaProduto(id);
    }

    public static ArrayList<String[]> buscaProduto(String nome) {
        ArrayList<ProdutoModel> produtos = ProdutoDAO.buscaProduto(nome);
        ArrayList<String[]> resultado = new ArrayList<>();

        for (ProdutoModel p : produtos) {
            resultado.add(new String[]{
                String.valueOf(p.getId()),
                p.getNome(),
                p.getMarca(),
                p.getFornecedor(),
                String.valueOf(p.getValor()),
                String.valueOf(p.getEstoque()),
                p.getDescricao()});

        }
        return resultado;

    }

}
