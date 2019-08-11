<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Formularz wycieczek</title>
</head>
<body>
<h1>Menu:</h1>
<a href="/holiday/showForm">Dodaj Wycieczkę</a>
<a href="/address/showAddressForm">Dodaj Adres</a>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>
<a href="/holiday/list">Lista wycieczek</a><br/><br/>
<a href="/admin">Wróć</a><br/>
<h2>Dodaj nową wycieczkę</h2>
<form:form method="post" action="/holiday/createHoliday" modelAttribute="holiday" enctype="multipart/form-data"
           role="form">
    <label>Miejsce:</label>
    <form:select id="address" name="address" path="address">
        <c:forEach items="${addresses}" var="address">
            <form:option value="${address.id}" label="${address.country}, ${address.city}, ${address.airport}" />
        </c:forEach>
    </form:select><br/><br/>
    <label>Hotel:</label>
    <form:select id="place" name="place" path="place">
        <c:forEach items="${places}" var="place">
            <form:option value="${place.id}" label="${place.hotel}" />
        </c:forEach>
    </form:select><br/><br/>
    <c:if test="${holiday.id != null}">
        <form:input path="id" type="hidden" name="id" value="${holiday.id}"/>
    </c:if>
    <label>Cena za dorosłego:</label>
    <form:input path="adultPrice" type="number" name="adultPrice"/><br/><br/>
    <label>Cena za dziecko:</label>
    <form:input type="number" name="childPrice" path="childPrice"/><br/><br/>
    <label>Promowanie:</label>
    <form:checkbox value="true" name="promoted" path="promoted"/><br/><br/>
    <label>Data wylotu:</label>
    <form:input type="date" name="flightDate" path="flightDate"/><br/><br/>
    <label>Data powrotu:</label>
    <form:input type="date" name="returnDate" path="returnDate"/><br/><br/>
    <label>Ilość dni:</label>
    <form:input type="number" name="daysAmount" path="daysAmount"/><br/><br/>
    <label>Wyżywienie:</label><br/>
    <label>HB:</label><input type="radio" name="board" value="HB"/>
    <label>BB:</label><input type="radio" name="board" value="BB"/>
    <label>FB:</label><input type="radio" name="board" value="FB"/>
    <label>AI:</label><input type="radio" name="board" value="AI"/><br/><br/>
    <label>Liczba dorosłych:</label>
    <form:input type="number" name="adultAmount" path="adultAmount"/><br/><br/>
    <label>Liczba dzieci:</label>
    <form:input type="number" name="childAmount" path="childAmount"/><br/><br/>

    <input type="submit" value="Zapisz"/>
</form:form>
</body>
</html>
