<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Videogames By Company </title>
	</head>
	<body>
		<form action="listCompanyVideogame" method="post">
			<select name="company" > 
			    <c:forEach var="list" items="${listAllCompanyVideogame}">
					<option value="${list.id}">${list.name}</option>
			    </c:forEach>
			</select>
			<input type="submit" value="Companies"/>
		</form>
		<form action="listByVideogame" method="post">
		<input type="submit" value="List"/>
			<table border="1">
				<thead>
					<tr>
						<td>Title: </td>
						<td>Pegi: </td>
						<td>Release Date: </td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="videogame" items="${listAllVideogameByCompany}">
						<tr>
							<td><c:out value="${videogame.title}"/></td>
							<td><c:out value="${videogame.pegie}"/> </td>
							<td><c:out value="${videogame.releaseDate}"/></td>
				    	</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</body>
</html>