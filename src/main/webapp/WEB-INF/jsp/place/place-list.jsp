<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Miejsc</title>
    <style>
        th {
            border: 1px solid black;
            padding: 20px;
        }

        td {
            background-color: yellow;
            border: 1px solid black;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
        }

        .placeList th {
            background-color: forestgreen;
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1>Miejsca</h1>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/>
<a href="/admin">Wróć</a><br/><br/>
<div class="mainContainer">
    <c:if test="${places.size() > 0}">
        <table class="placeList">
            <tr>
                <th>
                    Hotel
                </th>
                <th>
                    Działania
                </th>
            </tr>
            <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.hotel}</td>
                    <td>
                        <a href="/place/${place.id}">Szczegóły</a>
                        <a href="/place/updatePlaceForm/${place.id}">Edytuj</a>
                        <a href="/place/${place.id}/deletePlace">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
