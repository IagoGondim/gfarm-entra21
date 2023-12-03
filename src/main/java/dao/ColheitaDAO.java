package dao;

import entities.Colheita;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColheitaDAO {
    private static final String INSERIR_COLHEITA = "INSERT INTO tb_colheita (dataColheita, quantidadeColhida) VALUES (?, ?)";
    private static final String LISTAR_COLHEITAS = "SELECT * FROM tb_colheita";
    private static final String ATUALIZAR_COLHEITA = "UPDATE tb_colheita SET dataColheita=?, quantidadeColhida=?, WHERE id=?";
    private static final String BUSCAR_COLHEITA_POR_ID = "SELECT * FROM tb_colheita WHERE id=?";
    private static final String DELETAR_COLHEITA = "DELETE FROM tb_colheita WHERE id=?";

    public void inserirColheita(Colheita colheita) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_COLHEITA)) {

            pstmt.setTimestamp(1, colheita.getDataColheita());
            pstmt.setInt(2, colheita.getQuantidadeColhida());
            pstmt.executeUpdate();

            System.out.println("Colheita inserida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir a colheita: " + e.getMessage());
        }
    }

    public List<Colheita> listarColheitas() {
        List<Colheita> colheitas = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_COLHEITAS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Colheita colheita = new Colheita();
                colheita.setId(rs.getInt("id"));
                colheita.setDataColheita(rs.getTimestamp("dataColheita"));
                colheita.setQuantidadeColhida(rs.getInt("quantidadeColhida"));
                colheitas.add(colheita);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar colheitas: " + e.getMessage());
        }

        return colheitas;
    }
    public void atualizarColheita(Colheita colheita) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_COLHEITA)) {

            pstmt.setTimestamp(1, colheita.getDataColheita());
            pstmt.setInt(2, colheita.getQuantidadeColhida());
            pstmt.executeUpdate();

            System.out.println("Colheita atualizada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar colheita: " + e.getMessage());
        }
    }

    public Colheita buscarColheitaPorId(int id) {
        Colheita colheita = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_COLHEITA_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    colheita = new Colheita();
                    colheita.setId(rs.getInt("id"));
                    colheita.setDataColheita(rs.getTimestamp("dataColheita"));
                    colheita.setQuantidadeColhida(rs.getInt("quantidadeColhida"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar colheita por ID: " + e.getMessage());
        }

        return colheita;
    }

    public void deletarColheita(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_COLHEITA)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Colheita deletada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar colheita: " + e.getMessage());
        }
    }

}