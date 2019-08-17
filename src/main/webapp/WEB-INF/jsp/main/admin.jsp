<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <style>
        body {
            background: url('https://castillodemonda.com/wp-content/uploads/2018/11/hotel-castillo-de-monda-1038x779.jpg');
            background-size: cover;
            background-position: center;
        }

        th {
            border: 1px solid black;
            padding: 20px;
            width: 300px;
        }

        td {
            background-color: rgba(251, 255, 44, 0.5);
            border: 1px solid black;
            padding: 20px;
            width: 100px;
        }

        table {
            border-collapse: collapse;
        }

        .admin th {
            background-color: rgba(234, 0, 255, 0.51);
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1 style="color: white">Menu:</h1>
<div class="mainContainer">
    <table class="admin">
        <colgroup span="3"></colgroup>
        <tr>
            <th colspan="3" scope="colgroup">
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
    <br/><br/>
    <form action="/logout" method="post">
        <input type="submit" value="Log me out"/>
    </form>
</body>
</html>
