package es.salesianos.Assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.Model.Console;

public class ConsoleAssembler {
	
	public static Console assembleConsoleFrom(HttpServletRequest request) {
		Console console = new Console();
		int code = Integer.parseInt(request.getParameter("codCompany"));
		console.setName(request.getParameter("name"));
		console.setCodCompany(code);
		return console;
	}
}
