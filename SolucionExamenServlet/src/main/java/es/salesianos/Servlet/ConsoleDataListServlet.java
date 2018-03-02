package es.salesianos.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.Model.Console;
import es.salesianos.Service.ConsoleService;

public class ConsoleDataListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ConsoleService service = new ConsoleService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsole = service.listAllConsole();
		req.setAttribute("listAllConsole", listAllConsole);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
		dispatcher.forward(req, resp);
	}
}