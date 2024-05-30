<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib
    prefix="core"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Batch Details</h2>
<form action="BatchController" method="post">
<input type="hidden" name="action" value="update"/>
<input type="hidden" name="bid" value="${sessionScope.batch.getBid()}" />
<label>TypeOfBatch</label>
<select name="typeofbatch">
<option value="">--Select Batch--</option>
<option value="Morning" ${sessionScope.batch.typeofbatch == 'morning' ? 'selected' : ''}>Morning</option>
<option value="Evening" ${sessionScope.batch.typeofbatch == 'evening' ? 'selected' : ''}>Evening</option>
</select>
<br/>
<label>Time</label>
<select name="time">
<option value="">--Time--</option>
<option value="1-2" ${sessionScope.batch.getTime() == "1-2" ? "selected" : ""}>1-2</option>
<option value="2-3" ${sessionScope.batch.getTime() == "2-3" ? "selected" : ""}>2-3</option>
<option value="3-4" ${sessionScope.batch.getTime() == "3-4" ? "selected" : ""}>3-4</option>
<option value="4-5" ${sessionScope.batch.getTime() == "4-5" ? "selected" : ""}>4-5</option>
<option value="5-6" ${sessionScope.batch.getTime() == "5-6" ? "selected" : ""}>5-6</option>
<option value="6-7" ${sessionScope.batch.getTime() == "6-7" ? "selected" : ""}>6-7</option>
<option value="7-8" ${sessionScope.batch.getTime() == "7-8" ? "selected" : ""}>7-8</option>
<option value="8-9" ${sessionScope.batch.getTime() == "8-9" ? "selected" : ""}>8-9</option>
<option value="9-10" ${sessionScope.batch.getTime() == "9-10" ? "selected" : ""}>9-10</option>
<option value="10-11" ${sessionScope.batch.getTime() == "10-11" ? "selected" : ""}>10-11</option>
<option value="11-12" ${sessionScope.batch.getTime() == "11-12" ? "selected" : ""}>11-12</option>
</select>
<br/>
<input type="submit" value="Update Batch"/>
<input type="reset" value="reset"/>
</form>

<br />
<a href="BatchController?flag=1">Back</a>
</body>
</html>