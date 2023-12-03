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

@WebServlet("/BuscarFazendaPorIdServlet")
public class BuscarFazendaPorIdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<link rel=\"stylesheet\" href=\"./style/reset.css\">\n");
    out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN' crossorigin='anonymous'>");

    FazendaDAO fazendaDAO = new FazendaDAO();

    out.println("<html><body class=\"container mx-auto p-xl-5\">");
    out.println("<h2>Buscar Fazenda por ID</h2>");

    int fazendaId = Integer.parseInt(request.getParameter("idBuscar"));

    Fazenda fazenda = fazendaDAO.buscarFazendaPorId(fazendaId);

    if (fazenda != null) {
      out.println("<p>ID: " + fazenda.getId() + ", Nome: " + fazenda.getNome() + ", Área Total: "
              + fazenda.getAreaTotal() + "</p>");
    } else {
      out.println("<p>Fazenda não encontrada com ID: " + fazendaId + "</p>");
    }

    out.println("</body></html>");
  }
}
