/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ClienteModel;
import java.util.ArrayList;

public class ClienteDAO {

    public static boolean salvar(ClienteModel c) {
        return SimulaDB.getInstance().salvarCliente(c);
    }

    public static boolean atualizar(ClienteModel c) {
        return SimulaDB.getInstance().atualizarCliente(c);
    }

    public static boolean excluir(int cID) {
        return SimulaDB.getInstance().excluirCliente(cID);
    }

    public static ArrayList<ClienteModel> getClientes() {
        return SimulaDB.getInstance().getClientes();
    }

    public static ArrayList<ClienteModel> buscaCliente(int id) {
        return SimulaDB.getInstance().buscaCliente(id);
    }

    public static ArrayList<ClienteModel> buscaCliente(String nome) {
        return SimulaDB.getInstance().buscaCliente(nome);
    }

}
