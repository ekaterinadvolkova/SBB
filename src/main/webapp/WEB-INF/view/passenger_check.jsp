<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ekate
  Date: 4/30/2021
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--@elvariable id="passengerFromServer" type="com"--%>
    <spring:form modelAttribute="passengerFromServer" method="post" action="/SBB/passenger/check">
        <spring:input path="First Name"/>
        <spring:input path="Last Name"/>
        /*add birth date*/
        <spring:button>Check passenger</spring:button>
    </spring:form>


</body>
</html>
