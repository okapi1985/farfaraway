<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły</title>
</head>
<body>
<div class="articleContainer">
    <h1>Szczegóły adresu:</h1><br/>
    <div>${address.continent}</div>
    <div>${address.country}</div>
    <div>${address.city}</div>
    <div>${address.airport}</div><br/>
    <a href="/address/addressList">Wróć</a>
</div>
</body>
</html>
