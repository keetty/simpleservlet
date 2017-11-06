package src.database; 

import java.io.IOException; 
import java.io.PrintWriter; 
import java.net.URLEncoder; 
import java.net.URLDecoder; 
import javax.servlet.http.HttpSession; 
import java.sql.*; 
import java.util.*; 
import javax.servlet.http.Cookie; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


public class SelectAllStudentsServlet extends HttpServlet { 

private static final String LIST_OF_STUDENTS = "/simpleservlet/Students"; 
private static final String LIST_OF_SUBJECTS = "/simpleservlet/Students/Subjects"; 
private static final String LIST_OF_MARKS = "/simpleservlet/Students/AllMarks"; 
private static final String NEW_STUDENT = "/simpleservlet/Students/newstudent"; 
private static final String NEW_SUBJECT = "/simpleservlet/Students/Subjects/newsubject"; 
private static final String NEW_MARK = "/simpleservlet/Students/AllMarks/newmark"; 
private static final String FORM_STUDENT_UPDATE = "/simpleservlet/Students/update/form";
private static final String STUDENT_UPDATE = "/simpleservlet/Students/update"; 
private static final String STUDENT_DELETE = "/simpleservlet/Students/delete"; 
private static final String CHOICE_SUBJECT = "/simpleservlet/Students/choicesubject"; 
private static final String SUBJECT_DELETE = "/simpleservlet/Students/Subjects/delete"; 
private static final String FORM_SUBJECT_UPDATE = "/simpleservlet/Students/Subjects/update/form"; 
private static final String SUBJECT_UPDATE = "/simpleservlet/Students/Subjects/update"; 
private static final String MARK_DELETE = "/simpleservlet/Students/AllMarks/delete"; 
private static final String FORM_MARK_UPDATE = "/simpleservlet/Students/AllMarks/update/form";
private static final String MARK_UPDATE = "/simpleservlet/Students/AllMarks/update"; 




public static void getListOfStudents(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, DaoException { 

HttpSession session = req.getSession(); 

StudentDao sd =(StudentDao)session.getAttribute("StudentDao"); 

List<Student> list =sd.getAllStudents(); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Список студентов группы N</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students/Subjects") + "\">Список предметов</a>"+ "</H3>" + "</td>" + "</tr>" + "</table>" 
+"<p>" +"<table border=\"1\">" + "<tr>" +"<td>" 
+"<H3>"+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students/newstudent") + "\">Добавить нового студента</a>"+ "</H3>" +"</p>" + "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
int i=1; 
for(Student s:list) { 
int id=s.getId(); 
String ids=String.valueOf(id); 
String ur1=s.getFirstName(); 
String ur2=s.getSecondName();
 
pw.println("<H3>" + i +"<a href=\"" + resp.encodeUrl("/simpleservlet/Students/AllMarks" +"?"+"fn="+ur1+"&"+"sn="+ur2+"&"+"id="+ids) + "\">" + s + "</a>" +"</H3>" 
+"<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/choicesubject" + "?"+"id=value" ) 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+"<input type=\"submit\"" 
+ "value=\"Подобрать предметы\">" 
+ "</form>" 
+ "<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/update/form" +"?"+"id=value" +"&" +"firstname=value" + "&" +"secondname=value" ) 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+"<input type=\"hidden\" name=\"firstname\" value='" + ur1 + "'>" 
+"<input type=\"hidden\" name=\"secondname\" value='" + ur2 + "'>" 
+"<input type=\"submit\"" 
+ "value=\"Редактировать\">" 
+ "</form>" 
+"<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/delete" +"?"+"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"submit\"" 
+ "value=\"Удалить\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+ "</form>" 
); 
i++; 
} 
pw.println("</td>" + "</tr>"
+"</table>"+"</center>"); 

} 

public static void chooseSubjects(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, DaoException, NumberFormatException { 

HttpSession session = req.getSession(); 

Student s = new Student(); 
s.setId(Integer.valueOf(req.getParameter("id"))); 
String ids=String.valueOf(s.getId()); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Выберите предметы из списка ниже и нажмите кнопку \"Добавить\"</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
SubjectDao sd = (SubjectDao)session.getAttribute("SubjectDao"); 
List<Subject> list = sd.getAllSubjects(); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/choicesubject" +"?"+"id=" +ids +"&" +"subject=value") 
+ "\" method=\"get\">" );  
for(Subject u:list) { 
String ur1=String.valueOf(u.getId()); 
pw.println("<p><input type=\"checkbox\" name=\"subject\" value='" + ur1 +"'>" + u + "</p>"); 
} 
pw.println("<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 

+ "<input type=\"submit\"" + "value=\"Добавить\">" + "</form>"); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 
 
} 
 
