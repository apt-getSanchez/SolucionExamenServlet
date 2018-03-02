package es.salesianos.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.Connection.AbstractConnection;
import es.salesianos.Connection.H2Connection;
import es.salesianos.Model.Company;

public class CompanyRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	AbstractConnection manager = new H2Connection();

	public void insertCompany(Company companyForm) {
		Connection connect = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO COMPANY (name, creationDate)" + "VALUES (?, ?)");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.setDate(2, (Date) companyForm.getCreationDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(connect);
		}
	}

	public List<Company> searchAll() {
		List<Company> listCompany = new ArrayList<Company>();
		Connection connect = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connect.prepareStatement("SELECT * FROM Company");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Company companyInDatabase = new Company();
				companyInDatabase.setId(resultSet.getInt(1));
				companyInDatabase.setName(resultSet.getString(2));
				companyInDatabase.setCreationDate((resultSet.getDate(3)));
				listCompany.add(companyInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(connect);
		}
		return listCompany;
	}
}