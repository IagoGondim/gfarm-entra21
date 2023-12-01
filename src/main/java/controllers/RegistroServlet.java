package controllers;

import dao.UsuarioDAO;
import entities.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String cpf = request.getParameter("cpf");
    String senha = request.getParameter("senha");

    String hashSenha = hashPassword(senha);

    Usuario novoUsuario = new Usuario();
    novoUsuario.setNome(nome);
    novoUsuario.setEmail(email);
    novoUsuario.setCpf(cpf);
    novoUsuario.setPassword(hashSenha);

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    usuarioDAO.inserirUsuario(novoUsuario);

    response.sendRedirect("fazenda.jsp");
  }

  private String hashPassword(String password) {
    // Gera um salt aleatório
    String salt = BCrypt.gensalt();

    // Hash da senha com o salt
    return BCrypt.hashpw(password, salt);
  }
}
