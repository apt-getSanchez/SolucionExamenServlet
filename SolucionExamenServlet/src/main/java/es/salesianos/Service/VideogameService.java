package es.salesianos.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.Model.Videogame;
import es.salesianos.Repository.*;

@Service
public class VideogameService implements es.salesianos.Service.Service<Videogame> {
	private static Logger log = LogManager.getLogger(ConsoleService.class);
	@Autowired
	private VideogameRepository repository;

	@Override
	public void insert(Videogame VideogameForm) {
		repository.insertVideogame(VideogameForm);
	}

	@Override
	public List<Videogame> listAll() {
		return repository.searchAll();
	}

	@Override
	public void delete(String videogame) {
		repository.delete(videogame);
	}

	public List<Videogame> listAllByCompany(int idCompany) {
		return repository.selectByCompany(idCompany);
	}

	public List<Videogame> OrderByTitle() {
		return repository.orderByTitle();
	}

	public List<Videogame> OrderByReleaseDate() {
		return repository.orderByReleaseDate();
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}
}