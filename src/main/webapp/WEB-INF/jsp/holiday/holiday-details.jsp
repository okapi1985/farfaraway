<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Szczegóły</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/style.css">
    <style>
        /*.row {*/
        /*    overflow: hidden;*/
        /*}*/

        /*.caption {*/
        /*    float: left;*/
        /*    width: 100px;*/
        /*    background-color: #ab0004;*/
        /*    color: white;*/
        /*    padding: 10px;*/
        /*    border-bottom: 1px solid #063100;*/
        /*}*/

        /*.val {*/
        /*    float: left;*/
        /*    width: 250px;*/
        /*    background-color: #e2ff53;*/
        /*    padding: 10px;*/
        /*    border-bottom: 1px solid #063100;*/
        /*}*/
    </style>
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
<sec:authorize access="hasRole('ADMIN')">
    <a href="/holiday/list">Lista wycieczek</a>
</sec:authorize>
</body>
</html>
