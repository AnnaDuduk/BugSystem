<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/jspf/Header.jspf" %>
<h1>Добавить категорию</h1>
<form action="/v22/categories" method="POST" accept-charset="UTF-8">
    <input type="hidden" name="action" value="create">
    <label>Название</label><br/>
    <input type="text" name="name"/> <br/><br/>
    <input type="submit" value="Добавить" />
</form>
<%@include file="/jspf/Footer.jspf" %>
