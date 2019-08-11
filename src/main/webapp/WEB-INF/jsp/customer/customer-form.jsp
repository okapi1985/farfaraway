<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz rejestracji</title>
</head>
<body>
<h2>Rejestracja użytkownika</h2>
<form:form action="/customer/createCustomer" method="post" modelAttribute="customer" enctype="multipart/form-data"
           role="form">
    <c:if test="${customer.id != null}">
        <form:input path="id" type="hidden" name="id" value="${customer.id}"/>
    </c:if>
    <label>Imię:</label>
    <form:input path="firstName" type="text" name="firstName"/><br/>
    <label>Nazwisko:</label>
    <form:input path="lastName" type="text" name="lastName"/><br/>
    <label>Data urodzenia:</label>
    <form:input path="dob" type="date" name="dob"/><br/>
    <label>E-mail:</label>
    <form:input path="email" type="email" name="email"/><br/>
    <label>Hasło:</label>
    <form:input path="password" type="password" name="password"/><br/>

    <input type="submit" value="Zapisz">
</form:form>
</body>
</html>
