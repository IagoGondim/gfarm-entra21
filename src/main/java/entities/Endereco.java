package entities;

import java.io.Serializable;

public class Endereco implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String logradouro;
  private int numero;
  private String bairro;
  private String cidade;


  public Endereco(int id, String logradouro, int numero, String bairro, String cidade) {
    this.id = id;
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
  }

  public Endereco() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  @Override
  public String toString() {
    return "Endereco{" +
            "id=" + id +
            ", logradouro='" + logradouro + '\'' +
            ", numero=" + numero +
            ", bairro='" + bairro + '\'' +
            ", cidade='" + cidade + '\'' +
            '}';
  }
}
