/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import model.ProdutoModel;
import java.util.ArrayList;
import javax.swing.table.TableModel;

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

    public static ProdutoModel visualizar(int linha, TableModel tabela) {

        ProdutoModel p = new ProdutoModel(Integer.parseInt(tabela.getValueAt(linha, 0).toString()),
                tabela.getValueAt(linha, 1).toString(),
                tabela.getValueAt(linha, 2).toString(),
                tabela.getValueAt(linha, 3).toString(),
                Double.parseDouble(tabela.getValueAt(linha, 4).toString()),
                Integer.parseInt(tabela.getValueAt(linha, 5).toString()),
                tabela.getValueAt(linha, 6).toString());
        return p;
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

    public static ArrayList<String[]> buscaProduto(int id) {
        ArrayList<ProdutoModel> produtos = ProdutoDAO.buscaProduto(id);
        ArrayList<String[]> resultado = new ArrayList<>();

        for (ProdutoModel p : produtos) {
            resultado.add(new String[]{
                String.valueOf(p.getId()),
                p.getNome(),
                p.getMarca(),
                p.getFornecedor(),
                String.valueOf(p.getValor()),
                String.valueOf(p.getQuantidade()),
                p.getDescricao()});
        }
        return resultado;

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
                String.valueOf(p.getQuantidade()),
                p.getDescricao()});

        }
        return resultado;

    }
}
