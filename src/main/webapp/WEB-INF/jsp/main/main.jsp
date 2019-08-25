<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Farfaraway</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/style.css">
</head>
<body>
<div class="container">
    <div class="logo">
        <h1>Witaj w farfaraway app</h1>
        <sec:authorize access="isAuthenticated()">
        <h4>Jesteś zalogowany jako <sec:authentication property="name"/><h4/>
            </sec:authorize>
    </div>
    <div class="nav">
        <button>
            <a href="<c:url value="/logout" />">Wyloguj mnie</a>
        </button>
        <br/><br/>
        <sec:authorize access="hasRole('ADMIN')">
            <button>
                <a href="/admin">Panel administratora</a>
            </button>
        </sec:authorize>
        <br/><br/>
        <div class="browser">
            <form method="get" action="/holiday/foundWhere">
                <label>Wyszukaj po mieście:</label>
                <input type="radio" name="option" value="city"><br/>
                <label>Wyszukaj po państwie:</label>
                <input type="radio" name="option" value="country"><br/>
                <input type="text" name="phrase" value="${param.phrase}"/>
                <input type="submit" value="Wyszukaj"/>
            </form>
        </div>
        <br/><br/>
        <div class="browser">
            <form method="get" action="/holiday/found">
                <label>Cena maksymalna za dorosłego:</label>
                <input type="radio" name="option" value="adultPrice"><br/>
                <label>Cena maksymalna za dorosłego:</label>
                <input type="radio" name="option" value="childPrice"><br/>
                <input type="text" name="phrase" value="${param.amount}"/>
                <input type="submit" value="Wyszukaj"/>
            </form>
        </div>
    </div>
    <div class="content">
    </div>
    <a href="https://www.google.com/">
        <div class="ad"></div>
    </a>
    <div class="footer">Farfarawawy &copy;Wszelkie prawa zastrzeżone</div>
</div>
</body>
</html>
