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
import org.springframework.stereotype.Controller;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping({"/", "/Students"})
public class SelectAllStudentsServlet { 


 @Autowired
 Student student;

@RequestMapping(value = "/Student", method = RequestMethod.GET)
public void getStudent(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
PrintWriter pw= resp.getWriter();
pw.print(student.getFirstName() + student.getSecondName());
	
} 

} 
