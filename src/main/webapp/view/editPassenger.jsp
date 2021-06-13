<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="../../">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/template.styles.css">
    <c:choose>
        <c:when test="${empty passenger.passengerID}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="./">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="./">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <div class="container pt-5">
        <form class="style" action="${(empty passenger.passengerID) ? add : edit}" name="passenger" method="POST">
            <c:choose>
                <c:when test="${!empty passenger.passengerID}">
                    <h1>Edit Passenger</h1>
                    <p><input type="hidden" name="passengerID" id="passengerID" value="${passenger.passengerID}" >
                </c:when>
                <c:otherwise>
                    <h1>Add Passenger</h1>
                </c:otherwise>
            </c:choose>


            <div class="mb-3">
                <label class="form-label" value="${passenger.firstName}">First Name</label>
                <input type="text" value="${passenger.firstName}" class="form-control" id="firstName" name="firstName"
                       placeholder="Type here ...">
            </div>

            <div class="mb-3">
                <label class="form-label" value="${passenger.lastName}">Last Name</label>
                <input type="text" value="${passenger.lastName}" class="form-control" id="lastName" name="lastName"
                       placeholder="Type here ...">
            </div>

            <div class="mb-3">
                <fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>
                <label class="form-label" value="${passenger.birthDate}">Birth Date</label>
                <input type="date" value="${passenger.birthDate}" class="form-control" id="birthDate" name="birthDate">
            </div>


            <c:set value="add" var="add"/>
            <c:set value="edit" var="edit"/>
            <input type="submit" value="${(empty passenger.passengerID ) ? add : edit}">
            </p>

        </form>
    </div>
</main>

<script src="<%=request.getContextPath()%>/res/frontend/js/inputmask.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/scripts.js"></script>
</body>
</html>
