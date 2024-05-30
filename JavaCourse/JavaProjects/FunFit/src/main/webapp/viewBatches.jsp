<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib
    prefix="core"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Batches</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Batch Details</h2>


<table border="1" class="table">
	<tr>
		<th>Batch Id</th>
		<th>Type Of Batch</th>
		<th>Time</th>
		<th>Actions</th>
	</tr>
	<core:forEach var="batch" items="${sessionScope.batches}">
		<tr>
		<td><core:out value="${batch.getBid()}"></core:out> </td>
		<td><core:out value="${batch.getTypeofbatch()}"></core:out> </td>
		<td><core:out value="${batch.getTime()}"></core:out> </td>
		<td>
		<form action="BatchController" method="post">
		        <input type="hidden" name="action" value="delete"/>
		        <input type="hidden" name="bid" value="${batch.getBid()}"/>
		        <input class="btn btn-primary" type="submit" value="Delete Batch"/>
		    </form>
		     <a href="BatchController?action=edit&bid=${batch.getBid()}" class="btn btn-primary">Update</a>
		     <a href="ParticipantsController?action=view&bid=${batch.getBid()}" class="btn btn-primary">View Participants</a>
		</td>
		</tr>
	</core:forEach>
	</table>

<br />
<a href="index.html">Back</a>
</body>
</html>