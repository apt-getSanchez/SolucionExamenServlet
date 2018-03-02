<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.Model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show list of videogames by companies</title>
</head>
<body>
<form action="listCompanyVG" method="post">
  <select name="selectCompany" > 
         <c:forEach var="list" items="${listAllCompanyVG}">
	  		<option value="${list.id}">${list.name}</option>
         </c:forEach>
 </select>
<input type="submit" value="Show Companies"/>
</form>
<form action="listByVideogame" method="post">
<input type="submit" value="show list"/>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Age</td>
				<td>Release Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videogame" items="${listAllVideogameByCompany}">
				<tr>
					<td><c:out value="${videogame.title}"/></td>
					<td><c:out value="${videogame.pegi}"/> </td>
					<td><c:out value="${videogame.releaseDate}"/></td>
		    	</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>