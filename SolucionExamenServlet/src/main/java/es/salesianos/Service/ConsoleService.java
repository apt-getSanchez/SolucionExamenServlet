package es.salesianos.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.salesianos.Model.*;
import es.salesianos.Repository.*;

@Service
public class ConsoleService implements es.salesianos.Service.Service<Console> {

	private static Logger log = LogManager.getLogger(ConsoleService.class);
	@Autowired
	private ConsoleRepository repository;

	@Override
	public void insert(Console consoleForm) {
		repository.insertConsole(consoleForm);
	}

	@Override
	public List<Console> listAll() {
		return repository.searchAll();
	}

	@Override
	public void delete(String console) {
		repository.delete(console);
	}

	public List<Console> listAllByCompany(int idCompany) {
		return repository.selectByCompany(idCompany);
	}

	public ConsoleRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
}