package es.salesianos.Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Videogame {

	private String title;
	private Integer pegi;
	private Date releaseDate;
	private int companyId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPegi() {
		return pegi;
	}

	public void setPegi(Integer pegi) {
		this.pegi = pegi;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
