<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz adresów</title>
</head>
<body>
<h1>Dodaj nowy adres:</h1>
<form action="/address/createAddress" method="post">
    <label>Kontynent:</label>
    <input type="text" name="continent"/><br/>
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
