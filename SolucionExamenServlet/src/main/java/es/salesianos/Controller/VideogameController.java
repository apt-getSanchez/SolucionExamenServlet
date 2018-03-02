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
import es.salesianos.Service.VideogameService;

@Controller
public class VideogameController {

	private static Logger log = LogManager.getLogger(VideogameController.class);

	@Autowired
	private VideogameService service;

	@GetMapping("/addVideogame")
	public ModelAndView insertVideoGame() {
		return new ModelAndView("AddVideogame", "command", new Videogame());
	}

	@PostMapping("/addVideogame")
	public ModelAndView create(@ModelAttribute("Videogame") Videogame videogame) {
		log.debug("inserting Videogame");
		service.insert(videogame);
		return new ModelAndView("AddVideoGame", "command", new Videogame());
	}

	@GetMapping("/listVideogame")
	public ModelAndView listVideogame() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.listAll());
		return modelAndView;
	}

	@PostMapping("/listVideogame")
	public ModelAndView list() {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.listAll());
		return modelAndView;
	}

	@PostMapping("/listVideogameByCompany")
	public ModelAndView listByCompany(int companyId) {
		log.debug("show list");
		ModelAndView modelAndView = new ModelAndView("ListVideogameByCompany", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.listAllByCompany(companyId));
		return modelAndView;
	}

	@GetMapping("/listVideogameReleaseDate")
	public ModelAndView listOrderReleaseDate() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideogameReleaseDate", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.OrderByReleaseDate());
		return modelAndView;
	}

	@PostMapping("/OrderByReleaseDate")
	public ModelAndView listOrderByReleaseDate() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideogameReleaseDate", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.OrderByReleaseDate());
		return modelAndView;
	}

	@GetMapping("/listVideogameTitle")
	public ModelAndView listOrderByTitle() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideogameTitle", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.OrderByTitle());
		return modelAndView;
	}

	@PostMapping("/OrderByTitle")
	public ModelAndView listOrderTitle() {
		log.debug("starting to order list");
		ModelAndView modelAndView = new ModelAndView("ListVideogameTitle", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.OrderByTitle());
		return modelAndView;
	}

	@GetMapping("/deleteVG")
	public ModelAndView deleteVideogame(@ModelAttribute("VideoGame") String name) {
		log.debug("removing videogame");
		ModelAndView modelAndView = new ModelAndView("confirmationVideogame", "command", new Videogame());
		modelAndView.addObject("name", name);
		return modelAndView;
	}

	@PostMapping("/deleteVG")
	public ModelAndView delete(@ModelAttribute("Videogame") String name) {
		log.debug("removing videogame");
		service.delete(name);
		ModelAndView modelAndView = new ModelAndView("ListVideogame", "command", new Videogame());
		modelAndView.addObject("listAllVideogame", service.listAll());
		return modelAndView;
	}

}