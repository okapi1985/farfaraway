<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły</title>
    <style>
        .row {
            overflow: hidden;
        }

        .caption {
            float: left;
            width: 100px;
            background-color: orchid;
            color: white;
            padding: 10px;
            border-bottom: 1px solid brown;
        }

        .val {
            float: left;
            width: 250px;
            background-color: aqua;
            padding: 10px;
            border-bottom: 1px solid brown;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="caption">Kontynent:</div>
    <div class="val">${address.continent}</div>
</div>
<div class="row">
    <div class="caption">Kraj:</div>
    <div class="val">${address.country}</div>
</div>
<div class="row">
    <div class="caption">Miasto:</div>
    <div class="val">${address.city}</div>
</div>
<div class="row">
    <div class="caption">Lotnisko:</div>
    <div class="val">${address.airport}</div>
</div>

<a href="/address/addressList">Lista adresów</a>
</body>
</html>
