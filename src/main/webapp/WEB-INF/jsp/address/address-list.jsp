<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista adresów</title>
</head>
<body>
<h1>Adresy</h1>
<a href="/address/showAddressForm">Dodaj Adres</a><br/>
<c:forEach var="address" items="${addresses}">
    <div>
        <a href="/address/${address.id}">${address.city}</a> - ${address.country}
    </div>
</c:forEach>
</body>
</html>
