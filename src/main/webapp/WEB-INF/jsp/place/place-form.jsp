<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz miejsc</title>
</head>
<body>
<h1>Dodaj nowe miejsce</h1>
<form action="/place/createPlace" method="post">
    <label>Hotel:</label>
    <input type="text" name="hotel"/><br/>
    <label>Opis:</label>
    <textarea rows="20" cols="100" name="description"></textarea>
    <input type="submit" name="description" value="Dodaj">
</form>
</body>
</html>
