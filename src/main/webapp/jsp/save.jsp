<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Save drivers</title>
</head>
<body>
<h1>Add ${countForJsp} drivers</h1>
<form action="/save" method="post">
    <c:forEach begin="1" end="${countForJsp}" var="i">
        <div>
            <span>Driver ${i}:</span>
            <input name="firstName" placeholder="firstname" required maxlength="20">
            <input name="lastName" placeholder="lastname" required maxlength="20">
            <input name="age" type="number" placeholder="age">
            <input name="city" placeholder="city">
            <input name="gender" placeholder="gender">
            <input name="experience" type="number" placeholder="experience">
        </div>
    </c:forEach>
    <input type="submit" value="Save">
</form>
</body>
</html>
