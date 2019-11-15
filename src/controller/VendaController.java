/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendaDAO;
import java.util.ArrayList;
import model.VendaModel;

/**
 *
 * @author Sakemi
 */
public class VendaController {

    private static ArrayList<String[]> carrinho;

    public static boolean salvar(int idCliente,
            String data,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        VendaModel v = new VendaModel(idCliente,
                data,
                produtos,
                valorTotal);

        return VendaDAO.salvar(v);
    }

    public static ArrayList<String[]> loadVendas() {
        return VendaDAO.loadVendas();
    }

    public static ArrayList<String[]> visualizarVenda(int id) {
        return VendaDAO.buscaVenda(id);
    }

    public static ArrayList<String[]> buscaVenda(String inicio, String fim) {
        return VendaDAO.buscaVenda(inicio, fim);
    }

    public static String[] buscaVenda(long cpf) {
        return VendaDAO.buscaVenda(cpf);
    }

}
