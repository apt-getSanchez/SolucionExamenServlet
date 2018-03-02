salesianos es.salesianos.Connection;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import es.salesianos.Model.Console;

public interface ConnectionManager {

	public Connection open(String jdbcUrl);

	public void close(Connection connect);

	void insert(Console console);

	Optional<Console> search(Console console);

	void update(Console console);

	List<Console> listAllConsoles();
}
