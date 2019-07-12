<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Book</title>
</head>

<body>
	<c:if test="${msg == 'Update'}">
		<c:set var="action" scope="page" value="../book/${book.id}" />
	</c:if>
	<c:if test="${msg == 'Add'}">
		<c:set var="action" scope="page" value="../book" />
	</c:if>
	<form:form modelAttribute="book" action="${action}" method="post">
		<form:errors path="*" element="div" cssClass="error"/>
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /> </td>
				<td><form:errors path="title" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input path="ISBN" /></td>
				<td><form:errors path="ISBN" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td>Published Date:</td>
				<td><form:input path="publishedDate" /></td>
				<td><form:errors path="publishedDate" /></td>
			</tr>
		</table>
		<input type="submit"/>
	</form:form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="post">
			<button type="submit">Delete</button>
			<sec:csrfInput/>
		</form>
	</c:if>
</body>

</html>
