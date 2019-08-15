<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista adresów</title>
    <style>
        th {
            border: 1px solid black;
            padding: 20px;
        }

        td {
            background-color: #4a4eff;
            border: 1px solid black;
            padding: 20px;
        }

        table {
            border-collapse: collapse;
        }

        .addressList th {
            background-color: #8b0081;
            color: #fff;
        }

        .mainContainer {
            width: 80%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h1>Adresy</h1>
<a href="/address/showAddressForm">Dodaj Adres</a><br/>
<a href="/admin">Wróć</a><br/><br/>
<div class="mainContainer">
    <c:if test="${addresses.size() > 0}">
        <table class="addressList">
            <tr>
                <th>
                    Continent
                </th>
                <th>
                    Country
                </th>
                <th>
                    Actions
                </th>
            </tr>
            <c:forEach items="${addresses}" var="address">
                <tr>
                    <td>${address.continent}</td>
                    <td>${address.country}</td>
                    <td>
                        <a href="/address/${address.id}">Szczegóły</a>
                        <a href="/address/updateAddressForm/${address.id}">Edytuj</a>
                        <a href="/address/${address.id}/deleteAddress">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
