package src.database;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.RequestDispatcher; 

public class HelloServlet extends HttpServlet {
 
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
String url=req.getRequestURI(); 
resp.setContentType("text/html;charset=utf-8");
if(url.equals("/page/hello")) {
RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
rd.forward(req, resp); 
} else {
RequestDispatcher rd = req.getRequestDispatcher("/bel.jsp");
rd.forward(req, resp); 
}

}
}