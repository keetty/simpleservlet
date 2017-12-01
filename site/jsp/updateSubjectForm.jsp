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
	  <center>Редактирование записи</center>
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
	  <% String ids=(String)request.getAttribute("ids");
	  String ur=(String)request.getAttribute("ur"); %>
	  <form action="<%=response.encodeUrl("/simpleservlet/Students/Subjects/update" +"?"+"sn=value"+"&" +"id=value")%>" method="get">
<input type="hidden" name="id" value="<%=ids%>">
</input>
<p>Предмет
<input type="text" name="sn" value="<%=ur%>">
</input>
</p>
<p>
<input type="submit" value="Сохранить изменения">
</p>
</form>
</td>
</tr>
</table>
</center>
</body>
</html>

