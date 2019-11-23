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
import model.ProdutoModel;
import util.GerenciadorConexao;

/**
 *
 * @author Sakemi
 */
public class ProdutoDAO {

    /**
     * Metodo para salvar novo produto no Banco de Dados SQL
     *
     * @see model.ProdutoModel
     * @param p Objeto tipo Produto
     * @return boolean true : sucesso / false : falha
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static boolean salvar(ProdutoModel p) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produtos "
                    + "(nome, marca, fornecedor, estoque, valor, descricao) "
                    + "VALUES(?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getMarca());
            instrucaoSQL.setString(3, p.getFornecedor());
            instrucaoSQL.setInt(4, p.getEstoque());
            instrucaoSQL.setDouble(5, p.getValor());
            instrucaoSQL.setString(6, p.getDescricao());

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
     * Metodo para atualizar determinado Produto no Banco de Dados SQL
     *
     * @see model.ProdutoModel
     * @param p Objeto tipo Produto
     * @return boolean true : sucesso / false : falha
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static boolean atualizar(ProdutoModel p) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("UPDATE produtos "
                    + "SET"
                    + "nome = ?, "
                    + "marca = ?, "
                    + "fornecedor = ?, "
                    + "estoque = ?, "
                    + "valor = ?, "
                    + "descricao = ? "
                    + "WHERE id = ?;");

            instrucaoSQL.setString(1, p.getNome());
            instrucaoSQL.setString(2, p.getMarca());
            instrucaoSQL.setString(3, p.getFornecedor());
            instrucaoSQL.setInt(4, p.getEstoque());
            instrucaoSQL.setDouble(5, p.getValor());
            instrucaoSQL.setString(6, p.getDescricao());
            instrucaoSQL.setInt(7, p.getId());

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
     * Metodo para excluir um Produto do Banco de Dados SQL
     *
     * @param id variavel tipo INT com parametro
     * @return boolean true : sucesso / false : falha
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static boolean excluir(int id) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "DELETE FROM produtos "
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
     * Metodo para carregar Tabela de Produtos
     *
     * @see model.ProdutoModel
     * @return ArrayList com produtos.
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static ArrayList<ProdutoModel> loadProdutos() {
        /**
         * Metodo para carregar Tabela de Produtos
         *
         * @see model.ProdutoModel
         * @return ArrayList com produtos.
         *
         */
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ProdutoModel> produtos = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produtos;");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                produtos.add(new ProdutoModel(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("fornecedor"),
                        rs.getInt("estoque"),
                        rs.getDouble("valor"),
                        rs.getString("descricao")
                ));
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

    /**
     * Metodo para carregar determinado Produto no Banco de Dados SQL
     *
     * @see model.ProdutoModel
     * @param id variavel tipo int com parametro
     * @return Objeto tipo Produto com dados
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static ProdutoModel buscaProduto(int id) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ProdutoModel produto = null;

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM produtos "
                    + "WHERE id = ?;");

            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                produto = new ProdutoModel(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("fornecedor"),
                        rs.getInt("estoque"),
                        rs.getDouble("valor"),
                        rs.getString("descricao")
                );
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            produto = null;
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

        return produto;
    }

    /**
     * Metodo para carregar determinado Produto no Banco de Dados SQL
     *
     * @see model.ProdutoModel
     * @return ArrayList com Produtos iguais ou com parte da String no nome
     * @throws java.lang.ClassFormatError Erro na coneccao com o Banco de Dados
     * SQL
     */
    public static ArrayList<ProdutoModel> buscaProduto(String nome) {

        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ProdutoModel> produtos = new ArrayList<>();

        try {

            conexao = GerenciadorConexao.abrirConexao();
            instrucaoSQL = conexao.prepareStatement(
                    "SELECT * FROM produtos "
                    + "WHERE nome LIKE ?;");

            instrucaoSQL.setString(1, "%" + nome + "%");

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                produtos.add(new ProdutoModel(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("fornecedor"),
                        rs.getInt("estoque"),
                        rs.getDouble("valor"),
                        rs.getString("descricao")
                ));
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

}
