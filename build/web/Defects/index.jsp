<%@page import="java.util.ArrayList"%>
<%@page import="model.DefectModel"%>
<%@page import="logic.DefectsLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/jspf/Header.jspf" %>
<h1>Список дефектов</h1>
<% ArrayList<DefectModel> list = DefectsLogic.getDefectsList(); %>
<% if (list.size() == 0) { %>
    <p>Нет дефектов.</p>
<% } else { %>
    <table border="1">
        <tr>
            <th>Заголовок</th>
            <th>Описание</th>
            <th>Важность</th>
            <th>Категория</th>
            <th>Закрыт?</th>
            <th>&nbsp;</th>
        </tr>
    <% for(DefectModel defect : list) { %>
        <tr>
            <td><%= defect.getTitle() %></td>
            <td><pre><%= defect.getDescription() %></pre></td>
            <td>
                <% int severity = defect.getSeverity(); %>
                <%= severity %>
                <% if (severity < 5) { %>
                    <a href="/v22/defects?action=raiseSeverity&id=<%= defect.getId() %>">&uarr;</a>
                <% } %>
                <% if (severity > 1) { %>
                    <a href="/v22/defects?action=lowerSeverity&id=<%= defect.getId() %>">&darr;</a>
                <% } %>
            </td>
            <td><%= DefectsLogic.getCategoryName(defect) %></td>
            <td><%= defect.getClosed() ? "Да" : "Нет" %></td>
            <td>
                <a href="/v22/defects?action=delete&id=<%= defect.getId() %>">Удалить</a>
                <% if (!defect.getClosed()) { %>
                    | <a href="/v22/defects?action=close&id=<%= defect.getId() %>">Закрыть</a>
                <% } else { %>
                    | <a href="/v22/defects?action=reopen&id=<%= defect.getId() %>">Переоткрыть</a>
                <% } %>

            </td>
            
        </tr>
    <% } %>
    </table>
<% } %>
<p><a href="/v22/defects?action=new">Добавить дефект</a></p>
<%@include file="/jspf/Footer.jspf" %>