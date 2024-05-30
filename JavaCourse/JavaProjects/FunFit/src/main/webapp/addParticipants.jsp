<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Participants</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Add Participants Details</h2>
<form action="ParticipantsController" method="post">

<label>FName</label>
<input type="text" name="fname"><br/>
<label>Age</label>
<input type="number" name="age"><br/>
<label>PhNumber</label>
<input type="text" name="phonenumber"><br/>

<label>Batch</label>
<select name="bid">
<core:forEach var="bid" items="${sessionScope.batches}">
	<option value="<core:out value="${bid.getBid()}"></core:out>"> <core:out value="${bid.getTypeofbatch()}"></core:out> 
	- 
	<core:out value="${bid.getTime()}"></core:out></option>
</core:forEach>
</select>
<br/>
<input type="submit" value="Add Participants"/>
<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.html">Back</a>
</body>
</html>