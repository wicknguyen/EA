<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Book</title>
</head>

<body>
	<h1>List Book</h1>
	<table>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.title}</td>
				<td>${book.ISBN}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.publishedDate}</td>
				<sec:authorize access="hasRole('ADMIN')">
					<td><a href="book/${book.id}">edit</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="book/add"> Add a Book</a>
	</sec:authorize>
	<a href="logout">Logout</a>
</body>

</html>
