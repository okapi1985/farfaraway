<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz miejsc</title>
</head>
<body>
<h1>Menu:</h1>
<a href="/holiday/showForm">Dodaj Wycieczkę</a>
<a href="/address/showAddressForm">Dodaj Adres</a>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>
<a href="/place/placeList">Lista Miejsc</a><br/><br/>
<a href="/admin">Wróć</a><br/>
<h2>Dodaj nowe miejsce</h2>
<form action="/place/createPlace" method="post">
    <label>Hotel:</label>
    <input type="text" name="hotel"/><br/>
    <label>Opis:</label>
    <textarea rows="20" cols="100" name="description"></textarea>
    <input type="submit" name="description" value="Dodaj">
</form>
</body>
</html>
