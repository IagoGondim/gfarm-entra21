package entities;

import java.io.Serializable;

public class Fazenda implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private int areaTotal;

    public Fazenda(int id, String nome, int areaTotal) {
        this.id = id;
        this.nome = nome;
        this.areaTotal = areaTotal;
    }

    public Fazenda() {

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

    public int getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(int areaTotal) {
        this.areaTotal = areaTotal;
    }

    @Override
    public String toString() {
        return "Fazenda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", areaTotal='" + areaTotal + '\'' +
                '}';
    }

}