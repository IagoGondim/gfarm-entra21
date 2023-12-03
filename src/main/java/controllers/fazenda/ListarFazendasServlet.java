package controllers.fazenda;

import dao.FazendaDAO;
import entities.Fazenda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListarFazendasServlet")
public class ListarFazendasServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    FazendaDAO fazendaDAO = new FazendaDAO();

    out.println("<html><body>");
    out.println("<h2>Listar Fazendas</h2>");

    List<Fazenda> fazendas = fazendaDAO.listarFazendas();

    for (Fazenda fazenda : fazendas) {
      out.println("<p>ID: " + fazenda.getId() + ", Nome: " + fazenda.getNome() + ", Área Total: "
              + fazenda.getAreaTotal() + "</p>");
    }

    out.println("</body></html>");
  }
}
