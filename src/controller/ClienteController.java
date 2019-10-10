/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import model.ClienteModel;
import java.util.ArrayList;

public class ClienteController {

    public static boolean salvar(String nome,
            String email,
            String cpf,
            String rg,
            String nascimento,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(nome,
                email,
                cpf,
                rg,
                nascimento,
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
            String rg,
            String nascimento,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(id,
                nome,
                email,
                cpf,
                rg,
                nascimento,
                celular,
                telefone,
                endereco);

        return ClienteDAO.atualizar(c);
    }

    public static ArrayList<String[]> getClientes() {
        ArrayList<ClienteModel> clientes = ClienteDAO.getClientes();
        ArrayList<String[]> listaClientes = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            listaClientes.add(new String[]{
                String.valueOf(clientes.get(i).getId()),
                clientes.get(i).getNome(),
                clientes.get(i).getEmail(),
                clientes.get(i).getCpf(),
                clientes.get(i).getRg(),
                clientes.get(i).getNascimento(),
                clientes.get(i).getCelular(),
                clientes.get(i).getTelefone(),
                clientes.get(i).getEndereco()});
        }

        return listaClientes;
    }

}
