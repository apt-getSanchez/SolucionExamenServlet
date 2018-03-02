package es.salesianos.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import es.salesianos.Model.Videogame;

@Component
public class VideogameRepository {
	private static Logger log = LogManager.getLogger(ConsoleRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insertVideogame(Videogame videogameForm) {
		log.debug("succesful insert");
		String sql = "INSERT INTO VIDEOGAME (title, pegi, releaseDate, companyId)"
				+ "VALUES ( :title, :pegi, :releaseDate, :companyId)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", videogameForm.getTitle());
		params.addValue("pegi", videogameForm.getPegi());
		params.addValue("releaseDate", videogameForm.getReleaseDate());
		params.addValue("companyId", videogameForm.getCompanyId());
		namedJdbcTemplate.update(sql, params);
	}

	public List<Videogame> searchAll() {
		String sql = "SELECT * FROM VIDEOGAME";
		List<Videogame> listVideogame = template.query(sql, new BeanPropertyRowMapper(Videogame.class));
		return listVideogame;
	}

	public List<Videogame> selectByCompany(int id) {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM VIDEOGAME WHERE companyId = ?",
				new MapSqlParameterSource("companyId", String.valueOf(id)));
		for (Map row : rows) {
			Videogame videogame = new Videogame();
			videogame.setTitle((String) (row.get("title")));
			videogame.setPegi((Integer) (row.get("pegi")));
			videogame.setReleaseDate(Date.valueOf((String) (row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public List<Videogame> orderByTitle() {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList("SELECT * FROM VIDEOGAME ORDER BY title ASC",
				new MapSqlParameterSource());
		for (Map row : rows) {
			Videogame videogame = new Videogame();
			videogame.setTitle((String) (row.get("title")));
			videogame.setPegi((Integer) (row.get("pegi")));
			videogame.setReleaseDate(Date.valueOf((String) (row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public List<Videogame> orderByReleaseDate() {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		List<Map<String, Object>> rows = namedJdbcTemplate
				.queryForList("SELECT * FROM VIDEOGAME ORDER BY releaseDate ASC", new MapSqlParameterSource());
		for (Map row : rows) {
			Videogame videogame = new Videogame();
			videogame.setTitle((String) (row.get("title")));
			videogame.setPegi((Integer) (row.get("pegi")));
			videogame.setReleaseDate(Date.valueOf(String.valueOf(row.get("releaseDate"))));
			videogame.setCompanyId(Integer.parseInt(String.valueOf(row.get("companyId"))));
			listVideogame.add(videogame);
		}
		return listVideogame;
	}

	public void delete(String name) {
		log.debug("tablename: Videogame");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		String sql = "DELETE FROM VIDEOGAME WHERE title = '?'";
		namedJdbcTemplate.update(sql, params);
		log.debug(sql);
	}

}