<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Farfaraway</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/style.css">
</head>
<body>
<div id="container">
    <div id="logo">
        <h1>Witaj w farfaraway app</h1>
    </div>
    <div id="nav">
        <button>
            <a href="/admin">Zaloguj do serwisu</a>
        </button>
        <br/><br/>
        <button>
            <a href="/customer/showCustomerForm">Zarejestruj</a>
        </button>
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
    <div id="content">
    </div>
    <a href="https://www.google.com/">
        <div id="ad"></div>
    </a>
    <div id="footer">Farfarawawy &copy;Wszelkie prawa zastrzeżone</div>
</div>
</body>
</html>
