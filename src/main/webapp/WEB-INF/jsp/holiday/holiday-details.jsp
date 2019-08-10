<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Szczegóły</title>
</head>
<body>
<div class="holidayContainer">
    <h1>Szczegóły wycieczki:</h1><br/>
    <div><c:out value="${holiday.address}"/></div>
    <div><c:out value="${holiday.place.hotel}"/></div>
    <div>${holiday.adultPrice}</div>
    <div>${holiday.childPrice}</div>
    <div>${holiday.promoted}</div>
    <div>${holiday.flightDate}</div>
    <div>${holiday.returnDate}</div>
    <div>${holiday.daysAmount}</div>
    <div>${holiday.board}</div>
    <div>${holiday.adultAmount}</div>
    <div>${holiday.childAmount}</div><br/>
    <a href="/holiday/list">Wróć</a>
</div>
</body>
</html>
