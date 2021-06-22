<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="${contextPath}/res/frontend/css/template.styles.css">
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="/SBB_war/">Swiss Federal Railways</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/staff/">Staff</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<main>
    <%--    <c:set var="userId" value="<%=request.getParameter(\"firstName\")%>"/>--%>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold mb-5">Booking successful</h1>
                <section>
                    <h2 class="mb-3">Your Details</h2>

                    <tr>
                        <div class="mb-3">
                            <label class="form-label" value="${ticket.user.firstName}">First
                                name: ${ticket.user.firstName}</label>
                        </div>
                    </tr>

                    <tr>
                        <div class="mb-3">
                            <label class="form-label" value="${ticket.user.lastName}">Last
                                name: ${ticket.user.lastName}</label>
                        </div>
                    </tr>

                    <%--                    <tr>--%>
                    <%--                        <div class="mb-3">--%>
                    <%--                            <label class="form-label" value="${user.birthDate}">Birth Date: ${user.birthDate}</label>--%>
                    <%--                        </div>--%>
                    <%--                    </tr>--%>


                </section>
            </div>
        </div>
    </div>


    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <section>
                    <h2 class="mb-3">Travel Details</h2>
                    <tr>
                        <div class="mb-3">
                            <label class="form-label" value="${ticket.train.number}">Train number: ${ticket.train.number}</label>
                        </div>
                    </tr>

                    <tr>
                        <div class="mb-3">
                            <label class="form-label" value="${ticket.train.trainName}">Train name ${ticket.train.trainName}</label>
                        </div>
                    </tr>

                    <tr>
                        <div class="mb-3">
                            <label class="form-label" value="${ticket.train.timetable[0].departureDateTime}">Departure: ${ticket.train.timetable[0].departureDateTime}</label>
                        </div>
                    </tr>


                </section>
            </div>
        </div>

    </div>

</main>
<script src="${contextPath}/res/frontend/js/inputmask.js"></script>
<script src="${contextPath}/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="${contextPath}/res/frontend/js/scripts.js"></script>

</body>
</html>
