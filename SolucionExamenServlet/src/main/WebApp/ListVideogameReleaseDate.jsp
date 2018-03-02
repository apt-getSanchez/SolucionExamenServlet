<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.Model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show list of videogames</title>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<td>Title</td>
			<td>Pegi</td>
			<td>Release Date</td>
			<td>Company</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="videogame" items="${listAllVideogame}">
			<tr>
				<td><c:out value="${videogame.title}"/> </td>
				<td><c:out value="${videogame.pegi}"/> </td>
				<td><c:out value="${videogame.releaseDate}"/> </td>
				<td><c:out value="${videogame.companyId}"/> </td>
				<td><a href="/deleteVG?title=${videogame.title}">Delete</a></td>
				
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>