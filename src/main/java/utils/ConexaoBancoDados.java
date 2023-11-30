package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
  private static final String URL = "jdbc:mysql://localhost:3306/gFarm";
  private static final String USUARIO = "root";
  private static final String SENHA = "root";

  public static Connection obterConexao() throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(URL, USUARIO, SENHA);
    } catch (ClassNotFoundException | SQLException e) {
      throw new SQLException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
    }
  }

  public static void fecharConexao(Connection conexao) {
    try {
      if (conexao != null && !conexao.isClosed()) {
        conexao.close();
        System.out.println("Conexão fechada.");
      }
    } catch (SQLException e) {
      System.err.println("Erro ao fechar a conexão: " + e.getMessage());
    }
  }
}
