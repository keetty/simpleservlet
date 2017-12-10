package folder.database; 

import java.io.IOException;  
import java.io.PrintWriter; 
import java.net.URLEncoder; 
import javax.servlet.http.HttpSession; 
import java.sql.*; 
import java.util.*;  
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.annotation.WebServlet;
import org.springframework.stereotype.Component;
import  org.springframework.beans.factory.annotation.Autowired;

  @WebServlet(name = "Students", urlPatterns = {"/Students/*"})
  @Component
public class SelectAllStudentsServlet extends HttpServlet { 

private static final String LIST_OF_STUDENTS = "/simpleservlet/Students"; 

@Autowired

 private static Student sd;


public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
try {
	String url=req.getRequestURI(); 
String newUrl="";
resp.setContentType("text/html;charset=utf-8"); 

StringTokenizer st = new StringTokenizer(url, ";"); 
if(st.hasMoreTokens()) { 
newUrl=st.nextToken(); 
}

PrintWriter pw= resp.getWriter();
pw.print(sd.getFirstName() + sd.getSecondName());
	
} catch(DaoException e) {
e.printStackTrace();
} 

} 
}