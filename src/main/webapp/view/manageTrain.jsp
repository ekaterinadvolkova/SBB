<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Swiss Federal Railways</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/frontend/css/template.styles.css">
</head>
<body>

<c:set var="contextPath" value="<%=request.getContextPath()%>"/>

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
        <form:form method="POST" modelAttribute="train" class="style">
            <form:input path="stationNames" type="hidden"/>

            <c:choose>
                <c:when test="${trainId == null}">
                    <p class="mt-5" action="staff/trains/add/" name="train" method="POST">
                </c:when>
                <c:otherwise>
                    <p class="mt-5" action="staff/trains/edit/${train.trainId}" name="train" method="POST">
                </c:otherwise>
            </c:choose>

            <c:if test="${train.errors != null}">
                <c:forEach var="error" items="${train.errors}">
                    <h5 color="red">${error}</h5>
                </c:forEach>
            </c:if>

            <c:choose>
                <c:when test="${trainId == null}">
                    <c:set var="trainTitle" value="Add Train"/>
                </c:when>
                <c:otherwise>
                    <c:set var="trainTitle" value="Train ${train.trainName}"/>
                </c:otherwise>
            </c:choose>

            <h3>${trainTitle}</h3>

            <div class="mb-3">
                <label class="form-label" value="${train.number}">Train Number</label>
                <fmt:formatNumber value="${train.number}" var="formattedTrainNumber"/>
                <form:input path="number" class="form-control" id="trainNumber" name="trainNumber"
                            var="${formattedTrainNumber}"/>
            </div>

            <div class="mb-3">
                <label class="form-label" value="${train.availableSeats}">Available Seats</label>
                <fmt:formatNumber value="${train.availableSeats}" var="formattedAvailableSeats"/>
                <form:input path="availableSeats" class="form-control" id="availableSeats" name="availableSeats"
                            var="${formattedAvailableSeats}"/>
            </div>

            <section class="pt-5 flex-fill container-fluid">
                <h4>Timetable</h4>

                <table class="table">
                    <thead>
                    <tr>
                        <th>Station Name</th>
                        <th>Departure Time</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="timeTableItem" items="${train.timetable}" varStatus="loop">
                        <tr>
                            <td>
                                <form:select path="timetable[${loop.index}].stationName">
                                    <form:options items="${train.stationNames}"/>
                                </form:select>
                            </td>
                            <td>
                                <form:input path="timetable[${loop.index}].departureDateTime"
                                            placeholder="yyyy-MM-dd kk:mm" value="${timeTableItem.departureDateTime}"/>
                                    <%--                                <fmt:parseDate value="${timeTableItem.departureTime}" pattern="yyyy-MM-dd KK:mm" var="localDepartureDateTime"/>--%>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${trainId == null}">
                                        <c:set var="deletePath" value="${contextPath}/staff/trains/add/${loop.index}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="deletePath" value="${contextPath}/staff/trains/edit/${trainId}/${loop.index}"/>
                                    </c:otherwise>
                                </c:choose>
                                <button type="submit" name="deleteTimetableItem" formaction="${deletePath}" class="btn btn-sm btn-outline-danger"/>
                                <i class="bi bi-trash"></i>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>

                    <tfoot>

                    <form:form method="POST" modelAttribute="train" class="style">
                        <form:button type="submit" class="btn btn-primary"
                                     name="addTimetableItem">Add Timetable Item</form:button>
                    </form:form>
                    </tfoot>
                </table>
            </section>

            <c:choose>
                <c:when test="${trainId == null}">
                    <c:set var="submitBtnName" value="Add Train"/>
                </c:when>
                <c:otherwise>
                    <c:set var="submitBtnName" value="Update Train"/>
                </c:otherwise>
            </c:choose>

            <p>
                <form:button type="submit" class="btn btn-primary" name = "addTrain">${submitBtnName}</form:button>
            </p>
        </form:form>
    </div>
</main>

<script src="<%=request.getContextPath()%>/res/frontend/js/inputmask.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/res/frontend/js/scripts.js"></script>

</body>
</html>

