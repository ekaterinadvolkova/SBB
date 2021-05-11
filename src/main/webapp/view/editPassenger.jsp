<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>For SBB Staff</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>

<body>

<h1>edit Passenger Page</h1>

<h2><a href="${pageContext.request.contextPath}/">Go back</a> </h2>

<c:url value="/editPassenger" var="var"/>
<form action="${var}" method="POST">
    <input type="number" name="passengerID" value="${passenger.passengerID}"  id="passengerID">

    <label for="firstName">First Name</label>
    <input type="text" name="firstName" id="firstName">

    <label for="lastName">Last Name</label>
    <input type="text" name="lastName" id="lastName">

    <label for="birthDate">Birth Date</label>
    <input type="text" name="birthDate" id="birthDate">

    <input type="submit" value="Submit">

</form>

</body>
</html>
