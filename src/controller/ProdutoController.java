/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import model.ProdutoModel;
import java.util.ArrayList;

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
                valor,
                quantidade,
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
                valor,
                quantidade,
                descricao);

        return ProdutoDAO.atualizar(p);
    }

    public static ArrayList<String[]> getProdutos() {
        ArrayList<ProdutoModel> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{
                String.valueOf(produtos.get(i).getId()),
                produtos.get(i).getNome(),
                produtos.get(i).getMarca(),
                produtos.get(i).getFornecedor(),
                String.valueOf(produtos.get(i).getValor()),
                String.valueOf(produtos.get(i).getQuantidade()),
                produtos.get(i).getDescricao()});
        }

        return listaProdutos;
    }
}
