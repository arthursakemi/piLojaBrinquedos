/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.VendaDAO;
import model.VendaModel;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Sakemi
 */
public class VendaDAO {

    public static boolean salvar(VendaModel v) {
        return SimulaDB.getInstance().salvarVenda(v);
    }

    public static ArrayList<VendaModel> buscaVenda(int id) {
        return SimulaDB.getInstance().buscaVenda(id);
    }

    public static ArrayList<VendaModel> buscaVenda(String cpf) {
        return SimulaDB.getInstance().buscaVenda(cpf);
    }

    public static ArrayList<VendaModel> buscaVenda(String inicio, String fim) {
        return SimulaDB.getInstance().buscaVenda(inicio, fim);
    }

    public static ArrayList<VendaModel> getVendas() {
        return SimulaDB.getInstance().getVendas();
    }

}
