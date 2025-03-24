<%@ page import="ru.vad1mchk.webprogr.lab02.entities.ShootRecord" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: vad1mchk
  Date: 21/10/2022
  Time: 01:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<table id="previous-results">
  <thead>
    <th>Временной штамп</th>
    <th>Координата <i>X</i></th>
    <th>Координата <i>Y</i></th>
    <th>Радиус <i>R</i></th>
    <th>Попадание</th>
    <th>Время выполнения, с</th>
  </thead>
  <tbody>
    <% LinkedList<ShootRecord> recordsList = (LinkedList<ShootRecord>) session.getAttribute("recordsList");
    if (recordsList == null || recordsList.isEmpty()) {%>
    <tr class="no-records">
      <td colspan="6">
        <p style="text-align: center"><i>Пока здесь нет записей. Сделайте выстрел, чтобы войти в историю!</i></p>
      </td>
    </tr>
  <% } else { %>
    <%for (ShootRecord current: recordsList) {%>
    <tr>
      <td class="timestamp"><%= DateTimeFormatter
              .ofPattern("d MMM yyyy H:mm:ss", new Locale("ru", "RU"))
              .format(current.timestamp()) %></td>
      <td class="x"><%= current.x() %></td>
      <td class="y"><%= current.y() %></td>
      <td class="r"><%= current.r() %></td>
      <td class="hit <%= current.hit() ? "based" : "cringe" %>"><%= current.hit() ? "база" : "кринж" %></td>
      <td class="time-elapsed"><%= current.timeElapsed() %></td>
    </tr>
  <% }} %>
  </tbody>
</table>