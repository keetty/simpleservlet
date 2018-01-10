package folder.database; 

import java.io.IOException;  
import java.io.PrintWriter; 
import java.net.URLEncoder; 
import javax.servlet.http.HttpSession; 
import java.sql.*; 
import java.util.*; 
import javax.servlet.ServletConfig; 
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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;





@WebServlet(name = "simpleservlet", urlPatterns = {"/Students/*"})
public class SelectAllStudentsServlet extends HttpServlet { 

@Autowired
ServiceStudent service;
private static final String NEW_STUDENT = "/simpleservlet/Students/newstudent";


 public void init(ServletConfig config) throws ServletException {
    super.init(config);
    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
  }

public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

	String url=req.getRequestURI(); 
String newUrl="";
resp.setContentType("text/html;charset=utf-8"); 

StringTokenizer st = new StringTokenizer(url, ";"); 
if(st.hasMoreTokens()) { 
newUrl=st.nextToken(); 
}
if(newUrl.equals(NEW_STUDENT)&& req.getQueryString()==null) {
RequestDispatcher rd = req.getRequestDispatcher("/addNewStudentForm.jsp");
rd.forward(req, resp);
} else if(newUrl.equals(NEW_STUDENT) && req.getQueryString()!=null) {
Student student = new Student();
student.setFirstName(req.getParameter("firstname")); 
student.setSecondName(req.getParameter("secondname")); 
service.addStudent(student);
RequestDispatcher rd = req.getRequestDispatcher("/newStudent.jsp");
rd.forward(req, resp); 
}


	
} 

} 
