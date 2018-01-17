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
<% String ur1 = (String)request.getAttribute("ur1");
String ur2 = (String)request.getAttribute("ur2");
String ids = (String)request.getAttribute("ids");%>
<center>Список оценок студента 
<%=ur1%> 
<%=ur2%>
</center>
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
<p>
<table border="1">
<tr>
<td>
<H3>
<a href="<%=response.encodeUrl("/simpleservlet/Students/AllMarks/newmark"+"?"+"fn="+ur1+"&"+"sn="+ur2+"&"+"id="+ids)%>">Добавить новую оценку</a>
</H3>
</p>
</td>
</tr>
</table>
</td>
<td valign="top">
<% List<Map<Subject,Mark>> list = (List<Map<Subject,Mark>>)request.getAttribute("list");
Mark mark;
for(Map<Subject,Mark> map:list) { 
Set subjects = map.keySet(); 
for(Subject subject : subjects) {
String ur=subject.getNameOfSubject(); 
mark=map.get(subject);
String idss=String.valueOf(mark.getId());
String  mark=String.valueOf(mark.getMark());
%>
<p>
<H3><%=r%>
</H3>
</p>
<br>
<form action="<%=response.encodeUrl("/simpleservlet/Students/AllMarks/update/form" +"?"+"id=value")%>"  method="get">
<input type="hidden" name="id" value="<%=idss%>"> 
<input type="hidden" name="mark" value="<%=mark%>"> 
<input type="hidden" name="ns" value="<%=ur%>">
<input type="submit" value="Редактировать">
</form>
</br>
<br>
<form action="<%=response.encodeUrl("/simpleservlet/Students/AllMarks/delete" +"?"+"id=value")%>" method="get">
<input type="hidden" name="id" value="<%=idss%>"> 
<input type="hidden" name="fn" value="<%=ur1%>">
<input type="hidden" name="sn" value="<%=ur2%>">
<input type="submit" value="Удалить">
</form>
</br>
<%}%>
</td>
</tr>
</table>
</center>
</body>
</html>
