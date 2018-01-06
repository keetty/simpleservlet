<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.IOException,  java.util.*, java.sql.*, javax.servlet.http.*, javax.servlet.ServletException, java.net.URLEncoder, spring.database.*, spring.dto.*, spring.service.*, spring.dao.*"%>
  
  
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  </head>
	  <body>
	  <% String[] par = (String[])request.getAttribute("par");
	  List<Integer> list1 = (List<Integer>)request.getAttribute("list1");
	  ServiceSubject sb=(ServiceSubject)request.getAttribute("subjectService");
	  ServiceStudent sd = (ServiceStudent)request.getAttribute("studentService");
	  Student student = (Student)request.getAttribute("student");
	  for (int i = 0; i < par.length; i++) { 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(par[i])); 
if(list1.contains(Integer.valueOf(par[i]))) { %>

<H2>Студент уже изучает предмет" 
<%=sb.getNameSubject(subject)%>
".Выберите другой</H2>
<%} else { 
sd.setStudentsSubjectsId(student, subject); 
} 
} %>
<p>
<H3>
<a href="<%=response.encodeUrl("/simpleservlet/Students")%>">Вернуться к списку студентов</a>
</H3>
</p>
</body>
</html>