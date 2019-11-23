/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ClienteModel;
import util.GerenciadorConexao;
import util.Utilidades;

public class ClienteDAO {

    
    /**
     * Metodo para salvar Dados do Cliente no Banco de Dados SQL
     * 
     * @see model.ClienteModel
     * @param c Objeto do tipo Cliente
     * @return boolean - true: sucesso , false:falha
     * @throws SQLException
     */
    public static boolean salvar(ClienteModel c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO clientes "
                    + "(nome,email,cpf,sexo,nascimento,estado_civil,celular,telefone,endereco) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getEmail());
            instrucaoSQL.setLong(3, Utilidades.cpfSQL(c.getCpf()));
            instrucaoSQL.setString(4, c.getSexo());
            instrucaoSQL.setString(5, Utilidades.dataSQL(c.getNascimento()));
            instrucaoSQL.setString(6, c.getEstadoCivil());
            instrucaoSQL.setLong(7, Utilidades.telefoneSQL(c.getCelular()));
            instrucaoSQL.setLong(8, Utilidades.telefoneSQL(c.getTelefone()));
            instrucaoSQL.setString(9, c.getEndereco());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    /**
     * Metodo para atualizar Dados de um Cliente usando seu ID
     * 
     * @see model.ClienteModel
     * @param c Objeto tipo Cliente
     * @return boolean - true: sucesso , false:falha
     * @throws SQLException
     */
    
    public static boolean atualizar(ClienteModel c) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "UPDATE clientes "
                    + "SET "
                    + "nome = ?, "
                    + "email = ?, "
                    + "cpf = ?, "
                    + "sexo = ?, "
                    + "nascimento = ?, "
                    + "estado_civil = ?, "
                    + "celular = ?, "
                    + "telefone = ?, "
                    + "endereco = ? "
                    + "WHERE id = ?;");

            instrucaoSQL.setString(1, c.getNome());
            instrucaoSQL.setString(2, c.getEmail());
            instrucaoSQL.setLong(3, Utilidades.cpfSQL(c.getCpf()));
            instrucaoSQL.setString(4, c.getSexo());
            instrucaoSQL.setString(5, Utilidades.dataSQL(c.getNascimento()));
            instrucaoSQL.setString(6, c.getEstadoCivil());
            instrucaoSQL.setLong(7, Utilidades.telefoneSQL(c.getCelular()));
            instrucaoSQL.setLong(8, Utilidades.telefoneSQL(c.getTelefone()));
            instrucaoSQL.setString(9, c.getEndereco());
            instrucaoSQL.setInt(10, c.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            retorno = linhasAfetadas > 0;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    
    /**
     * Metodo para excluir cliente do Banco de Dados SQL
     * 
     * @param id Id obtida tipo INT
     * @return boolean - true: sucesso , false:falha
     * @throws SQLException
     */
    public static boolean excluir(int id) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "UPDATE clientes"
                    + "SET ativo = false"
                    + "WHERE id = ?");

            instrucaoSQL.setInt(1, id);

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    
    /**
     * Metodo para carregar do Banco de Dados SQL os dados de todos clientes
     * 
     * @see model.ClienteModel
     * @return ArrayList com dados dos Clientes
     * @throws SQLException
     */
    public static ArrayList<ClienteModel> loadClientes() {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaClientes = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM clientes;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                listaClientes.add(new ClienteModel(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("sexo"),
                        rs.getString("nascimento"),
                        rs.getString("estado_civil"),
                        rs.getString("celular"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                ));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaClientes;

    }

    
    /**
     * Metodo para localizar Cliente no Banco de Dados SQL pelo ID
     * 
     * @see model.ClienteModel
     * @param id Objeto tipo Cliente
     * @return Objeto tipo Cliente, com dados do cliente solicitado: sucesso / Objeto null : false
     * @throws SQLException
     */
    public static ClienteModel buscaCliente(int id) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ClienteModel c = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM clientes WHERE id = ?;");

            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                c = new ClienteModel(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("sexo"),
                        Utilidades.dateFormat(rs.getString("nascimento")),
                        rs.getString("estado_civil"),
                        rs.getString("celular"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            c = null;
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return c;

    }

    
    
    /**
     * Metodo para buscar dados do Cliente com base no NOME
     * 
     * @see model.ClienteModel
     * @param nome String com parametro de pesquisa
     * @return Arraylist com dados do cliente solicitado : sucesso / ArrayList vazia : falha
     * @throws SQLException
     */
    public static ArrayList<ClienteModel> buscaCliente(String nome) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaClientes = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM clientes_ativos "
                    + "WHERE nome LIKE ?;");

            instrucaoSQL.setString(1, "%" + nome + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                listaClientes.add(new ClienteModel(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("sexo"),
                        rs.getString("nascimento"),
                        rs.getString("estado_civil"),
                        rs.getString("celular"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                ));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaClientes = null;
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaClientes;
    }

    
    /**
     * Metodo para buscar dados do Cliente com base no CPF
     * 
     * @see model.ClienteModel
     * @param cpf variável tipo LONG com CPF
     * @return Objeto tipo Cliente com dados solicitados : sucesso / Obejto tipo Cliente vazio : falha
     * @throws SQLException
     */
    public static ClienteModel buscaCliente(long cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ClienteModel c = new ClienteModel();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM clientes WHERE cpf = ?;");

            instrucaoSQL.setLong(1, cpf);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                c = new ClienteModel(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("sexo"),
                        Utilidades.dateFormat(rs.getString("nascimento")),
                        rs.getString("estado_civil"),
                        rs.getString("celular"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            c = null;
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexao.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return c;
    }

}
