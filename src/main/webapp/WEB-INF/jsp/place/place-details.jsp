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
            background-color: #5dda15;
            color: white;
            padding: 10px;
            border-bottom: 1px solid #000ea5;
        }

        .val {
            float: left;
            width: 400px;
            background-color: #ffc63e;
            padding: 10px;
            border-bottom: 1px solid #000ea5;
        }
    </style>
</head>
<body>
<div class="placeContainer">
    <div class="row">
        <div class="caption">Hotel:</div>
        <div class="val">${place.hotel}</div>
    </div>
    <div class="row">
        <div class="caption">Opis:</div>
        <div class="val">${place.description}</div>
    </div>

    <a href="/place/placeList">Lista miejsc</a>
</div>
</body>
</html>
