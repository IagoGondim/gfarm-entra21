package dao;

import entities.Equipamento;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private static final String INSERIR_EQUIPAMENTO = "INSERT INTO tb_equipamento (nome, descricao, dataDeCompra) VALUES (?, ?, ?)";
    private static final String LISTAR_EQUIPAMENTOS = "SELECT * FROM tb_equipamento";
    private static final String ATUALIZAR_EQUIPAMENTO = "UPDATE tb_equipamento SET nome=?, descricao=?, dataDeCompra=?, WHERE id=?";
    private static final String BUSCAR_EQUIPAMENTO_POR_ID = "SELECT * FROM tb_equipamento WHERE id=?";
    private static final String DELETAR_EQUIPAMENTO = "DELETE FROM tb_equipamento WHERE id=?";

    public void inserirEquipamento(Equipamento equipamento) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_EQUIPAMENTO)) {

            pstmt.setString(1, equipamento.getNome());
            pstmt.setString(2, equipamento.getDescricao());
            pstmt.setTimestamp(3, equipamento.getDataDeCompra());
            pstmt.executeUpdate();

            System.out.println("Equipamento inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir equipamento: " + e.getMessage());
        }
    }

    public List<Equipamento> listarEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_EQUIPAMENTOS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getInt("id"));
                equipamento.setNome(rs.getString("nome"));
                equipamento.setDescricao(rs.getString("descricao"));
                equipamento.setDataDeCompra(rs.getTimestamp("dataDeCompra"));
                equipamentos.add(equipamento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar equipamentos: " + e.getMessage());
        }

        return equipamentos;
    }
    public void atualizarEquipamento(Equipamento equipamento) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_EQUIPAMENTO)) {

            pstmt.setString(1, equipamento.getNome());
            pstmt.setString(2, equipamento.getDescricao());
            pstmt.setTimestamp(3, equipamento.getDataDeCompra());
            pstmt.executeUpdate();

            System.out.println("Equipamento atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar equipamento: " + e.getMessage());
        }
    }

    public Equipamento buscarEquipamentoPorId(int id) {
        Equipamento equipamento = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_EQUIPAMENTO_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    equipamento = new Equipamento();
                    equipamento.setId(rs.getInt("id"));
                    equipamento.setNome(rs.getString("nome"));
                    equipamento.setDescricao(rs.getString("descricao"));
                    equipamento.setDataDeCompra(rs.getTimestamp("dataDeCompra"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar equipamento por ID: " + e.getMessage());
        }

        return equipamento;
    }

    public void deletarEquipamento(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_EQUIPAMENTO)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Equipamento deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar equipamento: " + e.getMessage());
        }
    }

}