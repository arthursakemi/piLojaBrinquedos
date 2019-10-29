/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import model.ClienteModel;
import java.util.ArrayList;
import javax.swing.table.TableModel;

public class ClienteController {

    public static boolean salvar(String nome,
            String email,
            String cpf,
            String nascimento,
            String sexo,
            String estadoCivil,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(nome,
                email,
                cpf,
                nascimento,
                sexo,
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
            String nascimento,
            String sexo,
            String estadoCivil,
            String celular,
            String telefone,
            String endereco) {

        ClienteModel c = new ClienteModel(id,
                nome,
                email,
                cpf,
                nascimento,
                sexo,
                estadoCivil,
                celular,
                telefone,
                endereco);

        return ClienteDAO.atualizar(c);
    }

    public static ClienteModel visualizar(int linha, TableModel tabela) {

        ClienteModel c = new ClienteModel(Integer.parseInt(tabela.getValueAt(linha, 0).toString()),
                tabela.getValueAt(linha, 1).toString(),
                tabela.getValueAt(linha, 2).toString(),
                tabela.getValueAt(linha, 3).toString(),
                tabela.getValueAt(linha, 4).toString(),
                tabela.getValueAt(linha, 5).toString(),
                tabela.getValueAt(linha, 6).toString(),
                tabela.getValueAt(linha, 7).toString(),
                tabela.getValueAt(linha, 8).toString(),
                tabela.getValueAt(linha, 9).toString());
        return c;
    }

    public static ArrayList<String[]> buscaCliente(int id) {
        ArrayList<ClienteModel> produtos = ClienteDAO.buscaCliente(id);
        ArrayList<String[]> resultado = new ArrayList<>();

        for (ClienteModel c : produtos) {
            resultado.add(new String[]{
                String.valueOf(c.getId()),
                c.getNome(),
                c.getEmail(),
                c.getCpf(),
                c.getSexo(),
                c.getNascimento(),
                c.getEstadoCivil(),
                c.getCelular(),
                c.getTelefone(),
                c.getEndereco()});
        }
        return resultado;

    }

    public static ArrayList<String[]> buscaCliente(String nome) {
        ArrayList<ClienteModel> produtos = ClienteDAO.buscaCliente(nome);
        ArrayList<String[]> resultado = new ArrayList<>();

        for (ClienteModel c : produtos) {
            resultado.add(new String[]{
                String.valueOf(c.getId()),
                c.getNome(),
                c.getEmail(),
                c.getCpf(),
                c.getSexo(),
                c.getNascimento(),
                c.getEstadoCivil(),
                c.getCelular(),
                c.getTelefone(),
                c.getEndereco()});

        }
        return resultado;

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
                clientes.get(i).getSexo(),
                clientes.get(i).getNascimento(),
                clientes.get(i).getEstadoCivil(),
                clientes.get(i).getCelular(),
                clientes.get(i).getTelefone(),
                clientes.get(i).getEndereco()});
        }

        return listaClientes;
    }

}
