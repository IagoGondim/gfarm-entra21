package controllers.fazenda;

import dao.FazendaDAO;
import entities.Endereco;
import entities.Fazenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CadastroFazendaServlet")
public class CadastroFazendaServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
    String nome = request.getParameter("nome");
    int areaTotal = Integer.parseInt(request.getParameter("areaTotal"));
    String logradouro = request.getParameter("logradouro");
    int numero = Integer.parseInt(request.getParameter("numero"));
    String bairro = request.getParameter("bairro");
    String cidade = request.getParameter("cidade");

    Endereco endereco = new Endereco();
    endereco.setLogradouro(logradouro);
    endereco.setNumero(numero);
    endereco.setBairro(bairro);
    endereco.setCidade(cidade);

    Fazenda fazenda = new Fazenda();
    fazenda.setNome(nome);
    fazenda.setAreaTotal(areaTotal);
    fazenda.setEndereco(endereco);

    FazendaDAO fazendaDAO = new FazendaDAO();
    fazendaDAO.inserirFazenda(fazenda);


    response.sendRedirect("fazenda.jsp");

  }
}
