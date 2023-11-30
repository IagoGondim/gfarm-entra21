package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cultivo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private Timestamp dataDePlantio;
    private Timestamp dataColheitaPrevista;

    public Cultivo(int id, String nome, Timestamp dataDePlantio, Timestamp dataColheitaPrevista) {
        this.id = id;
        this.nome = nome;
        this.dataDePlantio = dataDePlantio;
        this.dataColheitaPrevista = dataColheitaPrevista;
    }

    public Cultivo() {

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

    public Timestamp getDataDePlantio() {
        return dataDePlantio;
    }

    public void setDataDePlantio(Timestamp dataDePlantio) {
        this.dataDePlantio = dataDePlantio;
    }

    public Timestamp getDataColheitaPrevista() {
        return dataColheitaPrevista;
    }

    public void setDataColheitaPrevista(Timestamp dataColheitaPrevista) {
        this.dataColheitaPrevista = dataColheitaPrevista;
    }

    @Override
    public String toString() {
        return "Cultivo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataDePlantio='" + dataDePlantio + '\'' +
                ", dataColheitaPrevista='" + dataColheitaPrevista + '\'' +
                '}';
    }

}