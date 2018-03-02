<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Videogames</title>
	</head>
	<body>
		<%
			List<Videogame> listVideogame = (List<Videogame>) request.getAttribute("listAllVideogame");
			pageContext.setAttribute("videogame", listVideogame);
		%>
	
		<form action="dataGames" method="post">
			<table border="1">
				<thead>
					<tr>
						<td>Title</td>
						<td>Pegi</td>
						<td>Release Date</td>
					</tr>
				</thead>
				<c:forEach items="${listVideogame}" var="videogame">
					<tr>
						<td><c:out value="${videogame.title}" /></td>
						<td><c:out value="${videogame.pegi}" /></td>
						<td><c:out value="${videogame.releaseDate}" /></td>
						<td><a href="/deleteVideogame?title=${videogame.title}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Load Table">
		</form>
	</body>
</html>