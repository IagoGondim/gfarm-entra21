package dao;

import entities.Usuario;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
  private static final String INSERIR_USUARIO = "INSERT INTO tb_usuario (nome, cpf, email, password) VALUES (?, ?, ?, ?)";
  private static final String LISTAR_USUARIOS = "SELECT * FROM usuarios";
  private static final String ATUALIZAR_USUARIO = "UPDATE usuarios SET nome=?, email=? WHERE id=?";
  private static final String BUSCAR_USUARIO_POR_ID = "SELECT * FROM usuarios WHERE id=?";
  private static final String DELETAR_USUARIO = "DELETE FROM usuarios WHERE id=?";


  public void inserirUsuario(Usuario usuario) {
    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(INSERIR_USUARIO)) {

      pstmt.setString(1, usuario.getNome());
      pstmt.setString(2, usuario.getCpf());
      pstmt.setString(3, usuario.getEmail());
      pstmt.setString(4, usuario.getPassword());
      pstmt.executeUpdate();

      System.out.println("Usuário inserido com sucesso!");

    } catch (SQLException e) {
      System.err.println("Erro ao inserir usuário: " + e.getMessage());
    }
  }

  public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();

    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(LISTAR_USUARIOS);
         ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuarios.add(usuario);
      }

    } catch (SQLException e) {
      System.err.println("Erro ao listar usuários: " + e.getMessage());
    }

    return usuarios;
  }

  public void atualizarUsuario(Usuario usuario) {
    try (Connection conexao = ConexaoBancoDados.obterConexao();
         PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_USUARIO)) {

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
         PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_USUARIO_POR_ID)) {

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
         PreparedStatement pstmt = conexao.prepareStatement(DELETAR_USUARIO)) {

      pstmt.setInt(1, id);
      pstmt.executeUpdate();

      System.out.println("Usuário deletado com sucesso!");

    } catch (SQLException e) {
      System.err.println("Erro ao deletar usuário: " + e.getMessage());
    }
  }
}