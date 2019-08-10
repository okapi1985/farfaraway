<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Menu:</h1>
<h2>Admin panel:</h2>
<a href="/holiday/showForm">Dodaj Wycieczkę</a>
<a href="/address/showAddressForm">Dodaj Adres</a>
<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>
<a href="/holiday/list">Lista wycieczek</a>
<a href="/address/addressList">Lista adresów</a>
<a href="/place/placeList">Lista miejsc</a><br/>
<br/><br/>
<form action="/logout" method="post">
    <input type="submit" value="Log me out"/>
</form>
</body>
</html>
