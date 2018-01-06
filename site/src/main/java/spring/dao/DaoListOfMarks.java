package spring.dao; 
import spring.database.*;
import spring.dto.*;
import java.sql.*; 
import java.util.*; 
import spring.database.*; 
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import javax.annotation.PostConstruct;

@Component("listDao")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class DaoListOfMarks  {  
private static final String SELECT_STUDENTS="SELECT ID, FIRST_NAME, SECOND_NAME FROM STUDENTS";  
private static final String MARKS="SELECT M.ID, NAME_OF_SUBJECT, MARKS FROM STUDENTS S JOIN STUDENTS_SUBJECTS T ON S.ID=T.STUDENTS_ID JOIN SUBJECTS U ON U.ID=T.SUBJECTS_ID JOIN MARKS M ON T.ID=M.STUDENTS_SUBJECTS_ID  WHERE S.ID=? ORDER BY U.ID ";
private static final String MARKS_ONE_SUBJECT="SELECT MARKS FROM STUDENTS S JOIN STUDENTS_SUBJECTS T ON S.ID=T.STUDENTS_ID JOIN SUBJECTS U ON U.ID=T.SUBJECTS_ID JOIN MARKS M ON T.ID=M.STUDENTS_SUBJECTS_ID  WHERE U.ID=? AND S.ID=? ";
private  Connection connection; 
private  PreparedStatement selectStudent;
private  PreparedStatement allMarks;
private  PreparedStatement marksAtOneSubject;



public DaoListOfMarks() throws SQLException, DaoException { 
try { 
ConnectionFactory cf = new ConnectionFactory(); 
connection=cf.getConnection(); 
selectStudent=connection.prepareStatement(SELECT_STUDENTS);
allMarks=connection.prepareStatement(MARKS);
marksAtOneSubject=connection.prepareStatement(MARKS_ONE_SUBJECT);
} catch(SQLException e) { 
throw new DaoException(" Cannot create the daoObject ", e); 
} 
} 


public List<Student> getListOfStudents() throws DaoException {
ResultSet rs1=null;
List<Student> list = new ArrayList<Student>();
try {
rs1=selectStudent.executeQuery(); 
if(rs1.next()) {
Student student = new Student();
student.setId(rs1.getInt("ID"));
student.setFirstName(rs1.getString("FIRST_NAME"));
student.setSecondName(rs1.getString("SECOND_NAME"));
list.add(student);
} 
} catch(SQLException e) { 
new DaoException(" Cannot select the data", e); 
} finally {
try {
if(rs1!=null) {
rs1.close();
}
} catch(SQLException e) { 
new DaoException(" Closing error", e); 
}
}
return list;
}





public List<ReportCard> getAllMarks(Student student) throws DaoException { 
ResultSet rs=null; 
List<ReportCard> list = new ArrayList<ReportCard>();
try {  
allMarks.setInt(1, student.getId());
rs=allMarks.executeQuery();
while(rs.next()) {
ReportCard card = new ReportCard();
card.setId(rs.getInt("M.ID"));
card.setNameOfSubject(rs.getString("NAME_OF_SUBJECT"));
card.setMarks(rs.getInt("MARKS"));
list.add(card);
}
} catch(SQLException e) { 
new DaoException(" Cannot select the data", e); 
} finally { 
try { 
if(rs!=null) { 
rs.close(); 
} 
} catch(SQLException e) { 
new DaoException(" Closing error", e); 
} 
} 
return list; 
}

public List<Mark> getMarks(Subject subject,Student student) throws DaoException {
ResultSet rs=null; 
List<Mark> list = new ArrayList<Mark>();
try {  
marksAtOneSubject.setInt(1, subject.getId());
marksAtOneSubject.setInt(2, student.getId());
rs=marksAtOneSubject.executeQuery();
while(rs.next()) {
Mark mark=new Mark();
mark.setId(rs.getInt("M.ID"));
mark.setStudentId(rs.getInt("S.ID"));
mark.setSubjectId(rs.getInt("U.ID"));
mark.setStudentSubjectId(rs.getInt("T.ID"));
mark.setMark(rs.getInt("M.MARKS"));
list.add(mark);
}
} catch(SQLException e) { 
new DaoException(" Cannot select the data", e); 
} finally { 
try { 
if(rs!=null) { 
rs.close(); 
} 
} catch(SQLException e) { 
new DaoException(" Closing error", e); 
} 
} 
return list; 
}

public void close() throws DaoException { 
DaoException ex=null;
try {
if(selectStudent!=null) {
selectStudent.close();
}
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
}  
try {
if(allMarks!=null) {
allMarks.close();
}
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
} 
try { 
if(connection!=null) { 
connection.close(); 
} 
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
}  
if(ex!=null) { 
throw ex; 
} 
}
}



