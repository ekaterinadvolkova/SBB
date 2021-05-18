<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
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



<form class="style" action="${(empty passenger.passengerID) ? add : edit}" name="passenger" method="POST">
    <c:choose>
    <c:when test="${!empty passenger.passengerID}">
    <p class="heading">Edit passenger</p>
        <p><input type="hidden" name="passengerID" id="passengerID"  value="${passenger.passengerID}" >
    </c:when>
    <c:otherwise>
    <p class="heading">Add new passenger</p>
    </c:otherwise>
    </c:choose>

    <p><input type="text" name="firstName" id="firstName" placeholder="firstName" value="${passenger.firstName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p><input type="text" name="lastName" id="lastName" placeholder="lastName" value="${passenger.lastName}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <fmt:formatDate value="${bean.date}" pattern="dd-MM-yyyy"/>
    <p><input class ="input" type="date" name="birthDate" id="birthDate" placeholder="birthDate" value="${passenger.birthDate}" maxlength="50" required autofocus pattern="^[^\s]+(\s.*)?$">
    <p>
        <c:set value="add" var="add"/>
        <c:set value="editPassenger" var="edit"/>
        <input type="submit" value="${(empty passenger.passengerID ) ? add : edit}">
    </p>
    <p class="heading"><a href="${pageContext.request.contextPath}/">Go back</a> </p>
</form>
</body>
</html>


<%--<!DOCTYPE html>--%>
<%--<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

<%--    <title>Swiss Federal Railways</title>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <base href=".../">--%>
<%--    <link rel="stylesheet" href="./res/frontend/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" href="./res/frontend/res/frontend/css/bootstrap-icons.css">--%>
<%--    <link rel="stylesheet" href="./res/frontend/res/frontend/css/template.styles.css">--%>

<%--    <c:choose>--%>
<%--        <c:when test="${empty passenger.passengerID}">--%>
<%--                <title>Add</title>--%>
<%--            </c:when>--%>
<%--        <c:otherwise>--%>
<%--                <title>Edit</title>--%>
<%--            </c:otherwise>--%>
<%--    </c:choose>--%>
<%--    --%>
<%--</head>--%>
<%--<body>--%>

<%--<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand" href="index.html">Swiss Federal Railways</a>--%>
<%--        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>

<%--        <div class="collapse navbar-collapse" id="navbarsExample03">--%>
<%--            <ul class="navbar-nav me-auto mb-2 mb-sm-0">--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link active" aria-current="page" href="./">Home</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="timetable.html">Timetable</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="staff/">for Staff</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%--<main>--%>
<%--    <div class="container pt-5">--%>
<%--        <h1>Buy ticket</h1>--%>
<%--        <form class="mt-5" action="index.html">--%>
<%--            <input type="number" name="trainId" hidden="" value="">--%>
<%--            <input type="number" name="trainSeat" hidden="" value="">--%>

<%--            <div class="mb-3">--%>
<%--                <label for="first_name" class="form-label">First name</label>--%>
<%--                <input type="text" class="form-control" id="first_name">--%>
<%--            </div>--%>

<%--            <div class="mb-3">--%>
<%--                <label for="last_name" class="form-label">Last name</label>--%>
<%--                <input type="text" class="form-control" id="last_name">--%>
<%--            </div>--%>

<%--            <div class="mb-3">--%>
<%--                <label for="date" class="form-label">Date of birth</label>--%>
<%--                <div class="input-group mb-3">--%>
<%--                    <input type="text" class="form-control" id="date" data-mask="99-99-9999" placeholder="dd-MM-yyyy" inputmode="text">--%>
<%--                    <span class="input-group-text">--%>
<%--                        <i class="bi bi-calendar-date"></i>--%>
<%--                    </span>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <button type="submit" class="btn btn-primary">Buy ticket</button>--%>

<%--        </form>--%>
<%--    </div>--%>
<%--</main>--%>
<%--<script src="js/inputmask.js"></script>--%>
<%--<script src="js/bootstrap.bundle.min.js"></script>--%>
<%--<script src="js/scripts.js"></script>--%>

<%--</body></html>--%>

