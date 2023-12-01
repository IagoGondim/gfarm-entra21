package agricola;

import java.util.List;

public interface AtividadeAgricolaDAO {
    AtividadeAgricola salvarAtividadeAgricola(AtividadeAgricola atividadeAgricola);
    AtividadeAgricola atualizarAtividadeAgricola(AtividadeAgricola atividadeAgricola);
    void deletarAtividadeAgricola(int atividadeAgricolaId);
    AtividadeAgricola obterAtividadeAgricolaPorId(int atividadeAgricolaId);
    List<AtividadeAgricola> obterTodasAtividadesAgricolas();
}
