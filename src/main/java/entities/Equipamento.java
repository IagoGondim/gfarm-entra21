package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String descricao;
    private Timestamp dataDeCompra;

    public Equipamento(int id, String nome, String descricao, Timestamp dataDeCompra) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeCompra = dataDeCompra;
    }

    public Equipamento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(Timestamp dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    @Override
    public String toString() {
        return "Fazenda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao=" + descricao +
                ", dataDeCompra=" + dataDeCompra +
                '}';
    }
}