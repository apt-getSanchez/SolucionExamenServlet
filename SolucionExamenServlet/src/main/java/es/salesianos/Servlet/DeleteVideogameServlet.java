package es.salesianos.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.Assembler.VideogameAssembler;
import es.salesianos.Model.Videogame;
import es.salesianos.Service.VideogameService;

public class DeleteVideogameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame videogameToDelete = VideogameAssembler.assembleVideogameForm(req);
		service.deleteVideogame(videogameToDelete);
		listRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", req.getParameter("title"));
		confirmationRedirect(req, resp);
	}

	private void listRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideogameList.jsp");
		dispatcher.forward(req, resp);
	}

	private void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Confirmation.jsp");
		dispatcher.forward(req, resp);
	}
}