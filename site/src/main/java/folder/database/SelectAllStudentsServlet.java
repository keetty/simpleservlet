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
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;





@WebServlet(name = "simpleservlet", urlPatterns = {"/Students/*"})
public class SelectAllStudentsServlet extends HttpServlet { 

public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
resp.setContentType("text/html;charset=utf-8");
WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
PrintWriter pw= resp.getWriter();
pw.print(context.getBean("student"));
	
} 

} 
