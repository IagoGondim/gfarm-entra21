package entities;

import java.io.Serializable;

public class Fazenda implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String nome;
  private int areaTotal;
  private Endereco endereco_id;

  public Fazenda(int id, String nome, int areaTotal, Endereco endereco_id) {
    this.id = id;
    this.nome = nome;
    this.areaTotal = areaTotal;
    this.endereco_id = endereco_id;
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


  public Endereco getEndereco() {
    return endereco_id;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco_id = endereco;
  }

  @Override
  public String toString() {
    return "Fazenda{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", areaTotal=" + areaTotal +
            ", endereco_id=" + endereco_id +
            '}';
  }
}