public static void chooseNewSubjects(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
String[] par = req.getParameterValues("subject"); 
StudentDao sd = (StudentDao)session.getAttribute("StudentDao"); 
SubjectDao sb = (SubjectDao)session.getAttribute("SubjectDao"); 
List<Integer> list1 = sd.getSubjectsId(student.getId()); 

for (int i = 0; i < par.length; i++) { 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(par[i])); 
if(list1.contains(Integer.valueOf(par[i]))) { 

pw.println("<H2>Студент уже изучает предмет" + sb.getNameSubject(subject) + ".Выберите другой</H2>"); 
} else { 
sd.setStudentsSubjectsId(student, subject); 
} 
} 

pw.println("<p>" + "<H3>" + "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">" + "Вернуться к списку студентов" + "</a>" + "</H3>" + "</p>"); 
}  


public static void getListOfSubjects(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, DaoException{ 
 
HttpSession session = req.getSession(); 

SubjectDao sb = (SubjectDao)session.getAttribute("SubjectDao"); 
List<Subject> list = sb.getAllSubjects(); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + 
"<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Список преподаваемых предметов</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students")
+ "\">Вернуться к списку студентов</a>"+ "</H3>" + "</td>" + "</tr>" + "</table>" 
+"<p>" +"<table border=\"1\">" + "<tr>" +"<td>" 
+"<H3>"+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students/Subjects/newsubject") + "\">Добавить новый предмет</a>"+ "</H3>" +"</p>" + "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
for(Subject t:list) { 
int id=t.getId(); 
String ids=String.valueOf(id); 
pw.println("<p>" + "<H3>" + t 

+ "<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/Subjects/update/form" +"?"+"id=value" +"&" +"nameofsubject=value" ) 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+"<input type=\"submit\"" 
+ "value=\"Редактировать\">" 
+ "</form>" 
+"<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/Subjects/delete" +"?"+"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"submit\"" 
+ "value=\"Удалить\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+ "</form>" 
+"</H3>" +"</p>" ); 
} 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 

} 


public static void getAllMarks(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

Student s = new Student(); 
s.setId(Integer.valueOf(req.getParameter("id"))); 
s.setFirstName(req.getParameter("fn")); 
s.setSecondName(req.getParameter("sn"));  
String ids=String.valueOf(s.getId()); 
String ur1=s.getFirstName(); 
String ur2=s.getSecondName(); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Список оценок студента" + s +"</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" + "</td>" + "</tr>" + "</table>" 
+"<p>" +"<table border=\"1\">" + "<tr>" +"<td>" 
+"<H3>"+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students/AllMarks/newmark"+"?"+"fn="+ur1+"&"+"sn="+ur2+"&"+"id="+ids) + "\">Добавить новую оценку</a>"+ "</H3>" +"</p>" + "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
DaoListOfMarks dl=(DaoListOfMarks)session.getAttribute("DaoListOfMarks"); 
List<ReportCard> list=dl.getAllMarks(s); 

for(ReportCard r:list) { 
String ur=r.getNameOfSubject(); 
String idss=String.valueOf(r.getId()); 
pw.println("<p>" + "<H3>"+ r + "</H3>" + "</p>" 
+ "<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/AllMarks/update/form" +"?"+"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value= '" + idss + "'>" 
+"<input type=\"hidden\" name=\"ns\" value='" + ur+ "'>" 
+"<input type=\"submit\"" 
+ "value=\"Редактировать\">" 
+ "</form>" 
+"<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/AllMarks/delete" +"?"+"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value='" + idss + "'>" 
+"<input type=\"hidden\" name=\"fn\" value='" + ur1+ "'>" 
+"<input type=\"hidden\" name=\"sn\" value='" + ur2+ "'>" 
+"<input type=\"submit\"" 
+ "value=\"Удалить\">" 
+ "</form>"); 

} 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 

} 

