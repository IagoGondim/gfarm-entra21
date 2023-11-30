package dao;

import entities.Fazenda;
import utils.ConexaoBancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class FazendaDAO {
    private static final String INSERIR_FAZENDA = "INSERT INTO tb_fazenda (nome, areaTotal) VALUES (?, ?)";
    private static final String LISTAR_FAZENDAS = "SELECT * FROM tb_fazenda";
    private static final String ATUALIZAR_FAZENDA = "UPDATE tb_fazenda SET nome=?, areaTotal=? WHERE id=?";
    private static final String BUSCAR_FAZENDA_POR_ID = "SELECT * FROM tb_fazenda WHERE id=?";
    private static final String DELETAR_FAZENDA = "DELETE FROM tb_fazenda WHERE id=?";

    public void inserirFazenda(Fazenda fazenda) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(INSERIR_FAZENDA)) {

            pstmt.setString(1, fazenda.getNome());
            pstmt.setInt(2, fazenda.getAreaTotal());
            pstmt.executeUpdate();

            System.out.println("Fazenda inserida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir fazenda: " + e.getMessage());
        }
    }

    public List<Fazenda> listarFazendas() {
        List<Fazenda> fazendas = new ArrayList<>();

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(LISTAR_FAZENDAS);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Fazenda fazenda = new Fazenda();
                fazenda.setId(rs.getInt("id"));
                fazenda.setNome(rs.getString("nome"));
                fazenda.setAreaTotal(rs.getInt("areaTotal"));
                fazendas.add(fazenda);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar fazendas: " + e.getMessage());
        }

        return fazendas;
    }
    public void atualizarFazenda(Fazenda fazenda) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR_FAZENDA)) {

            pstmt.setString(1, fazenda.getNome());
            pstmt.setInt(2, fazenda.getAreaTotal());
            pstmt.setInt(3, fazenda.getId());
            pstmt.executeUpdate();

            System.out.println("Fazenda atualizada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar fazenda: " + e.getMessage());
        }
    }

    public Fazenda buscarFazendaPorId(int id) {
        Fazenda fazenda = null;

        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(BUSCAR_FAZENDA_POR_ID)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    fazenda = new Fazenda();
                    fazenda.setId(rs.getInt("id"));
                    fazenda.setNome(rs.getString("nome"));
                    fazenda.setAreaTotal(rs.getInt("areaTotal"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar fazenda por ID: " + e.getMessage());
        }

        return fazenda;
    }

    public void deletarFazenda(int id) {
        try (Connection conexao = ConexaoBancoDados.obterConexao();
             PreparedStatement pstmt = conexao.prepareStatement(DELETAR_FAZENDA)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Fazenda deletada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar fazenda: " + e.getMessage());
        }
    }

}