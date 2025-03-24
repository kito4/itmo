<%@ page contentType="text/html;charset=utf-8" language="java"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №2 по дисциплине &laquo;Веб-программирование&raquo;</title>
    <link href="${pageContext.request.contextPath}/css/vad1mchk.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/favicon.ico" rel="icon">
</head>
<body>
    <%@ include file="/html/header.html" %>
    <div class="black-box">
        <h1>Форма для ввода данных</h1>
        <form name="dotForm" method="POST" action="${pageContext.request.contextPath}/control">
            <canvas class="screen" id="plot" height="384px" width="384px">
                Окей, бумер. Ваш браузер не поддерживает элемент <code>&lt;canvas&gt;</code>.
            </canvas>
            <br>
            <label class="necessary">Координата <i>X</i>:
                <select name="x" required>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </label>
            <br>
            <label class="necessary">Координата <i>Y</i>:
                <input required type="text" name="y" placeholder="Число в диапазоне (-3..5)" maxlength="100"><br>
            </label>
            <label class="necessary">Радиус <i>R</i>:
                <input type="checkbox" name="r" value="1">1
                <input type="checkbox" name="r" value="2">2
                <input type="checkbox" name="r" value="3">3
                <input type="checkbox" name="r" value="4">4
                <input type="checkbox" name="r" value="5" checked>5
            </label>
            <br>
            <input type="hidden" name="strict" value="true">
            <%-- Строгий режим проверки только при отправке через форму--%>
            <input type="submit" onclick="return validate();" value="Рассчитать">
            <input type="reset" value="Сбросить">
        </form>
    </div>
    <div class="black-box">
        <h1>Предыдущие результаты</h1>
        <%@ include file="table.jsp"%>
    </div>
    <div class="black-box">
        <h1>Задание</h1>
        <p>Разработать веб-приложение на базе сервлетов и JSP, определяющее попадание точки на координатной плоскости в заданную область.</p>

        <p>Приложение должно быть реализовано в соответствии с <a href="https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">шаблоном MVC</a> и состоять из следующих элементов:</p>

        <ul>
            <li><b>ControllerServlet</b>, определяющий тип запроса, и, в зависимости от того, содержит ли запрос информацию о координатах точки и радиусе, делегирующий его обработку одному из перечисленных ниже компонентов. Все запросы внутри приложения должны передаваться этому сервлету (по методу GET или POST в зависимости от варианта задания), остальные сервлеты с веб-страниц напрямую вызываться не должны.</li>
            <li><b>AreaCheckServlet</b>, осуществляющий проверку попадания точки в область на координатной плоскости и формирующий HTML-страницу с результатами проверки. Должен обрабатывать все запросы, содержащие сведения о координатах точки и радиусе области.</li>
            <li><b>Страница JSP</b>, формирующая HTML-страницу с веб-формой. Должна обрабатывать все запросы, не содержащие сведений о координатах точки и радиусе области.</li>
        </ul>
        <p><b>Разработанная страница JSP должна содержать:</b></p>
        <ol>
            <li>"Шапку", содержащую ФИО студента, номер группы и номер варианта.</li>
            <li>Форму, отправляющую данные на сервер.</li>
            <li>Набор полей для задания координат точки и радиуса области в соответствии с вариантом задания.</li>
            <li>Сценарий на языке JavaScript, осуществляющий валидацию значений, вводимых пользователем в поля формы.</li>
            <li>Интерактивный элемент, содержащий изображение области на координатной плоскости (в соответствии с вариантом задания) и реализующий следующую функциональность:
                <ul>
                    <li>Если радиус области установлен, клик курсором мыши по изображению должен обрабатываться JavaScript-функцией, определяющей координаты точки, по которой кликнул пользователь и отправляющей полученные координаты на сервер для проверки факта попадания.</li>
                    <li>В противном случае, после клика по картинке должно выводиться сообщение о невозможности определения координат точки.</li>
                    <li>После проверки факта попадания точки в область изображение должно быть обновлено с учётом результатов этой проверки (т.е., на нём должна появиться новая точка).</li>
                </ul>
            </li>
            <li>Таблицу с результатами предыдущих проверок. Список результатов должен браться из контекста приложения, HTTP-сессии или Bean-компонента в зависимости от варианта.</li>
        </ol>
        <p><b>Страница, возвращаемая AreaCheckServlet, должна содержать:</b></p>
        <ol>
            <li>Таблицу, содержащую полученные параметры.</li>
            <li>Результат вычислений - факт попадания или непопадания точки в область.</li>
            <li>Ссылку на страницу с веб-формой для формирования нового запроса.</li>
        </ol>
        <p>Разработанное веб-приложение необходимо развернуть на сервере <a href="https://wildfly.org/">WildFly</a>. Сервер должен быть запущен в standalone-конфигурации, порты должны быть настроены в соответствии с выданным portbase, доступ к http listener'у должен быть открыт для всех IP.</p>
    </div>
    <%@ include file="/html/footer.html" %>
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/value-of-r.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/canvas.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/validate.js"></script>
</body>
</html>
