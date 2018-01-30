package spring.database; 

import java.io.IOException;  
import java.io.PrintWriter; 
import java.net.URLEncoder; 
import javax.servlet.http.HttpSession; 
import java.sql.*; 
import java.util.*;  
import spring.dto.*;
import spring.service.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletConfig; 
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;



@WebServlet(name = "Students", urlPatterns = {"/Students/*"})


public class SelectAllStudentsServlet extends HttpServlet { 

private static final String LIST_OF_STUDENTS = "/simpleservlet/Students"; 
private static final String LIST = "/simpleservlet/Students/select"; 
private static final String CHOICE_SUBJECT = "/simpleservlet/Students/choicesubject"; 
private static final String LIST_OF_SUBJECTS = "/simpleservlet/Students/Subjects"; 
private static final String LIST_OF_MARKS = "/simpleservlet/Students/AllMarks"; 
private static final String NEW_STUDENT = "/simpleservlet/Students/newstudent";
private static final String NEW_SUBJECT = "/simpleservlet/Students/Subjects/newsubject"; 
private static final String NEW_MARK = "/simpleservlet/Students/AllMarks/newmark"; 
private static final String STUDENT_DELETE = "/simpleservlet/Students/delete"; 
private static final String SUBJECT_DELETE = "/simpleservlet/Students/Subjects/delete";
private static final String MARK_DELETE = "/simpleservlet/Students/AllMarks/delete"; 
private static final String FORM_STUDENT_UPDATE = "/simpleservlet/Students/update/form";
private static final String STUDENT_UPDATE = "/simpleservlet/Students/update"; 
private static final String FORM_SUBJECT_UPDATE = "/simpleservlet/Students/Subjects/update/form"; 
private static final String SUBJECT_UPDATE = "/simpleservlet/Students/Subjects/update"; 
private static final String FORM_MARK_UPDATE = "/simpleservlet/Students/AllMarks/update/form";
private static final String MARK_UPDATE = "/simpleservlet/Students/AllMarks/update"; 


@Autowired
private  ServiceStudent studentService;

@Autowired
private  ServiceSubject subjectService;

@Autowired
private  ServiceMark markService;

@Autowired 
private ServiceStudentSubject ssService;

public void init(ServletConfig config) throws ServletException {
    super.init(config);
    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
  }

public  void getListOfStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
List<Student> list =studentService.getListStudents(); 
req.setAttribute("list", list);
RequestDispatcher rd = req.getRequestDispatcher("/listOfStudents.jsp");
rd.forward(req, resp);
} 

public  void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
PrintWriter pw=resp.getWriter();
List<Student> list =studentService.getListStudents(); 
for(Student s:list) { 
int id=s.getId(); 
String ids=String.valueOf(id); 
String ur1=s.getFirstName(); 
String ur2=s.getSecondName();
pw.println("<H3>" + "<br>" +
"<a href=\"" + resp.encodeUrl("/simpleservlet/Students/AllMarks" +"?"+"fn="+ur1+"&"+"sn="+ur2+"&"+"id="+ids)+"\">"+ s +"</a>");
pw.println("</H3>" +"</br>"+"<br>" +
 "<form action=\""+resp.encodeUrl("/simpleservlet/Students/choicesubject" + "?"+"id=value''" ) + "\"method=\"get\">" +
"<input type='hidden' name='id' value='"+ids+"'>" +
 "<input type='submit' value='Подобрать предметы'>" +
 "</form>" +"</br>"+"<br>" +
 "<form action=\"" +resp.encodeUrl("/simpleservlet/Students/update/form" +"?"+"id=value" +"&" +"firstname=value" + "&" +"secondname=value" )+"\" method=\"get\">" +
 "<input type='hidden' name='id' value='"+ids+"'>" +
"<input type='hidden' name='firstname' value='"+ur1+"'>" +
"<input type='hidden' name='secondname' value='"+ur2+"'>" +
"<input type='submit' value=\"Редактировать\">" + "</form>" +"</br>" +"<br>" +
"<form action=\"" +resp.encodeUrl("/simpleservlet/Students/delete" +"?"+"id=value")+"\" method=\"get\">" +
"<input type='submit' value=\"Удалить\">" +
"<input type='hidden' name='id' value='" +ids+ "'>" +"</form>" + "</br>");
}

} 

public  void chooseSubjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

Student s = new Student(); 
s.setId(Integer.valueOf(req.getParameter("id"))); 
String ids=String.valueOf(s.getId()); 
req.setAttribute("student", s);
req.setAttribute("ids", ids);

List<Subject> list = subjectService.getListSubjects(); 
req.setAttribute("list", list);
RequestDispatcher rd = req.getRequestDispatcher("/chooseSubjects.jsp");
rd.forward(req, resp);
} 

