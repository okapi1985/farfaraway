<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wycieczek</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/style.css">
    <style>
        /*.head {*/
        /*    border: 1px solid black;*/
        /*    padding: 20px;*/
        /*}*/

        /*.field {*/
        /*    background-color: #626360;*/
        /*    border: 1px solid black;*/
        /*    padding: 20px;*/
        /*}*/

        /*.holidayList {*/
        /*    border-collapse: collapse;*/
        /*    background-color: #ff1a10;*/
        /*    color: #fff;*/
        /*}*/

        /*.mainContainer {*/
        /*    width: 80%;*/
        /*    margin: 0 auto;*/
        /*}*/
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
                <th class="head">
                    Wycieczka
                </th>
                <th class="head">
                    Hotel
                </th>
                <th class="head">
                    Ilość dni
                </th>
                <th class="head">
                    Działania
                </th>
            </tr>
            <c:forEach items="${holidays}" var="holiday">
                <tr>
                    <td class="field">${holiday.address}</td>
                    <td class="field">${holiday.place.hotel}</td>
                    <td class="field">${holiday.daysAmount}</td>
                    <td class="field">
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
