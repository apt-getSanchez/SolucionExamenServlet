package es.salesianos.Assembler;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.Model.Company;

public class CompanyAssembler {

	public static Company assembleCompanyFrom(HttpServletRequest request) {
		Company company = new Company();
		company.setName(request.getParameter("name"));
		company.setCreationDate(Date.valueOf(request.getParameter("creationDate")));
		return company;
	}
}	