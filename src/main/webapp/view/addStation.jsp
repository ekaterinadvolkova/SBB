<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="../../">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="./res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="./res/frontend/css/template.styles.css">
</head>
<body>
<c:url value="/staff/stations/add" var="add"/>
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
                    <a class="nav-link" href="staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main>
    <div class="container pt-5">
        <h1>Add Station</h1>
        <p class="mt-5" action="staff/stations/add" name="station" method="POST">

        <div class="mb-3">
            <label class="form-label" value="${Station.name}">Station Name</label>
            <input value="${station.name}" class="form-control" id="name" name="name">
        </div>
    </div>
</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>
</body>
</html>
