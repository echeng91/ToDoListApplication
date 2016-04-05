<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item</title>
</head>
<body>
	<form action="ExecuteInsert" method="post">
		Item ID: <input type="number" name="itemid"><br>
		Name: <input type="text" name="itemname"><br>
		Description: <input type="text" name="description"><br>
		Status: <br>
		<c:forEach items="${statusoptions}" var="status">
			<input type="radio" name="statusid" value="${status.statusid}"><c:out value="${status.statusdescription}"/><br>
		</c:forEach>
		Due Date: <input type="date" name="duedate"><br>
		Priority: <input type="number" name="priority"><br>
		<input type="submit" value="Add to list"><br>
	</form>
</body>
</html>