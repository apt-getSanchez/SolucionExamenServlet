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

public class VideogameByCompany extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("selectCompany"));
		List<Videogame> listAllVideogame = service.listAllByCompany(id);
		req.setAttribute("listAllVideogameByCompany", listAllVideogame);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideogameByCompany.jsp");
		dispatcher.forward(req, resp);
	}
}