public void chooseNewSubjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 


Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
String[] par = req.getParameterValues("subject"); 
req.setAttribute("student", student);
req.setAttribute("par", par);

req.setAttribute("studentService", studentService);
 
req.setAttribute("subjectService", subjectService);
req.setAttribute("ssService", ssService);
List<Integer> list1 = ssService.getSubjectsId(student.getId()); 
req.setAttribute("list1", list1);
RequestDispatcher rd = req.getRequestDispatcher("/chooseNewSubject.jsp");
rd.forward(req, resp);

}  

public  void getListOfSubjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
 

List<Subject> list = subjectService.getListSubjects(); 
req.setAttribute("list", list);
RequestDispatcher rd = req.getRequestDispatcher("/listOfSubjects.jsp");
rd.forward(req, resp);
}

public  void getAllMarks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

Student s = new Student(); 
s.setId(Integer.valueOf(req.getParameter("id"))); 
s.setFirstName(req.getParameter("fn")); 
s.setSecondName(req.getParameter("sn"));  
String ids=String.valueOf(s.getId()); 
String ur1=s.getFirstName(); 
String ur2=s.getSecondName(); 
req.setAttribute("ur1", ur1);
req.setAttribute("ur2", ur2);
req.setAttribute("ids", ids);

List<ListMark> list=markService.getAllMarks(s.getId()); 
req.setAttribute("list", list);
RequestDispatcher rd = req.getRequestDispatcher("/allMarks.jsp");
rd.forward(req, resp);

} 

public  void addNewStudentForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
RequestDispatcher rd = req.getRequestDispatcher("/addNewStudentForm.jsp");
rd.forward(req, resp);
}

public void addNewStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
PrintWriter pw = resp.getWriter();
	Student s=new Student(); 
s.setFirstName(req.getParameter("firstname")); 
s.setSecondName(req.getParameter("secondname")); 
studentService.add(s); 
pw.println(s);
}

public  void addNewSubjectForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 

RequestDispatcher rd = req.getRequestDispatcher("/addNewSubjectForm.jsp");
rd.forward(req, resp); 

} 

public  void addNewSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 

Subject s=new Subject(); 
s.setNameOfSubject(req.getParameter("nameofsubject")); 

subjectService.add(s); 
RequestDispatcher rd = req.getRequestDispatcher("/newSubject.jsp");
rd.forward(req, resp); 
}  

public  void addNewMarkForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 


String ids=req.getParameter("id"); 
Student student = new Student(); 
student.setId(Integer.valueOf(ids)); 

List<Integer> subjectId= ssService.getSubjectsId(student.getId()); 
req.setAttribute("list", subjectId);
req.setAttribute("subjectService", subjectService);
req.setAttribute("ids", ids);
RequestDispatcher rd = req.getRequestDispatcher("/newMarkForm.jsp");
rd.forward(req, resp); 

} 

public  void addNewMark(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

String ids=req.getParameter("id"); 
Student student = new Student(); 
student.setId(Integer.valueOf(ids)); 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("studentsmark")));  
Mark mark = new Mark(); 
Cord cord = new Cord();
cord.setStudentId(student.getId());
cord.setSubjectId(subject.getId());
cord.setId(ssService.getStudentSubjectId(student.getId(), subject.getId()));
mark.setStudentSubjectId(cord); 
mark.setMark(Integer.valueOf(req.getParameter("mark"))); 
markService.add(mark); 
RequestDispatcher rd = req.getRequestDispatcher("/newMark.jsp");
rd.forward(req, resp); 
}  

public  void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 

studentService.delete(student); 
RequestDispatcher rd = req.getRequestDispatcher("/delete.jsp");
rd.forward(req, resp); 
}  

public  void deleteSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id")));  
subjectService.delete(subject); 
RequestDispatcher rd = req.getRequestDispatcher("/delete.jsp");
rd.forward(req, resp); 
}  


public  void deleteMark(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

 
Mark mark = new Mark(); 
mark.setId(Integer.valueOf(req.getParameter("id"))); 

markService.delete(mark); 

RequestDispatcher rd = req.getRequestDispatcher("/delete.jsp");
rd.forward(req, resp); 
}  


public  void formOfUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 


Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
student.setFirstName(req.getParameter("firstname")); 
student.setSecondName(req.getParameter("secondname")); 
String ids=String.valueOf(student.getId());
String ur1=student.getFirstName(); 
String ur2=student.getSecondName(); 
req.setAttribute("ids", ids);
req.setAttribute("ur1", ur1);
req.setAttribute("ur2", ur2);
RequestDispatcher rd = req.getRequestDispatcher("/updateStudentForm.jsp");
rd.forward(req, resp); 
} 

