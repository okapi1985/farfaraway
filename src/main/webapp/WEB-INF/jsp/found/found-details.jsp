<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/style.css">
</head>
<body>
<div class="row">
    <div class="caption">Wycieczka:</div>
    <div class="val">${holiday.address}</div>
</div>
<div class="row">
    <div class="caption">Hotel:</div>
    <div class="val">${holiday.place.hotel}</div>
</div>
<div class="row">
    <div class="caption">Cena za dorosłego:</div>
    <div class="val">${holiday.adultPrice}</div>
</div>
<div class="row">
    <div class="caption">Cena za dziecko:</div>
    <div class="val">${holiday.childPrice}</div>
</div>
<div class="row">
    <div class="caption">Promowanie:</div>
    <div class="val">${holiday.promoted}</div>
</div>
<div class="row">
    <div class="caption">Data wylotu:</div>
    <div class="val">${holiday.flightDate}</div>
</div>
<div class="row">
    <div class="caption">Data powrotu:</div>
    <div class="val">${holiday.returnDate}</div>
</div>
<div class="row">
    <div class="caption">Ilość dni:</div>
    <div class="val">${holiday.daysAmount}</div>
</div>
<div class="row">
    <div class="caption">Wyżywienie:</div>
    <div class="val">${holiday.board}</div>
</div>
<div class="row">
    <div class="caption">Maksymalna liczba dorosłych:</div>
    <div class="val">${holiday.adultAmount}</div>
</div>
<div class="row">
    <div class="caption">Maksymalna liczba dzieci:</div>
    <div class="val">${holiday.childAmount}</div>
</div>

<a href="/purchase/purchase-form">Kup wycieczkę</a><br/><br/>
</body>
</html>
