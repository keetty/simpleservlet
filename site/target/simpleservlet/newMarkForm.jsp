<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, spring.database.*, spring.dto.*, spring.service.*, spring.dao.*"%>
  
  
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
	  <center>Добавление новой оценки</center>
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
<H2>Выберите предмет</H2>
<select name ="studentsmark" form="marks">
<% String ids = (String)request.getAttribute("ids");
List<Integer> subjectId=(List<Integer>)request.getAttribute("list");
ServiceSubject sb = (ServiceSubject)request.getAttribute("subjectService");

for(Integer t:subjectId) { 
Subject subject = new Subject(); 
subject.setId(t); 
sb.getNameSubject(subject); %>
<option value="<%=subject.getId()%>"><%=sb.getNameSubject(subject)%></option>
<%}%>
</select>
<form id="marks" action="<%=response.encodeUrl("/simpleservlet/Students/AllMarks/newmark"+"?"+"studentsmark=value" + "&"+"mark=value" +"&"+"id=value")%>" method="get" >
<p>Введите оценку
<input type="text" name="mark" value="">
</p>
<p>
<input type="submit" value="Добавить">
</p>
<input type="hidden" name="id" value="<%=ids%>">
</form>
</td>
</tr>
</table>
</center>
</body>
</html>





