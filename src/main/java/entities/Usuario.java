package entities;

import java.io.Serializable;

public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  private int id;
  private String nome;
  private String cpf;
  private String email;
  private String password;

  public Usuario(int id, String nome, String cpf, String email, String password) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.email = email;
    this.password = password;
  }

  public Usuario() {

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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
  }


}
