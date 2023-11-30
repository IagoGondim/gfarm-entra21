package dao;

import entities.Lote;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {
    private static final String INSERIR_LOTE = "INSERT INTO tb_lote (nome, areaTotal, tipoDeSolo) VALUES (?, ?, ?)";
    private static final String LISTAR_LOTES = "SELECT * FROM tb_lote";
    private static final String ATUALIZAR_LOTE = "UPDATE tb_lote SET nome=?, areaTotal=?, tipoDeSolo=?, WHERE id=?";
    private static final String BUSCAR_LOTE_POR_ID = "SELECT * FROM tb_lote WHERE id=?";
    private static final String DELETAR_LOTE = "DELETE FROM tb_lote WHERE id=?";

    public void inserirLote(Lote lote) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_LOTE)) {

            pstmt.setString(1, lote.getNome());
            pstmt.setInt(2, lote.getAreaTotal());
            pstmt.setString(3, lote.getTipoDeSolo());
            pstmt.executeUpdate();

            System.out.println("Lote inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir lote: " + e.getMessage());
        }
    }

    public List<Lote> listarLotes() {
        List<Lote> lotes = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_LOTES);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Lote lote = new Lote();
                lote.setId(rs.getInt("id"));
                lote.setNome(rs.getString("nome"));
                lote.setAreaTotal(rs.getInt("areaTotal"));
                lote.setTipoDeSolo(rs.getString("tipoDeSolo"));
                lotes.add(lote);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar lotes: " + e.getMessage());
        }

        return lotes;
    }
    public void atualizarLote(Lote lote) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_LOTE)) {

            pstmt.setString(1, lote.getNome());
            pstmt.setInt(2, lote.getAreaTotal());
            pstmt.setInt(3, lote.getId());
            pstmt.executeUpdate();

            System.out.println("Lote atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar lote: " + e.getMessage());
        }
    }

    public Lote buscarLotePorId(int id) {
        Lote lote = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_LOTE_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    lote = new Lote();
                    lote.setId(rs.getInt("id"));
                    lote.setNome(rs.getString("nome"));
                    lote.setAreaTotal(rs.getInt("areaTotal"));
                    lote.setTipoDeSolo(rs.getString("tipoDeSolo"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar lote por ID: " + e.getMessage());
        }

        return lote;
    }

    public void deletarLote(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_LOTE)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Lote deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar lote: " + e.getMessage());
        }
    }

}