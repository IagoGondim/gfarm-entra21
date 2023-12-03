package controllers.fazenda;

import dao.FazendaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeletarFazendaPorIdServlet")
public class DeletarFazendaPorIdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int fazendaId = Integer.parseInt(request.getParameter("idDeletar"));

    FazendaDAO fazendaDAO = new FazendaDAO();

    fazendaDAO.deletarFazenda(fazendaId);

    response.sendRedirect("fazenda.jsp");
  }
}
