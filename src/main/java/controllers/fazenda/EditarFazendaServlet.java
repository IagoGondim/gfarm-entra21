package controllers.fazenda;

import dao.FazendaDAO;
import entities.Fazenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditarFazendaServlet")
public class EditarFazendaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int fazendaId = Integer.parseInt(request.getParameter("id"));
    String novoNome = request.getParameter("novoNome");
    int novaAreaTotal = Integer.parseInt(request.getParameter("novaAreaTotal"));

    Fazenda fazendaAtualizada = new Fazenda();
    fazendaAtualizada.setId(fazendaId);
    fazendaAtualizada.setNome(novoNome);
    fazendaAtualizada.setAreaTotal(novaAreaTotal);

    FazendaDAO fazendaDAO = new FazendaDAO();

    fazendaDAO.atualizarFazenda(fazendaAtualizada);

    response.sendRedirect("fazenda.jsp");
  }
}
