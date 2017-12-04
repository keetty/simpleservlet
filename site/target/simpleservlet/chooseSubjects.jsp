<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, src.database.*, src.dto.*, src.service.*, scr.dao.*"%>
  
  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  </head>
	  <body>
<center>
<table border="1" width="1024" height="960">
<tr>
<td width="30%" height="10%">
<H3>
<center>Меню</center>
</H3>
</td>
<td>
<H3>
<center>Выберите предметы из списка ниже и нажмите кнопку "Добавить"</center>
</H3>
</td>
</tr>
<tr>
<td valign="top">
<table border="1">
<tr>
<td>
<H3>
<a href="<%=response.encodeUrl("/simpleservlet/Students")%>">Вернуться к списку студентов</a>
</H3>
</td>
</tr>
</table>
</td> 
<td valign="top">
<form action="<%=response.encodeUrl("/simpleservlet/Students/choicesubject" + "?"+"id=value" )%>" method="get">
<% String ids=(String) request.getAttribute("ids");
List<Subject> list=(List<Subject>) request.getAttribute("list");
for(Subject u:list) { 
String ur1=String.valueOf(u.getId());  %>
<p>
<input type="checkbox" name="subject" value="<%=ur1%>">
<%=u%>
</p>
<%}%>
<input type="hidden" name="id" value="<%=ids%>">
<input type="submit" value="Добавить">
</form>
</td>
</tr>
</table>
</center>
</body>
</html>



