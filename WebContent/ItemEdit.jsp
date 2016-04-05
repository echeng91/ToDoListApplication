<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Item</title>
</head>
<body>
<h3>Editing Item: <c:out value="${itemname}" /></h3>
	<form action="ExecuteUpdate" method="post">
		<input type="hidden" name="updateitemid" value="${edititemid}">
		Status: <br>
		<c:forEach items="${statusoptions}" var="status">
			<input type="radio" name="newstatusid" value="${status.statusid}"><c:out value="${status.statusdescription}"/><br>
		</c:forEach>
		Due Date: <input type="date" name="duedate" value="${defaultduedate}"><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>