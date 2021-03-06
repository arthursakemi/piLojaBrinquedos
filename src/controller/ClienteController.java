/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import java.util.ArrayList;
import model.ClienteModel;

public class ClienteController {

    public static boolean salvar(String nome,
            String email,
            String cpf,
            String sexo,
            String nascimento,
            String estadoCivil,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(nome,
                email,
                cpf,
                sexo,
                nascimento,
                estadoCivil,
                celular,
                telefone,
                endereco);

        return ClienteDAO.salvar(c);
    }

    public static boolean excluir(int id) {
        return ClienteDAO.excluir(id);
    }

    public static boolean atualizar(int id,
            String nome,
            String email,
            String cpf,
            String sexo,
            String nascimento,
            String estadoCivil,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(id,
                nome,
                email,
                cpf,
                sexo,
                nascimento,
                estadoCivil,
                celular,
                telefone,
                endereco);

        return ClienteDAO.atualizar(c);
    }

    public static ArrayList<ClienteModel> loadClientes() {
        return ClienteDAO.loadClientes();

    }

    public static ArrayList<ClienteModel> buscaCliente(String nome) {
        return ClienteDAO.buscaCliente(nome);

    }

    public static ClienteModel buscaCliente(long cpf) {
        return ClienteDAO.buscaCliente(cpf);

    }

    public static ClienteModel buscaCliente(int id) {
        return ClienteDAO.buscaCliente(id);
    }
}
