<%@ page import="java.util.LinkedList" %>
<%@ page import="ru.vad1mchk.webprogr.lab02.entities.ShootRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=utf-8" language="java"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Результат | Лабораторная работа №2 по дисциплине &laquo;Веб-программирование&raquo;</title>
    <link href="${pageContext.request.contextPath}/css/vad1mchk.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon">
</head>
<body>
<%
    ShootRecord current = (ShootRecord) session.getAttribute("current");
%>
    <div class="black-box">
        <form action="index.jsp">
            <input type="submit" value="Домой" id="go-home">
        </form>
        <h1>TL;DR: точка <% if (current.hit()) {%>
            <i>попадает</i> в область (<span class="based">база</span>)
            <% } else { %>
            <i>не попадает</i> в область (<span class="cringe">кринж</span>)
            <% } %>
        </h1>
        <table id="previous-results">
            <thead>
            <tr>
                <th>Временной штамп</th>
                <th>Координата <i>X</i></th>
                <th>Координата <i>Y</i></th>
                <th>Радиус <i>R</i></th>
                <th>Попадание</th>
                <th>Время выполнения, с</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%= DateTimeFormatter
                        .ofPattern("d MMM yyyy H:mm:ss", new Locale("ru", "RU"))
                        .format(current.timestamp()) %></td>
                <td><%= current.x() %></td>
                <td><%= current.y() %></td>
                <td><%= current.r() %></td>
                <td class="hit <%= current.hit() ? "based" : "cringe" %>"><%= current.hit() ? "база" : "кринж" %></td>
                <td><%= current.timeElapsed() %></td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
