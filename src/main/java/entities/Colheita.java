package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Colheita implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Timestamp dataColheita;
    private int quantidadeColhida;

    public Colheita(int id, Timestamp dataColheita, int quantidadeColhida) {
        this.id = id;
        this.dataColheita = dataColheita;
        this.quantidadeColhida = quantidadeColhida;
    }

    public Colheita() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(Timestamp dataColheita) {
        this.dataColheita = dataColheita;
    }

    public int getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(int quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }

    @Override
    public String toString() {
        return "Colheita{" +
                "id=" + id +
                ", dataColheita='" + dataColheita + '\'' +
                ", quantidadeColhida='" + quantidadeColhida + '\'' +
                '}';
    }

}