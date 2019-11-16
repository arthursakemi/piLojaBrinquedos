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
import model.VendaModel;
import util.GerenciadorConexao;
import util.Utilidades;

/**
 *
 * @author Sakemi
 */
public class VendaDAO {

    public static boolean salvar(VendaModel v) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO vendas "
                    + "(id_cliente, data_venda, valor) "
                    + "VALUES(?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, v.getIdCliente());
            instrucaoSQL.setString(2, Utilidades.dataSQL(v.getData()));
            instrucaoSQL.setDouble(3, v.getValorTotal());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            int idVenda = -1;
            if (linhasAfetadas > 0) {
                retorno = true;
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();

                if (generatedKeys.next()) {
                    idVenda = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID do carro!");
                }

            } else {
                retorno = false;
            }

            ArrayList<String[]> carrinho = v.getProdutos();

            for (int i = 0; i < carrinho.size(); i++) {
                int idProduto = Integer.parseInt(carrinho.get(i)[0]);
                int quantidade = Integer.parseInt(carrinho.get(i)[2]);

                SalvarCarrinho(idVenda, idProduto, quantidade);
            }

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

    public static String[] gerarRelatorio(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        String[] venda = new String[5];

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM relatorio_analitico "
                    + "WHERE id = ?;");

            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                venda[0] = rs.getString("id");
                venda[1] = Utilidades.dateFormat(rs.getString("data_venda"));
                venda[2] = rs.getString("nome");
                venda[3] = Utilidades.cpfFormat(rs.getString("cpf"));
                venda[4] = rs.getString("valor");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            venda = null;
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

        return venda;
    }

    public static VendaModel buscaVenda(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        VendaModel venda = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM relatorio_vendas WHERE id = ?;");

            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                venda = new VendaModel(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        Utilidades.dateFormat(rs.getString("data_venda")),
                        rs.getDouble("valor")
                );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            venda = null;
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

        return venda;
    }

    public static VendaModel buscaVenda(String cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        VendaModel venda = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM relatorio_vendas WHERE cpf = ?;");

            instrucaoSQL.setLong(1, Long.parseLong(cpf));

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                venda = new VendaModel(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        Utilidades.dateFormat(rs.getString("data_venda")),
                        rs.getDouble("valor")
                );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            venda = null;
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

        return venda;
    }

    public static ArrayList<VendaModel> buscaVenda(String inicio, String fim) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<VendaModel> vendas = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM relatorio_vendas "
                    + "WHERE data_venda >= ? AND data_venda <= ?;");

            instrucaoSQL.setString(1, Utilidades.dataSQL(inicio));
            instrucaoSQL.setString(2, Utilidades.dataSQL(fim));

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                vendas.add(new VendaModel(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        Utilidades.dateFormat(rs.getString("data_venda")),
                        rs.getDouble("valor")
                ));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            vendas = null;
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

        return vendas;
    }

    public static ArrayList<String[]> loadVendas() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<String[]> vendas = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM relatorio_vendas;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                vendas.add(new String[]{
                    rs.getString("id"),
                    rs.getString("cpf"),
                    Utilidades.dateFormat(rs.getString("data_venda")),
                    rs.getString("valor")

                });
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            vendas = null;
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

        return vendas;
    }

    public static ArrayList<String[]> LoadCarrinho(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        ArrayList<String[]> produtos = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT id_produto, nome, quantidade, valor, subtotal "
                    + "FROM carrinho "
                    + "WHERE id_venda = ?;");

            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                produtos.add(new String[]{
                    rs.getString("id_produto"),
                    rs.getString("nome"),
                    rs.getString("quantidade"),
                    rs.getString("valor"),
                    rs.getString("subtotal")
                });
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            produtos = null;
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

        return produtos;
    }

    public static boolean SalvarCarrinho(int idVenda, int idProduto, int quantidade) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();

            instrucaoSQL = conexao.prepareStatement(
                    "INSERT INTO venda_produto "
                    + "(id_venda, id_produto, quantidade) "
                    + "VALUES(?, ?, ?);"
            );

            instrucaoSQL.setInt(1, idVenda);
            instrucaoSQL.setInt(2, idProduto);
            instrucaoSQL.setInt(3, quantidade);

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

}
