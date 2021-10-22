<%@page import="model.CategoryModel"%>
<%@page import="logic.CategoriesLogic"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/jspf/Header.jspf" %>
<h1>Добавить дефект</h1>
<% 
    ArrayList<CategoryModel> categoriesList = CategoriesLogic.getCategoriesList(); 
%>
<% if (categoriesList.size() == 0) { %>
    <span>Нет категорий. Пожауйста добавьте хотя бы одну категорию на соответствующей странице.</span> <br/>
<% } else { %>
<form action="/v22/defects" method="POST" accept-charset="UTF-8">
    <input type="hidden" name="action" value="create">
    <label>Заголовок</label> <br/>
    <input type="text" name="title""/> <br/><br/>
    <label>Описание</label> <br/>
    <textarea name="description"></textarea> <br/><br/>
    <label>Важность</label> <br/>
    <select name="severity">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
    </select> <br/><br/>
    <label>Категория</label> <br/>
    <select name="category_id">
    <% for(CategoryModel category : categoriesList) { %>
        <option value="<%= category.getId() %>"><%= category.getName() %></option>
    <% } %>
    </select> <br/><br/>
    <label>Закрыт?</label>    
    <input type="checkbox" name="closed" /> <br/> <br/>
<input type="submit" value="Добавить" />
</form>
<% } %>
<%@include file="/jspf/Footer.jspf" %>
