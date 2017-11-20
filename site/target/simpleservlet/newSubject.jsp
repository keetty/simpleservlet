<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, src.database.*"%>
  
  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  </head>
	  <body>
	  <center>
	  <br>Предмет добавлен</br>
	  <p>
	  <H3>
	  <a href="<%=response.encodeUrl("/simpleservlet/Students")%>">Вернуться к списку студентов</a>
	  </H3>
	  </p>
	  </center>
	  </body>
	  </html>