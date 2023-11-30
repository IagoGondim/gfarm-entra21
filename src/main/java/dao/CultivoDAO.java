package dao;

import entities.Cultivo;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CultivoDAO {
    private static final String INSERIR_CULTIVO = "INSERT INTO tb_cultivo (nome, dataDePlantio, dataColheitaPrevista) VALUES (?, ?, ?)";
    private static final String LISTAR_CULTIVOS = "SELECT * FROM tb_cultivo";
    private static final String ATUALIZAR_CULTIVO = "UPDATE tb_cultivo SET nome=?, dataDePlantio=?, dataColheitaPrevista=?, WHERE id=?";
    private static final String BUSCAR_CULTIVO_POR_ID = "SELECT * FROM tb_cultivo WHERE id=?";
    private static final String DELETAR_CULTIVO = "DELETE FROM tb_cultivo WHERE id=?";

    public void inserirCultivo(Cultivo cultivo) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_CULTIVO)) {

            pstmt.setString(1, cultivo.getNome());
            pstmt.setTimestamp(2, cultivo.getDataDePlantio());
            pstmt.setTimestamp(3, cultivo.getDataColheitaPrevista());
            pstmt.executeUpdate();

            System.out.println("Cultivo inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir o cultivo: " + e.getMessage());
        }
    }

    public List<Cultivo> listarLotes() {
        List<Cultivo> cultivos = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_CULTIVOS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cultivo cultivo = new Cultivo();
                cultivo.setId(rs.getInt("id"));
                cultivo.setNome(rs.getString("nome"));
                cultivo.setDataDePlantio(rs.getTimestamp("dataDePlantio"));
                cultivo.setDataColheitaPrevista(rs.getTimestamp("dataColheitaPrevista"));
                cultivos.add(cultivo);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar cultivos: " + e.getMessage());
        }

        return cultivos;
    }
    public void atualizarCultivo(Cultivo cultivo) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_CULTIVO)) {

            pstmt.setString(1, cultivo.getNome());
            pstmt.setTimestamp(2, cultivo.getDataDePlantio());
            pstmt.setTimestamp(3, cultivo.getDataColheitaPrevista());
            pstmt.executeUpdate();

            System.out.println("Cultivo atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cultivo: " + e.getMessage());
        }
    }

    public Cultivo buscarCultivoPorId(int id) {
        Cultivo cultivo = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_CULTIVO_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cultivo = new Cultivo();
                    cultivo.setId(rs.getInt("id"));
                    cultivo.setNome(rs.getString("nome"));
                    cultivo.setDataDePlantio(rs.getTimestamp("dataDePlantio"));
                    cultivo.setDataColheitaPrevista(rs.getTimestamp("dataColheitaPrevista"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cultivo por ID: " + e.getMessage());
        }

        return cultivo;
    }

    public void deletarCultivo(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_CULTIVO)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Cultivo deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar cultivo: " + e.getMessage());
        }
    }

}