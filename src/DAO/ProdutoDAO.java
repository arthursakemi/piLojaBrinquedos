/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ProdutoModel;
import java.util.ArrayList;

/**
 *
 * @author Sakemi
 */
public class ProdutoDAO {

    public static boolean salvar(ProdutoModel p) {
        return SimulaDB.getInstance().salvarProduto(p);
    }

    public static boolean atualizar(ProdutoModel p) {
        return SimulaDB.getInstance().atualizarProduto(p);
    }

    public static boolean excluir(int id) {
        return SimulaDB.getInstance().excluirProduto(id);
    }

    public static ArrayList<ProdutoModel> buscaProduto(int id) {
        return SimulaDB.getInstance().buscaProduto(id);
    }

    public static ArrayList<ProdutoModel> buscaProduto(String nome) {
        return SimulaDB.getInstance().buscaProduto(nome);
    }

    public static ArrayList<ProdutoModel> getProdutos() {
        return SimulaDB.getInstance().getProdutos();
    }

}
