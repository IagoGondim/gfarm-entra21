package dao;

import entities.Funcionario;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final String INSERIR_FUNCIONARIO = "INSERT INTO tb_funcionario (nome, cargo, dataContratacao) VALUES (?, ?, ?)";
    private static final String LISTAR_FUNCIONARIOS = "SELECT * FROM tb_funcionario";
    private static final String ATUALIZAR_FUNCIONARIO = "UPDATE tb_funcionario SET nome=?, cargo=?, dataContratacao=?, WHERE id=?";
    private static final String BUSCAR_FUNCIONARIO_POR_ID = "SELECT * FROM tb_funcionario WHERE id=?";
    private static final String DELETAR_FUNCIONARIO = "DELETE FROM tb_funcionario WHERE id=?";

    public void inserirFuncionario(Funcionario funcionario) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_FUNCIONARIO)) {

            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCargo());
            pstmt.setTimestamp(3, funcionario.getDataContratacao());
            pstmt.executeUpdate();

            System.out.println("Funcionario inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir o funcionario: " + e.getMessage());
        }
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_FUNCIONARIOS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDataContratacao(rs.getTimestamp("dataContratacao"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionarios: " + e.getMessage());
        }

        return funcionarios;
    }
    public void atualizarFuncionario(Funcionario funcionario) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_FUNCIONARIO)) {

            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCargo());
            pstmt.setTimestamp(3, funcionario.getDataContratacao());
            pstmt.executeUpdate();

            System.out.println("Funcionario atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar funcionario: " + e.getMessage());
        }
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        Funcionario funcionario = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_FUNCIONARIO_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();
                    funcionario.setId(rs.getInt("id"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCargo(rs.getString("cargo"));
                    funcionario.setDataContratacao(rs.getTimestamp("dataContratacao"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionario por ID: " + e.getMessage());
        }

        return funcionario;
    }

    public void deletarFuncionario(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_FUNCIONARIO)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Funcionario deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar funcionario: " + e.getMessage());
        }
    }

}