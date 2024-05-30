<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib
    prefix="core"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Participants</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Participants Details</h2>

<table border="1" class="table">
	<tr>
		<th>Participant Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Phone Number</th>
		<th>Batch Number</th>
		<th>Actions</th>
	</tr>
	<core:forEach var="participant" items="${sessionScope.participants}">
		<tr>
		<td><core:out value="${participant.getPid()}"></core:out> </td>
		<td><core:out value="${participant.getFname()}"></core:out> </td>
		<td><core:out value="${participant.getAge()}"></core:out> </td>
		<td><core:out value="${participant.getPhonenumber()}"></core:out> </td>
		<td><core:out value="${participant.getBid()}"></core:out> </td>
				<td>
		<form action="ParticipantsController" method="post">
		        <input type="hidden" name="action" value="delete"/>
		        <input type="hidden" name="pid" value="${participant.getPid()}"/>
		        <input class="btn btn-primary" type="submit" value="Delete Participant"/>
		    </form>
		     <a href="ParticipantsController?action=edit&pid=${participant.getPid()}" class="btn btn-primary">Update</a>
		</td>
		</tr>
	</core:forEach>
	</table>

<br />
<a href="index.html">Back</a>
</body>
</html>