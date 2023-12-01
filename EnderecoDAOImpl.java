package endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAOImpl implements EnderecoDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/gFarm";

  public Endereco salvarEndereco(Endereco endereco) {
    try (Connection connection = DriverManager.getConnection(URL)) {
      String query = "INSERT INTO tb_endereco (logradrouro, numero, bairro, cidade) VALUES (?, ?, ?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, endereco.getLogradouro());
        preparedStatement.setInt(2, endereco.getNumero());
        preparedStatement.setString(3, endereco.getBairro());
        preparedStatement.setString(4, (String) endereco.getCidade());

        int linhasAfetadas = preparedStatement.executeUpdate();

        if (linhasAfetadas > 0) {
          ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
          if (generatedKeys.next()) {
            endereco.setId(generatedKeys.getInt(1));
            return endereco;
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public Endereco atualizarEndereco(Endereco endereco) {
    try (Connection connection = DriverManager.getConnection(URL)) {
      String query = "UPDATE tb_endereco SET logradrouro=?, numero=?, bairro=?, cidade=? WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, endereco.getLogradouro());
        preparedStatement.setInt(2, endereco.getNumero());
        preparedStatement.setString(3, endereco.getBairro());
        preparedStatement.setString(4, (String) endereco.getCidade());
        preparedStatement.setInt(5, endereco.getId());

        int linhasAfetadas = preparedStatement.executeUpdate();

        if (linhasAfetadas > 0) {
          return endereco;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void deletarEndereco(int enderecoId) {
    try (Connection connection = DriverManager.getConnection(URL)) {
      String query = "DELETE FROM tb_endereco WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, enderecoId);

        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Endereco obterEnderecoPorId(int enderecoId) {
    try (Connection connection = DriverManager.getConnection(URL)) {
      String query = "SELECT * FROM tb_endereco WHERE id=?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, enderecoId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
          return criarEndereco(resultSet);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<Endereco> obterTodosEnderecos() {
    List<Endereco> enderecos = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(URL)) {
      String query = "SELECT * FROM tb_endereco";
      try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
          enderecos.add(criarEndereco(resultSet));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return enderecos;
  }

  private Endereco criarEndereco(ResultSet resultSet) throws SQLException {
    Endereco endereco = new Endereco();
    endereco.setId(resultSet.getInt("id"));
    endereco.setLogradouro(resultSet.getString("logradrouro"));
    endereco.setNumero(resultSet.getInt("numero"));
    endereco.setBairro(resultSet.getString("bairro"));
    endereco.setCidade(resultSet.getString("cidade"));
    return endereco;
  }
}