<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, src.database.*"%>
  
  
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
<center>Для добавления нового предмета заполните следующую форму</center>
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
<form action="<%=response.encodeUrl("/simpleservlet/Students/Subjects/newsubject" +"?"+"nameodsubject=value")%>" method="get">
<p>Название
<input type="text" name="nameofsubject" value="">
</p>
<p>
<input type="submit" value="Добавить">
</p>
</form>
</td>
</tr>
</table>
</center>
</body>
</html>