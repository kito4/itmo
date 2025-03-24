<%--
  Created by IntelliJ IDEA.
  User: vad1mchk
  Date: 21/10/2022
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>Ошибка | Лабораторная работа №2 по дисциплине &laquo;Веб-программирование&raquo;</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/vad1mchk.css">
</head>
<body>
    <div class="black-box">
        <form action="index.jsp">
            <input type="submit" value="Домой" id="go-home">
        </form>
        <img src="images/warning-sign.svg">
        <h1>Ошибка при обработке запроса</h1>
        <p class="error"><%= request.getAttribute("errorMessage") %></p>
    </div>
</body>
</html>
