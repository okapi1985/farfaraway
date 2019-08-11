<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz miejsc</title>
</head>
<body>
<h1>Menu:</h1>
<a href="/holiday/showForm">Dodaj Wycieczkę</a>
<a href="/address/showAddressForm">Dodaj Adres</a>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>
<a href="/place/placeList">Lista Miejsc</a><br/><br/>
<a href="/admin">Wróć</a><br/>
<h2>Dodaj nowy hotel:</h2>
<form:form action="/place/createPlace" method="post" modelAttribute="place" enctype="multipart/form-data"
           role="form">
    <c:if test="${place.id != null}">
        <form:input path="id" type="hidden" name="id" value="${place.id}"/>
    </c:if>
    <label>Hotel:</label>
    <form:input path="hotel" type="text" name="hotel"/><br/>
    <label>Opis:</label>
    <form:textarea path="description" rows="10" cols="50" name="description"/>
    <input type="submit" value="Zapisz">
</form:form>
</body>
</html>
