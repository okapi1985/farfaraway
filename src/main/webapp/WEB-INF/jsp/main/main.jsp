<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Farfaraway</title>
</head>
<body>
<h1>Welocme to farfaraway app</h1>
<a href="/admin">Zaloguj do serwisu</a><br/>
<a href="/customer/showCustomerForm">Zarejestruj</a><br/>
<form method="get" action="/farfaraway">
    <input type="text" name="phrase" value="${param.phrase}"/>
<%--    Wyszukaj tylko w tytule:--%>
<%--    <input type="checkbox" ${param.titleOnly == 'on' ? 'checked' : ''} name="titleOnly"/>--%>
    <input type="submit" value="Wyszukaj"/>
</form>
</body>
</html>
