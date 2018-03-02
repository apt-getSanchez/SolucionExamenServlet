package es.salesianos.Service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import es.salesianos.Assembler.CompanyAssembler;
import es.salesianos.Model.Company;
import es.salesianos.Model.Console;
import es.salesianos.Repository.CompanyRepository;

public class CompanyService {

	CompanyAssembler assembler = new CompanyAssembler();
	private CompanyRepository repository = new CompanyRepository();

	public Company assembleUserFromRequest(HttpServletRequest req) {
		return CompanyAssembler.assembleCompanyFrom(req);
	}

	public void createNewCompanyFromRequest(HttpServletRequest req) {
		Company company = CompanyAssembler.assembleCompanyFrom(req);
		insertOrUpdate(company);
	}

	public void insertOrUpdate(Company companyForm) {
		Company companyInDatabase = repository.search(companyForm);
		if (null == companyInDatabase) {
			repository.insert(companyForm);
		} else {
			repository.update(companyForm);
		}
	}

	public List<Company> listAllCompany() {
		return repository.searchAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}

	public List<Console> listAllByCompany(int id) {
		return null;
	}
}