public static void addNewStudent(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, DaoException { 
HttpSession session = req.getSession(); 
if(req.getQueryString()==null) {
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Для добавления нового студента заполните следующую форму</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/newstudent" +"?"+"firstname=value"+"&"+"secondname=value") 
+ "\" method=\"get\">" 
+"<p>Имя" 
+ "<input type=\"text\" name=\"firstname\" value=\"\">" 
+ "</p>" 
+ "<p>Фамилия" 
+"<input type=\"text\" name=\"secondname\" value=\"\">" 
+ "</p>"+ 
"<p>"+"<input type=\"submit\"" + "value=\"Добавить\">" 
+ "</p>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 
} else { 
Student s=new Student(); 
s.setFirstName(req.getParameter("firstname")); 
s.setSecondName(req.getParameter("secondname")); 
StudentDao sd = (StudentDao)session.getAttribute("StudentDao"); 
sd.add(s); 
pw.println("<center>"+"<br>Студент добавлен</br>"+"<p>" + "<H3>" + "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">" + "Вернуться к списку студентов" + "</a>" + "</H3>" + "</p>"+"</center>"); 
}  
} 

public static void addNewSubject(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, DaoException { 

HttpSession session = req.getSession(); 

if(req.getQueryString()==null) { 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Для добавления нового предмета заполните следующую форму</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/Subjects/newsubject" +"?"+"nameodsubject=value") 
+ "\" method=\"get\">" 
+"<p>Название" 
+ "<input type=\"text\" name=\"nameofsubject\" value=\"\">" 
+ "</p>" 
+ "<p>"+"<input type=\"submit\"" + "value=\"Добавить\">" 
+ "</p>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 
} else { 
Subject s=new Subject(); 
s.setNameOfSubject(req.getParameter("nameofsubject")); 
SubjectDao sb = (SubjectDao)session.getAttribute("SubjectDao"); 
sb.add(s); 
pw.println("<center>"+"<br>Предмет добавлен</br>"+"<p>" + "<H3>" + "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">" + "Вернуться к списку студентов" + "</a>" + "</H3>" + "</p>"+"</center>"); 
}  

} 

public static void deleteStudent(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
StudentDao sd = (StudentDao)session.getAttribute("StudentDao"); 
sd.delete(student); 
pw.println ("<H2>Запись удалена</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться к списку студентов</a>"); 
}  

public static void addNewMark(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Добавление новой оценки</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
String ids=req.getParameter("id"); 
Student student = new Student(); 
student.setId(Integer.valueOf(ids)); 
if(req.getParameter("mark")==null) { 

StudentDao sd = (StudentDao)session.getAttribute("StudentDao"); 

List<Integer> subjectId= sd.getSubjectsId(student.getId()); 
pw.println("<H2>Выберите предмет</H2>"); 
pw.println("<select name =\"studentsmark\" form=\"marks\">"); 
SubjectDao sb = (SubjectDao)session.getAttribute("SubjectDao"); 
for(Integer t:subjectId) { 
Subject subject = new Subject(); 
subject.setId(t); 
sb.getNameSubject(subject); 


pw.println("<option value=" + subject.getId() + ">" + sb.getNameSubject(subject) + "</option>"); 
} 
pw.println("</select>"); 
pw.println( "<form id=\"marks\" action=\"" 
+resp.encodeUrl("/simpleservlet/Students/AllMarks/newmark"+"?"+"studentsmark=value" + "&"+"mark=value" +"&"+"id=value") 
+ "\" method=\"get\" >" 
+"<p>Введите оценку" 
+ "<input type=\"text\" name=\"mark\" value=\"\">" 
+ "</p>" 
+ "<p>"+"<input type=\"submit\"" + "value=\"Добавить\">" 
+ "</p>" 
+ "<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 

}  else { 

Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("studentsmark"))); 
DaoMark dm = (DaoMark)session.getAttribute("DaoMark"); 
Mark mark = new Mark(); 
mark.setStudentSubjectId(dm.getStudentSubjectId(student, subject)); 
mark.setMark(Integer.valueOf(req.getParameter("mark"))); 
dm.add(mark); 
pw.println("<center>"+"<br>Оценка добавлена</br>"+"<p>" + "<H3>" + "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">" + "Вернуться к списку студентов" + "</a>" + "</H3>" + "</p>"+"</center>"); 
}  


} 



public static void deleteSubject(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 
 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id"))); 
SubjectDao sd = (SubjectDao)session.getAttribute("SubjectDao"); 
sd.delete(subject); 
pw.println ("<H2>Запись удалена</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться на главную страницу</a>"); 
}  


public static void deleteMark(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

 
Mark mark = new Mark(); 
mark.setId(Integer.valueOf(req.getParameter("id"))); 
DaoMark dm = (DaoMark)session.getAttribute("DaoMark"); 
dm.delete(mark); 

pw.println ("<H2>Запись удалена</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться на главную страницу</a>"); 
}  


public static void formOfUpdateStudent(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
student.setFirstName(req.getParameter("firstname")); 
student.setSecondName(req.getParameter("secondname")); 
String ids=String.valueOf(student.getId());
String ur1=student.getFirstName(); 
String ur2=student.getSecondName(); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Редактирование записи</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/update" +"?"+"fn=value"+"&"+"sn=value"+"&" +"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name=\"id\" value='" + ids + "'>" 
+"<p>Имя" 
+ "<input type=\"text\" name=\"fn\" value='" + ur1+ "'>" 
+ "</p>" 
+ "<p>Фамилия" 
+"<input type=\"text\" name=\"sn\" value='" +ur2+ "'>" 
+ "</p>"+ 
"<p>"+"<input type=\"submit\"" + "value=\"Сохранить изменения\">" 
+ "</p>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 
} 

public static void updateStudent(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw ) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 

Student student = new Student(); 
student.setId(Integer.valueOf(req.getParameter("id"))); 
student.setFirstName(req.getParameter("fn")); 
student.setSecondName(req.getParameter("sn")); 
StudentDao sd = (StudentDao)session.getAttribute("StudentDao"); 
sd.update(student); 
pw.println ("<H2>Обновлено</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться на главную страницу</a>"); 
}  

 

public static void formOfUpdateSubject(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession();  

Subject subject= new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id"))); 
SubjectDao sd = (SubjectDao)session.getAttribute("SubjectDao"); 
Subject subject1=sd.getNameSubject(subject);
subject.setNameOfSubject(subject1.getNameOfSubject()); 
String ids=String.valueOf(subject.getId());
String ur=ur=subject.getNameOfSubject();   
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Редактирование записи</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/Subjects/update" +"?"+"sn=value"+"&" +"id=value") 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name='id' value='" + ids +"' >" 
+"</input>" 
+"<p>Предмет" 
+ "<input type=\"text\" name='sn' value='" + ur + "' >" 
+"</input>" 
+ "</p>" 
+"<p>"+"<input type=\"submit\"" + "value=\"Сохранить изменения\">" 
+ "</p>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>");  
} 

public static void updateSubject(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 

HttpSession session = req.getSession(); 
 
Subject subject = new Subject(); 
subject.setId(Integer.valueOf(req.getParameter("id"))); 
subject.setNameOfSubject(req.getParameter("sn")); 
SubjectDao sd = (SubjectDao)session.getAttribute("SubjectDao"); 
sd.update(subject); 
pw.println ("<H2>Обновлено</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться на главную страницу</a>"); 

}

public static void formOfUpdateMark(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 
HttpSession session = req.getSession();

String ur=req.getParameter("ns"); 
Mark mark = new Mark(); 
mark.setId(Integer.valueOf(req.getParameter("id"))); 
String ids =String.valueOf(mark.getId()); 
DaoMark dm = (DaoMark)session.getAttribute("DaoMark"); 
int i=dm.selectOneMark(mark); 
pw.println("<center>" + "<table border=\"1\" width=\"1024\" height=\"960\">" + "<tr>" +"<td width=\"30%\" height=\"10%\"><H3><center>Меню</center></H3></td>" 
+ "<td><H3><center>Редактирование записи</center></H3></td>" +"</tr>" 
+ "<tr>" 
+"<td valign=\"top\">" +"<table border=\"1\">" + "<tr>" +"<td>" 
+ "<H3>"+"<a href=\"" + resp.encodeUrl("/simpleservlet/Students") + "\">Вернуться к списку студентов</a>"+ "</H3>" 
+ "</td>" + "</tr>" + "</table>" 
+"</td>" 
+"<td valign=\"top\">"); 
pw.println("<form action=\"" 
+resp.encodeUrl("/simpleservlet/Students/AllMarks/update" +"?"+"sn=value"+"&" +"id=value" +"&"+"mark=value") 
+ "\" method=\"get\">" 
+"<input type=\"hidden\" name='id' value='" + ids +"' >" 
+"</input>" 
+"<p>Предмет" 
+ "<input type=\"text\" name='ns' value='" + ur + "' disabled>" 
+"</input>" 
+ "</p>" 
+"<p>Оценка" 
+ "<input type=\"text\" name='mark' value='" + i + "' >" 
+"</input>" 
+ "</p>" 
+"<p>"+"<input type=\"submit\"" + "value=\"Изменить оценку\">" 
+ "</p>" 
+ "</form>" ); 
pw.println("</td>" + "</tr>" +"</table>"+"</center>"); 

} 
public static void updateMark(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw) throws ServletException, IOException, NumberFormatException, DaoException { 
HttpSession session = req.getSession();


Mark mark = new Mark();
mark.setId(Integer.valueOf(req.getParameter("id"))); 
mark.setMark(Integer.valueOf(req.getParameter("mark"))); 
DaoMark dm = (DaoMark)session.getAttribute("DaoMark"); 
dm.update(mark); 
pw.println ("<H2>Обновлено</H2>" 
+ "<a href=\"" + resp.encodeUrl("/simpleservlet/Students") 
+ "\">Вернуться на главную страницу</a>"); 
}



public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
HttpSession session = req.getSession(); 
String url=req.getRequestURI(); 
PrintWriter pw = null; 
String newUrl="";
try { 
StringTokenizer st = new StringTokenizer(url, ";"); 
if(st.hasMoreTokens()) { 
newUrl=st.nextToken(); 
}
resp.setContentType("text/html;charset=utf-8"); 

pw = resp.getWriter(); 

if(newUrl.equals(LIST_OF_STUDENTS)) { 

getListOfStudents(req, resp, pw); 

} else if(newUrl.equals(CHOICE_SUBJECT)) { 
if(req.getParameter("subject")==null) { 

chooseSubjects(req, resp, pw); 
} 
} else if(newUrl.equals(CHOICE_SUBJECT)) { 
if(req.getParameter("subject")!=null) { 
chooseNewSubjects(req, resp, pw); 
} 
}  else if(newUrl.equals(LIST_OF_SUBJECTS)) { 
getListOfSubjects(req, resp, pw); 
} else if(newUrl.equals(LIST_OF_MARKS)) { 

getAllMarks(req, resp, pw); 


} else if(newUrl.equals(NEW_STUDENT)) { 

addNewStudent(req, resp, pw); 

}  else if(newUrl.equals(NEW_SUBJECT)) { 

addNewSubject(req, resp, pw); 
} else if(newUrl.equals(NEW_MARK)) { 
addNewMark(req, resp, pw); 

} else if(newUrl.equals(STUDENT_DELETE)) { 
deleteStudent(req, resp, pw); 
} else if(newUrl.equals(SUBJECT_DELETE)) { 
deleteSubject(req, resp, pw); 
} else if(newUrl.equals(MARK_DELETE)) { 
deleteMark(req, resp, pw); 
}  else if(newUrl.equals(STUDENT_UPDATE)) {
updateStudent(req, resp, pw); 
} else if(newUrl.equals(FORM_STUDENT_UPDATE)){
	formOfUpdateStudent(req, resp, pw);
} else if(newUrl.equals(SUBJECT_UPDATE)) { 
updateSubject(req, resp, pw); 
} else if(newUrl.equals(FORM_SUBJECT_UPDATE)){
	formOfUpdateSubject(req, resp, pw);
} else if(newUrl.equals(MARK_UPDATE)) { 
updateMark(req, resp, pw); 
} else  if(newUrl.equals(FORM_MARK_UPDATE)){
	formOfUpdateMark(req, resp, pw);
} 



} catch(NumberFormatException e) { 
e.printStackTrace(); 
} catch(DaoException e) { 
e.printStackTrace();
pw.println("<p><H3>Произошла ошибка, попробуйте ещё раз</H3></p>"); 
}
 finally { 
try { 
if(pw!=null) { 
pw.close(); 
} 
} catch(Exception e) { 
e.printStackTrace(); 
} 
} 
} 
}