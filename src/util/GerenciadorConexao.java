/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {

    public static String STATUS = "Não conectado";

    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String SERVER = "localhost";
    public static String PORTA = ":3306";  // :xxxx
    public static String DATABASE = "/lojacarro";  // /nomeDatabase
    public static String TIMEZONE = "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public static String LOGIN = "root";
    public static String SENHA = "root";

    public static String URL = "";

    public static Connection CONEXAO;

    public GerenciadorConexao() {

    }

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
        URL = "jdbc:mysql://" + SERVER + PORTA + DATABASE + TIMEZONE;

        if (CONEXAO == null) {
            try {
                //carrega o driver
                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão!";
                }

            } catch (ClassNotFoundException e) {

                throw new ClassNotFoundException("O driver expecificado não foi encontrado");

            } catch (SQLException e) {

                throw new SQLException("Erro ao estabelecer conexão com o banco de dados.");
            }
        } else {
            try {
                if (CONEXAO.isClosed()) {
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                }
            } catch (SQLException ex) {
                throw new SQLException("falha ao fechar a conexão.");
            }
        }

        return CONEXAO;
    }

    public static String getStatusConexao() {
        return STATUS;
    }

    public static boolean fecharConexao() throws SQLException {

        try {
            if (CONEXAO != null) {
                if (!CONEXAO.isClosed()) {
                    CONEXAO.close();
                }
            }

            STATUS = "Não conectado";
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

}
