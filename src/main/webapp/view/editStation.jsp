<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<c:url value="/staff/stations/edit" var="edit"/>
<c:set value="POST" var="POST"/>

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
                    <a class="nav-link" href="./">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <div class="container pt-5">

        <form class="style" action="${(empty station.stationID) ? add : edit}" name="station" method="POST">
            <c:choose>
            <c:when test="${!empty station.stationID}">
            <h1>Edit Station</h1>
            <p class="mt-5" action="staff/stations/add/" name="train" method="POST">
            <p><input type="hidden" name="stationID" id="stationID" value="${station.stationID}">
                <input style="display: none" type="text" name="stationID" value="${station.stationID}">
                </c:when>
                <c:otherwise>
            <h1>Add Station</h1>
            <p class="mt-5" action="staff/stations/add/" name="train" method="POST">
                </c:otherwise>
                </c:choose>

            <div class="mb-3">
                <label class="form-label" value="${station.name}">Station Name</label>
                <input value="${station.name}" class="form-control" id="name" name="name">
            </div>

            <p>
                <button type="submit" class="btn btn-primary">Add Station</button>
            </p>
        </form>
    </div>
</main>


<script src="<%=request.getContextPath()%>/res/frontend/js/inputmask.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/scripts.js"></script>

</body>
</html>
