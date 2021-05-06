<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Edit Passenger Page</title>
</head>

<body>

<h1>edit Passenger Page</h1>

<h2><a href="${pageContext.request.contextPath}/">Go back</a> </h2>

<c:url value="/editPassenger" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="passengerID" value="${passenger.passengerID}">

    <label for="firstName">First Name</label>
    <input type="text" name="firstName" id="firstName">

    <label for="lastName">Last Name</label>
    <input type="text" name="lastName" id="lastName">

    <label for="birthDate">Birth Date</label>
    <input type="text" name="birthDate" id="birthDate">

    <input type="submit" value="Edit passenger">

</form>

</body>
</html>
