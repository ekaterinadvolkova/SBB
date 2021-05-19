<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a class="nav-link" href="timetable/">Timetable</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <div class="d-flex flex-row-reverse">
        <section class="pt-5 flex-fill container-fluid">
            <h2>Trains</h2>

            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Train Number</th>
                    <th>Booked Seats</th>
                    <th>Occurrence</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="train" items="${trainList}">

                    <tr>
                        <td>${train.trainID}</td>
                        <td>${train.number}</td>
                        <td>${train.availableSeats}</td>
<%--                        <td>${train.occurence}</td>--%>
                        <td>
                            <div class="btn-group">
                                <a href="/staff/trains/" type="button" class="btn btn-sm btn-outline-secondary" title="View trains">
                                    <i class="bi bi-people-fill"></i>
                                </a>
                                <a href="staff/train/edit/${train.trainID}" type="button"
                                   class="btn btn-sm btn-outline-secondary" title="Edit">
                                    <i class="bi bi-pencil"></i>
                                </a>
                                <a href="staff/train/delete/${train.trainID}" type="button"
                                   class="btn btn-sm btn-outline-danger" title="Delete">
                                    <i class="bi bi-trash"></i>
                                </a>


                            </div>
                        </td>
                    </tr>
                </c:forEach>


                </tbody>

                <tfoot>
                <tr>
                    <td colspan="5">
                        <a href="staff/trains/add" class="btn btn-outline-primary">Add Train</a>
                    </td>
                </tr>
                </tfoot>
            </table>
        </section>

        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px;">
            <a href="staff/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <span class="fs-4">Staff page</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">

                <li>
                    <a href="staff/" class="nav-link">
                        View stations
                    </a>
                </li>

                <li class="nav-item">
                    <a href="staff/trains/" class="nav-link active">
                        View trains
                    </a>
                </li>

                <li class="nav-item">
                    <a href="staff/passengers/" action="staff/stations/add" name="station" method="POST" class="nav-link">
                        View passengers
                    </a>
                </li>

            </ul>
        </div>
    </div>
</main>
<script src="./res/frontend/js/inputmask.js"></script>
<script src="./res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="./res/frontend/js/scripts.js"></script>

</body>
</html>

