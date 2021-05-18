<%--    <select name="occurence" id="occurence" placeholder="occurence" name="occurence">--%>
<%--        <c:forEach items="${trainDTO.occurence}" var="category">--%>
<%--            <option value="${trainDTO.occurence}">daily</option>--%>
<%--            <option value="${trainDTO.occurence}">weekly</option>--%>
<%--            <option value="${trainDTO.occurence}">monthly</option>--%>


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

<c:url value="/staff/trains/add/add" var="add"/>
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
        <h1>Add Train</h1>
        <p class="mt-5" action="staff/trains/add/add" name="train" method="POST">

        <div class="mb-3">
            <label class="form-label" value="${trainDTO.number}">Number</label>
            <input value="${trainDTO.number}" class="form-control" id="number" name="number">
        </div>

        <div class="mb-3">
            <label for="availableSeats" class="form-label">Seats</label>
            <input type="number" class="form-control" id="availableSeats" name="availableSeats">
        </div>

        <div class="mb-3">
            <label for="occurence" class="form-label">Occurrence</label>
            <div class="input-group mb-3">
                <select name="occurence" class="form-select" id="occurence">
                    <option value="DAILY">every day</option>
                    <option value="WEEKLY">every week</option>
                    <option value="MONTHLY">every month</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="departureDate" class="form-label">Departure Date</label>
                <div class="input-group mb-3">
                    <input type="text" value="${trainDTO.departureDate}" class="form-control" id="departureDate"
                           data-mask="99-99-9999" placeholder="dd-MM-yyyy" inputmode="text">
                    <span class="input-group-text"><i class="bi bi-calendar-date"></i></span>
                </div>
            </div>

        </div>

        <p>Timetable</p>
        <div id="stations-container"></div>
        <p>
            <button type="button" class="btn btn-info" id="add-station">Add station</button>
        </p>

        <template id="station-item">
            <div class="row mb-3">
                <div class="col">
                    <input type="text" placeholder="Station" class="form-control">
                </div>

                <div class="col">
                    <label class="input-group">
                        <input type="text" class="form-control" placeholder="HH-MM">
                    </label>
                </div>
            </div>
        </template>

        <p>
            <button type="submit" class="btn btn-primary">Add Train</button>
        </p>
        </form>
    </div>
</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body>
</html>

