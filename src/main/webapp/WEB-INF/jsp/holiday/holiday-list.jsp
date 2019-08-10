<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wycieczek</title>
</head>
<body>
<h1>Wycieczki</h1>
<%--<div>--%>
<%--    <form method="get" action="/articles">--%>
<%--        <input type="text" name="phrase" value="${param.phrase}"/>--%>
<%--        Wyszukaj tylko w tytule:--%>
<%--        <input type="checkbox" ${param.titleOnly == 'on' ? 'checked' : ''} name="titleOnly"/>--%>
<%--        <input type="submit" value="Wyszukaj"/>--%>
<%--    </form>--%>
<%--</div>--%>
<a href="/holiday/showForm">Dodaj Wycieczke</a><br/>
<a href="/admin">Wróć</a><br/><br/>
<c:forEach var="holiday" items="${holidays}">
    <div>
        <a href="/holiday/${holiday.id}">${holiday.adultPrice}</a> - ${holiday.flightDate}
        <a href="/holiday/updateForm/${holiday.id}">Edytuj</a>
        <a href="/holiday/${holiday.id}/delete">Usuń</a>
    </div>
</c:forEach>
</body>
</html>