public  void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 



Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
student.setFirstName(req.getParameter("fn")); 
student.setSecondName(req.getParameter("sn"));  
studentService.update(student); 
RequestDispatcher rd = req.getRequestDispatcher("/update.jsp");
rd.forward(req, resp); 
}  

public  void formOfUpdateSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 


Subject subject= new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id"))); 
Subject subject1=subjectService.getNameSubject(subject.getId());
subject.setNameOfSubject(subject1.getNameOfSubject()); 
String ids=String.valueOf(subject.getId());
String ur=ur=subject.getNameOfSubject();  
req.setAttribute("ids", ids);
req.setAttribute("ur", ur); 
RequestDispatcher rd = req.getRequestDispatcher("/updateSubjectForm.jsp");
rd.forward(req, resp); 
} 

public  void updateSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 

 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id"))); 
subject.setNameOfSubject(req.getParameter("sn")); 

subjectService.update(subject); 
RequestDispatcher rd = req.getRequestDispatcher("/update.jsp");
rd.forward(req, resp); 

}


public  void formOfUpdateMark(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 


String ur=req.getParameter("ns"); 
Mark mark = new Mark(); 
mark.setId(Integer.valueOf(req.getParameter("id"))); 
mark.setMark(Integer.valueOf(req.getParameter("mark")));
int i=mark.getMark();
String ids =String.valueOf(mark.getId()); 
req.setAttribute("ids", ids);
req.setAttribute("ur", ur);
req.setAttribute("i", i);
RequestDispatcher rd = req.getRequestDispatcher("/updateMarkForm.jsp");
rd.forward(req, resp);

} 
public  void updateMark(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException { 



Mark mark = new Mark();
mark.setId(Integer.valueOf(req.getParameter("id"))); 
mark.setMark(Integer.valueOf(req.getParameter("mark"))); 

markService.update(mark); 
RequestDispatcher rd = req.getRequestDispatcher("/update.jsp");
rd.forward(req, resp);
}


public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
	String url=req.getRequestURI(); 
String newUrl="";
resp.setContentType("text/html;charset=utf-8"); 

StringTokenizer st = new StringTokenizer(url, ";"); 
if(st.hasMoreTokens()) { 
newUrl=st.nextToken(); 
}

if(newUrl.equals(LIST_OF_STUDENTS)) { 
getListOfStudents(req, resp);
} else if(newUrl.equals(LIST)) {
	getList(req, resp);
} else if(newUrl.equals(CHOICE_SUBJECT) && req.getParameter("subject")==null) { 

chooseSubjects(req, resp); 
} else if(newUrl.equals(CHOICE_SUBJECT) && req.getParameter("subject")!=null) {  
chooseNewSubjects(req, resp); 
} else if(newUrl.equals(LIST_OF_SUBJECTS)) {

	getListOfSubjects(req, resp);
	
} else if(newUrl.equals(LIST_OF_MARKS)) {
	getAllMarks(req, resp);
} else if(newUrl.equals(NEW_STUDENT)&& req.getQueryString()==null) {
	addNewStudentForm(req, resp);
} else if(newUrl.equals(NEW_STUDENT) && req.getQueryString()!=null) {
	addNewStudent(req, resp);
} else if(newUrl.equals(NEW_SUBJECT)&& req.getQueryString()==null) {
	addNewSubjectForm(req, resp);
} else if(newUrl.equals(NEW_SUBJECT) && req.getQueryString()!=null) {
	addNewSubject(req, resp);
} else if (newUrl.equals(NEW_MARK) && req.getParameter("mark")==null) {
	addNewMarkForm(req, resp);
} else if(newUrl.equals(NEW_MARK) && req.getParameter("mark")!=null) {
	addNewMark(req, resp);
} else if(newUrl.equals(STUDENT_DELETE) ) {
	deleteStudent(req, resp);
} else if(newUrl.equals(SUBJECT_DELETE)) {
	deleteSubject(req, resp);
} else if(newUrl.equals(MARK_DELETE)) {
	deleteMark(req, resp);
}  else if(newUrl.equals(STUDENT_UPDATE)) {
updateStudent(req, resp); 
} else if(newUrl.equals(FORM_STUDENT_UPDATE)){
	formOfUpdateStudent(req, resp);
} else if(newUrl.equals(SUBJECT_UPDATE)) { 
updateSubject(req, resp); 
} else if(newUrl.equals(FORM_SUBJECT_UPDATE)){
	formOfUpdateSubject(req, resp);
} else if(newUrl.equals(MARK_UPDATE)) { 
updateMark(req, resp); 
} else  if(newUrl.equals(FORM_MARK_UPDATE)){
	formOfUpdateMark(req, resp);
} 
	


} 
}