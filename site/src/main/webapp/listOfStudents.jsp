<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, spring.database.*, spring.dto.*, spring.service.*"%>
  
  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	   <script type="text/javascript" src="jqu.js"></script>
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
<center>Список студентов группы N</center>
</H3>
</td>
</tr>
<tr>
<td valign="top">
<table border="1">
<tr>
<td>
<H3>
<a href="<%=response.encodeUrl("/simpleservlet/Students/Subjects")%>">Список предметов</a>
</H3>
</td>
</tr>
</table>
<p>
<table border="1">
<tr>
<td>
<H3>
Добавить нового студента
</H3>
<form id="new" method="get"> 
<p>Имя 
<input id="firstname" type="text"  name="firstname" value=""/> 
</p> 
<p>Фамилия 
<input id="secondname" type="text" name="secondname" value=""/> 
</p>
</form>
<button type="button" id="sub" form="new" >Отправить</button>
</p>
</td>
</tr>
</table>
</td> 
<td valign="top">
<div id="select">
<% int i = 1; 
List<Student> list=(List<Student>) request.getAttribute("list");
for(Student s:list) { 
int id=s.getId(); 
String ids=String.valueOf(id); 
String ur1=s.getFirstName(); 
String ur2=s.getSecondName();%>

<H3>
<br>
<%=i%>
<a href="<%=response.encodeUrl("/simpleservlet/Students/AllMarks" +"?"+"fn="+ur1+"&"+"sn="+ur2+"&"+"id="+ids)%>"><%=s%></a>
 </H3>
 </br>
 <br>
 <form action="<%=response.encodeUrl("/simpleservlet/Students/choicesubject" + "?"+"id=value" )%>" method="get">
 <input type="hidden" name="id" value="<%=ids%>">
 <input type="submit" value="Подобрать предметы">
 </form>
 </br>
 <br>
 <form action="<%=response.encodeUrl("/simpleservlet/Students/update/form" +"?"+"id=value" +"&" +"firstname=value" + "&" +"secondname=value" )%>" method="get">
<input type="hidden" name="id" value="<%=ids%>">
<input type="hidden" name="firstname" value="<%=ur1%>">
<input type="hidden" name="secondname" value="<%=ur2%>">
<input type="submit" value="Редактировать">
</form>
</br>
<br>
<form action="<%=response.encodeUrl("/simpleservlet/Students/delete" +"?"+"id=value")%>" method="get">
<input type="submit" value="Удалить">
<input type="hidden" name="id" value="<%=ids%>">
</form>
</br>
<%i++; 
} %>
</div>
</td>
</tr>
</table>
</center>
</body>
</html>


