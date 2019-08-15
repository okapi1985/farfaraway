<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wycieczek</title>
    <style>
        th {
            border: 1px solid black;
            padding: 20px;
        }

        td {
            background-color: #626360;
            border: 1px solid black;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
        }

        .holidayList th {
            background-color: #ff1a10;
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1>Wycieczki</h1>
<a href="/holiday/showForm">Dodaj Wycieczke</a><br/>
<a href="/admin">Wróć</a><br/><br/>
<div class="mainContainer">
    <c:if test="${holidays.size() > 0}">
        <table class="holidayList">
            <tr>
                <th>
                    Wycieczka
                </th>
                <th>
                    Hotel
                </th>
                <th>
                    Ilość dni
                </th>
                <th>
                    Działania
                </th>
            </tr>
            <c:forEach items="${holidays}" var="holiday">
                <tr>
                    <td>${holiday.address}</td>
                    <td>${holiday.place.hotel}</td>
                    <td>${holiday.daysAmount}</td>
                    <td>
                        <a href="/holiday/${holiday.id}">Szczegóły</a>
                        <a href="/holiday/updateForm/${holiday.id}">Edytuj</a>
                        <a href="/holiday/${holiday.id}/delete">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
