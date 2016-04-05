<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>To Do List</title>
</head>
<body>
	<table>
		<tr>
			<th>Item ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Status</th>
			<th>Date Completed</th>
			<th>Due Date</th>
			<th>Priority</th>
			<th></th>
		</tr>
		<c:forEach items="${todolist}" var="item">
			<tr>
				<td><c:out value="${item.itemid}" /></td>
				<td><c:out value="${item.itemname}" /></td>
				<td><c:out value="${item.itemdescription}" /></td>
				<td><c:out value="${item.status.statusdescription}" /></td>
				<td><c:out value="${item.datecompleted}" /></td>
				<td><c:out value="${item.duedate}" /></td>
				<td><c:out value="${item.priority}" /></td>
				<td>
					<form action="EditListItem" method="post">
						<input type="hidden" name="edititemid" value="${item.itemid}">
						<input type="submit" value="Edit item">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form action="AddListItem" method="post">
		<input type="submit" value="Add item">
	</form>
</body>
</html>