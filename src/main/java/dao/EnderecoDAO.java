package dao;

import entities.Endereco;
import entities.Usuario;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
  private static final String INSERIR_ENDERECO = "INSERT INTO tb_endereco (logradouro, numero, bairro, cidade) VALUES (?, ?, ?, ?)";
  private static final String LISTAR_ENDERECO = "SELECT * FROM tb_endereco";
  private static final String ATUALIZAR_ENDERECO = "UPDATE usuarios SET nome=?, email=? WHERE id=?";
  private static final String BUSCAR_ENDERECO_POR_ID = "SELECT * FROM usuarios WHERE id=?";
  private static final String DELETAR_ENDERECO = "DELETE FROM usuarios WHERE id=?";

  public void inserirEndereco(Endereco endereco) {
    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(INSERIR_ENDERECO)) {

      pstmt.setString(1, endereco.getLogradouro());
      pstmt.setInt(2, endereco.getNumero());
      pstmt.setString(3, endereco.getBairro());
      pstmt.setString(4, endereco.getCidade());
      pstmt.executeUpdate();

      System.out.println("Endereço inserido com sucesso!");

    } catch (SQLException e) {
      System.err.println("Erro ao inserir endereço: " + e.getMessage());
    }
  }

  public List<Endereco> listarEndereco() {
    List<Endereco> enderecos = new ArrayList<>();

    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(LISTAR_ENDERECO);
         ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setLogradouro(rs.getString("logradouro"));
        endereco.setNumero(rs.getInt("numero"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        enderecos.add(endereco);
      }

    } catch (SQLException e) {
      System.err.println("Erro ao listar usuários: " + e.getMessage());
    }

    return enderecos;
  }

  public void atualizarUsuario(Usuario usuario) {
    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_ENDERECO)) {

      pstmt.setString(1, usuario.getNome());
      pstmt.setString(2, usuario.getEmail());
      pstmt.setInt(3, usuario.getId());
      pstmt.executeUpdate();

      System.out.println("Usuário atualizado com sucesso!");

    } catch (SQLException e) {
      System.err.println("Erro ao atualizar usuário: " + e.getMessage());
    }
  }

  public Usuario buscarUsuarioPorId(int id) {
    Usuario usuario = null;

    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_ENDERECO_POR_ID)) {

      pstmt.setInt(1, id);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          usuario = new Usuario();
          usuario.setId(rs.getInt("id"));
          usuario.setNome(rs.getString("nome"));
          usuario.setEmail(rs.getString("email"));
        }
      }

    } catch (SQLException e) {
      System.err.println("Erro ao buscar usuário por ID: " + e.getMessage());
    }

    return usuario;
  }

  public void deletarUsuario(int id) {
    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(DELETAR_ENDERECO)) {

      pstmt.setInt(1, id);
      pstmt.executeUpdate();

      System.out.println("Usuário deletado com sucesso!");

    } catch (SQLException e) {
      System.err.println("Erro ao deletar usuário: " + e.getMessage());
    }
  }


}