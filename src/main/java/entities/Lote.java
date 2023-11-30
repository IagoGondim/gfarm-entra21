package entities;

import java.io.Serializable;

public class Lote implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private int areaTotal;
    private String tipoDeSolo;

    public Lote(int id, String nome, int areaTotal, String tipoDeSolo) {
        this.id = id;
        this.nome = nome;
        this.areaTotal = areaTotal;
        this.tipoDeSolo = tipoDeSolo;
    }

    public Lote() {

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

    public String getTipoDeSolo() {
        return tipoDeSolo;
    }

    public void setTipoDeSolo(String tipoDeSolo) {
        this.tipoDeSolo = tipoDeSolo;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", areaTotal='" + areaTotal + '\'' +
                ", tipoDeSolo='" + tipoDeSolo + '\'' +
                '}';
    }

}


