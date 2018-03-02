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
import es.salesianos.Service.CompanyService;

@Controller
public class CompanyController {

	private static Logger log = LogManager.getLogger(CompanyController.class);
	@Autowired
	private CompanyService service;

	@GetMapping("/listConsoleByCompany")
	public ModelAndView listConsoleByCompanyGet() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListConsoleByCompany", "command", new Company());
		modelAndView.addObject("listAllCompany", service.listAll());
		return modelAndView;
	}

	@GetMapping("/listVideogameByCompany")
	public ModelAndView listVideoGameByCompany() {
		log.debug("list by company");
		ModelAndView modelAndView = new ModelAndView("ListVideogameByCompany", "command", new Company());
		modelAndView.addObject("listAllCompanyVG", service.listAll());
		return modelAndView;
	}

	@GetMapping("/addCompany")
	public ModelAndView insertCompany() {
		log.debug("inserting company");
		return new ModelAndView("AddCompany", "command", new Company());
	}

	@PostMapping("/addCompany")
	public ModelAndView create(@ModelAttribute("company") Company company) {
		log.debug("inserting company");
		service.insert(company);
		return new ModelAndView("AddCompany", "command", new Company());
	}

}