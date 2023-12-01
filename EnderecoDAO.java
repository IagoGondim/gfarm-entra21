package endereco;

import java.util.List;

public interface EnderecoDAO {
    Endereco salvarEndereco(Endereco endereco);
    Endereco atualizarEndereco(Endereco endereco);
    void deletarEndereco(int enderecoId);
    Endereco obterEnderecoPorId(int enderecoId);
    List<Endereco> obterTodosEnderecos();
}
