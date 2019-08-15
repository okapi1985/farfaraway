<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <style>
        th {
            border: 1px solid black;
            padding: 20px;
        }

        td {
            background-color: white;
            border: 1px solid black;
            padding: 20px;
            width: 100px;
        }

        table {
            border-collapse: collapse;
        }

        .admin th {
            background-color: #ff1a10;
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1>Menu:</h1>
<div class="mainContainer">
    <table class="admin">
        <tr>
            <th>
                Panel administratora
            </th>
        </tr>
        <tr>
            <td><a href="/holiday/showForm">Dodaj Wycieczkę</a><br/><br/><a href="/holiday/list">Lista wycieczek</a></td>
            <td><a href="/address/showAddressForm">Dodaj Adres</a><br/><br/><a href="/address/addressList">Lista adresów</a></td>
            <td><a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/><a href="/place/placeList">Lista miejsc</a></td>
        </tr>
    </table>
    <div/>
    <%--<h2>Admin panel:</h2>--%>
    <%--<a href="/holiday/showForm">Dodaj Wycieczkę</a>--%>
    <%--<a href="/address/showAddressForm">Dodaj Adres</a>--%>
    <%--<a href="/place/showPlaceForm">Dodaj Miejsce</a><br/><br/>--%>
    <%--<a href="/holiday/list">Lista wycieczek</a>--%>
    <%--<a href="/address/addressList">Lista adresów</a>--%>
    <%--<a href="/place/placeList">Lista miejsc</a><br/>--%>
    <br/><br/>
    <form action="/logout" method="post">
        <input type="submit" value="Log me out"/>
    </form>
</body>
</html>
