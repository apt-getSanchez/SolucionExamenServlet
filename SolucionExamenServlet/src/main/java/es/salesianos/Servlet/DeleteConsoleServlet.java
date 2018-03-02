package es.salesianos.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.salesianos.Assembler.ConsoleAssembler;
import es.salesianos.Model.Console;
import es.salesianos.Service.ConsoleService;

public class DeleteConsoleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ConsoleService service = new ConsoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Console consoleToDelete = ConsoleAssembler.assembleConsoleFrom(req);
		service.deleteConsole(consoleToDelete);
		listRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", req.getParameter("name"));
		confirmationRedirect(req, resp);
	}

	private void listRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsoleList.jsp");
		dispatcher.forward(req, resp);
	}

	private void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Confirmation.jsp");
		dispatcher.forward(req, resp);
	}

	public ConsoleService getService() {
		return service;
	}

	public void setService(ConsoleService service) {
		this.service = service;
	}
}