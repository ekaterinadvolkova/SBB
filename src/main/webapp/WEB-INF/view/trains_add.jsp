<%--
  Created by IntelliJ IDEA.
  User: ekate
  Date: 5/2/2021
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="trainFromServer" type="com"--%>
<spring:form modelAttribute="trainFromServer" method="post" action="/SBB/train/check">
    <spring:input path="number"/>
    <spring:input path="availableSeats"/>
    <spring:input path="bookedSeats"/>
    <spring:input path="occurence"/>
    <spring:button>Add Train</spring:button>
</spring:form>
</body>
</html>
