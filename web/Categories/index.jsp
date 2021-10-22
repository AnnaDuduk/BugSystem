<%@page import="java.util.ArrayList"%>
<%@page import="model.CategoryModel"%>
<%@page import="logic.CategoriesLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/jspf/Header.jspf" %>
<h1>Список категорий</h1>
<% ArrayList<CategoryModel> list = CategoriesLogic.getCategoriesList(); %>
<% if (list.size() == 0) { %>
    <p>Нет категорий.</p>
<% } else { %>
    <table border="1">
        <tr>
            <th>Название</th>
            <th>&nbsp;</th>
        </tr>
    <% for(CategoryModel category : list) { %>
        <tr>
            <td><%= category.getName() %></td>
            <td>
                <a href="/v22/categories?action=delete&id=<%= category.getId() %>">Удалить</a>
            </td>
            
        </tr>
    <% } %>
    </table>
<% } %>
<p><a href="/v22/categories?action=new">Добавить категорию</a></p>
<%@include file="/jspf/Footer.jspf" %>