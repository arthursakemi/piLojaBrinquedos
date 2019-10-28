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

    public static boolean salvar(String[] data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        VendaModel v = new VendaModel(data,
                nomeCliente,
                produtos,
                valorTotal);

        return VendaDAO.salvar(v);
    }

    public static boolean atualizar(int id,
            String[] data,
            String nomeCliente,
            ArrayList<String[]> produtos,
            Double valorTotal) {

        VendaModel v = new VendaModel(id,
                data,
                nomeCliente,
                produtos,
                valorTotal);

        return VendaDAO.atualizar(v);
    }

}
