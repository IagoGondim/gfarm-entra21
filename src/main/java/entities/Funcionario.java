package entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String cargo;
    private Timestamp dataContratacao;

    public Funcionario(int id, String nome, String cargo, Timestamp dataContratacao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public Funcionario() {

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Timestamp getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Timestamp dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataContratacao='" + dataContratacao + '\'' +
                '}';
    }

}