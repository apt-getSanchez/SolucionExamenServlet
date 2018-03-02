package es.salesianos.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.Assembler.VideogameAssembler;
import es.salesianos.Model.Videogame;
import es.salesianos.Repository.VideogameRepository;

public class VideogameService {

	private VideogameRepository repository = new VideogameRepository();

	public void createNewVideogameFromRequest(HttpServletRequest req) {
		Videogame videogame = VideogameAssembler.assembleVideogameForm(req);
		insertOrUpdate(videogame);
	}

	public void insertOrUpdate(Videogame videogameForm) {
		Videogame videogameInDatabase = repository.search(videogameForm);
		if (null == videogameInDatabase) {
			repository.insert(videogameForm);
		} else {
			repository.update(videogameForm);
		}
	}

	public List<Videogame> listAllVideogame() {
		return repository.searchAll();
	}

	public void deleteVideogame(Videogame videogameToDelete) {
		repository.delete(videogameToDelete);
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}

	public List<Videogame> listAllByCompany(int id) {
		return repository.selectByCompany(id);
	}
}