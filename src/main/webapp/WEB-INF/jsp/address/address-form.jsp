<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz adresów</title>
</head>
<body>
<h1>Menu:</h1>
<a href="/holiday/showForm">Dodaj Wycieczkę</a>
<a href="/address/showAddressForm">Dodaj Adres</a>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>
<a href="/address/addressList">Lista adresów</a><br/><br/>
<a href="/admin">Wróć</a><br/>
<h2>Dodaj nowy adres:</h2>
<form action="/address/createAddress" method="post">
    <label>Kontynent:</label>
    <label>AFRICA:</label><input type="radio" name="continent" value="AFRICA"/>
    <label>ASIA:</label><input type="radio" name="continent" value="ASIA"/>
    <label>AUSTRALIA:</label><input type="radio" name="continent" value="AUSTRALIA"/>
    <label>EUROPE:</label><input type="radio" name="continent" value="EUROPE"/>
    <label>NORTH_AMERICA:</label><input type="radio" name="continent" value="NORTH_AMERICA"/>
    <label>SOUTH_AMERICA:</label><input type="radio" name="continent" value="SOUTH_AMERICA"/><br/>
    <label>Kraj:</label>
    <input type="text" name="country"/><br/>
    <label>Miasto</label>
    <input type="text" name="city"/><br/>
    <label>Lotnisko:</label>
    <input type="text" name="airport"/><br/>
    <input type="submit" name="submit" value="Dodaj">
</form>
</body>
</html>
