<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Miejsc</title>
</head>
<body>
<h1>Miejsca</h1>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/>
<a href="/admin">Wróć</a><br/><br/>
<c:forEach var="place" items="${places}">
    <div>
        <a href="/place/${place.id}">${place.hotel}</a>
        <a href="/place/updatePlaceForm/${place.id}">Edytuj</a>
        <a href="/place/${place.id}/placeDelete">Usuń</a>
    </div>
</c:forEach>
</body>
</html>
