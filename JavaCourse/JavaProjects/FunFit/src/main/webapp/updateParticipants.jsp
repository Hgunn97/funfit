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
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="pid" value="${sessionScope.participant.getPid()}" />

<label>FName</label>
<input type="text" name="fname" value="${sessionScope.participant.getFname()}"><br/>
<label>Age</label>
<input type="number" name="age" value="${sessionScope.participant.getAge()}"><br/>
<label>PhNumber</label>
<input type="text" name="phonenumber" value="${sessionScope.participant.getPhonenumber()}"><br/>

<label>Batch</label>
<select name="bid">
 <core:forEach var="batch" items="${sessionScope.batches}">
        <option value="${batch.getBid()}" <core:if test="${participant.getBid() == batch.getBid()}">selected</core:if>>${batch.getTypeofbatch()} - ${batch.getTime()}</option>
    </core:forEach>
</select>
<br/>
<input type="submit" value="Update Participants"/>
<input type="reset" value="reset"/>
</form>
<br/>
<a href="ParticipantsController">Back</a>
</body>
</html>