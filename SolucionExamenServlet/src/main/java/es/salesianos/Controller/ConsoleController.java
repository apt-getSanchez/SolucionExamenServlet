package es.salesianos.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.Model.*;
import es.salesianos.Service.ConsoleService;


@Controller
public class ConsoleController {

	private static Logger log = LogManager.getLogger(ConsoleController.class);

	@Autowired
	private ConsoleService service;

	@GetMapping("/addConsole")
	public ModelAndView create() {
		log.debug("inserting console");
		return new ModelAndView("AddConsole", "command", new Console());
	}
	@PostMapping("/addConsole")
	public ModelAndView insertConsole(@ModelAttribute("console") Console console) {
		log.debug("inserting console");
		service.insert(console);
		return new ModelAndView("AddConsole", "command", new Console());
	}
	@GetMapping("/listConsole")
	public ModelAndView list() {
		log.debug("show list console");
		ModelAndView modelAndView = new ModelAndView("ListConsole", "command", new Console());
		modelAndView.addObject("listAllConsole", service.listAll());
		return modelAndView;
	}
	@PostMapping("/listConsole")
	public ModelAndView listConsole() {
		log.debug("show list console");
		ModelAndView modelAndView = new ModelAndView("ListConsole", "command", new Console());
		modelAndView.addObject("listAllConsole", service.listAll());
		return modelAndView;
	}
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute("console") String name) {
		log.debug("removing console");
		ModelAndView modelAndView = new ModelAndView("confirmationConsole", "command", new Console());
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	@PostMapping("/delete")
	public ModelAndView deleteConsole(@ModelAttribute("console") String name) {
		log.debug("removing console");
		service.delete(name);
		ModelAndView modelAndView = new ModelAndView("ListConsole", "command", new Console());
		modelAndView.addObject("listAllConsole", service.listAll());
		return modelAndView;
	}
	@GetMapping("/listByCompany")
	public ModelAndView listByCompany(int companyId) {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListConsoleByCompany", "command", new Console());
		modelAndView.addObject("listAllConsoleByCompany", service.listAllByCompany(companyId));
		return modelAndView;
	}
}