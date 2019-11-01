/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendaDAO;
import model.VendaModel;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Sakemi
 */
public class VendaController {

    private static ArrayList<String[]> carrinho;

    public static boolean salvar(int idCliente,
            String data,
            String nomeCliente,
            String cpf,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        VendaModel v = new VendaModel(idCliente,
                data,
                nomeCliente,
                cpf,
                produtos,
                valorTotal);

        return VendaDAO.salvar(v);
    }

}
