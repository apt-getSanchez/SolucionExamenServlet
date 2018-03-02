package es.salesianos.Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Company {

	private Integer id;
	private String name;
	private Date creationDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}