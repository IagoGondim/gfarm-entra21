package agricola;

import java.sql.*;
import java.util.List;

public class AtividadeAgricolaDAOImpl implements AtividadeAgricolaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/gFarm";

    public AtividadeAgricola salvarAtividadeAgricola(AtividadeAgricola atividadeAgricola) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String query = "INSERT INTO tb_atividadeAgricola (descricao, dataDaAtividade) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, atividadeAgricola.getDescricao());
                preparedStatement.setTimestamp(2, new Timestamp(atividadeAgricola.getDataDaAtividade().getTime()));

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas > 0) {
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        atividadeAgricola.setId(generatedKeys.getInt(1));
                        return atividadeAgricola;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AtividadeAgricola atualizarAtividadeAgricola(AtividadeAgricola atividadeAgricola) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizarAtividadeAgricola'");
    }

    public void deletarAtividadeAgricola(int atividadeAgricolaId) {
        throw new UnsupportedOperationException("Unimplemented method 'deletarAtividadeAgricola'");
    }

    public AtividadeAgricola obterAtividadeAgricolaPorId(int atividadeAgricolaId) {
        throw new UnsupportedOperationException("Unimplemented method 'obterAtividadeAgricolaPorId'");
    }

    public List<AtividadeAgricola> obterTodasAtividadesAgricolas() {
        throw new UnsupportedOperationException("Unimplemented method 'obterTodasAtividadesAgricolas'");
    }
}
