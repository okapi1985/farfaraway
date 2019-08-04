<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz wycieczek</title>
</head>
<body>
<h1>Dodaj nową wycieczkę</h1>
<form:form method="post" action="/holiday/createHoliday" modelAttribute="holiday" enctype="multipart/form-data" role="form">
    <label>Cena za dorosłego:</label>
    <form:input  path="adultPrice" type="number" name="adultPrice"/><br/>
    <label>Cena za dziecko:</label>
    <form:input type="number" name="childPrice" path="childPrice"/><br/>
    <label>Promowanie:</label>
    <form:checkbox value="true" name="promoted" path="promoted"/><br/>
    <label>Data wylotu:</label>
    <form:input type="date" name="flightDate" path="flightDate"/><br/>
    <label>Data powrotu:</label>
    <form:input type="date" name="returnDate" path="returnDate"/><br/>
    <label>Ilość dni:</label>
    <form:input type="number" name="daysAmount" path="daysAmount"/><br/>
    <label>Wyżywienie:</label><br/>
    <label>HB:</label><input type="radio" name="board" value="HB"}/>
    <label>BB:</label><input type="radio" name="board" value="BB"/>
    <label>FB:</label><input type="radio" name="board" value="FB"/>
    <label>AI:</label><input type="radio" name="board" value="AI"/><br/>
    <label>Liczba dorosłych:</label>
    <form:input type="number" name="adultAmount" path="adultAmount"/><br/>
    <label>Liczba dzieci:</label>
    <form:input type="number" name="childAmount" path="childAmount"/><br/>

    <input type="submit" name="submit" value="Dodaj"/>
</form:form>
</body>
</html>
