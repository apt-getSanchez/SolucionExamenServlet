package es.salesianos.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.Model.Videogame;
import es.salesianos.Service.VideogameService;

public class VideogameDataListServlet extends HttpServlet {

	private VideogameService service = new VideogameService();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videogame> listAllVideogame = service.listAllVideogame();
		req.setAttribute("listAllVideogame", listAllVideogame);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideogameList.jsp");
		dispatcher.forward(req, resp);
	}
}