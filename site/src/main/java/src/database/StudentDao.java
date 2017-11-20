package src.database; 
import java.sql.*;
import java.util.*;
import src.database.*;

public class StudentDao implements StudentDaoImpl {
private final String sql1="INSERT INTO STUDENTS" + "(FIRST_NAME, SECOND_NAME) VALUES" 
+ "(?,?)";
private final String sql2="UPDATE STUDENTS SET FIRST_NAME=?, SECOND_NAME=? WHERE ID = ?";
private final String sql3="DELETE FROM STUDENTS WHERE ID = ? ";
private final String sql4="SELECT ID, FIRST_NAME, SECOND_NAME FROM STUDENTS ";
private final String sql5="INSERT INTO STUDENTS_SUBJECTS" + "(STUDENTS_ID, SUBJECTS_ID) VALUES" 
+ "(?,?)";
private final String sql6="SELECT SUBJECTS_ID FROM  STUDENTS_SUBJECTS WHERE STUDENTS_ID=?";
private Connection connection;
private PreparedStatement st1;
private PreparedStatement st2;
private PreparedStatement st3;
private PreparedStatement st4;
private PreparedStatement st5;
private PreparedStatement st6;


public StudentDao() throws SQLException, DaoException {
try {
ConnectionFactory cf = new ConnectionFactory();
connection=cf.getConnection();
st1=connection.prepareStatement(sql1);
st2=connection.prepareStatement(sql2);
st3=connection.prepareStatement(sql3);
st4=connection.prepareStatement(sql4);
st5=connection.prepareStatement(sql5);
st6=connection.prepareStatement(sql6);




} catch(SQLException e) {
throw new DaoException(" Cannot create the daoObject ", e);
}
}

@Override

public Student add(Student student) throws DaoException {
	ResultSet rs=null;
	
try {
st1.setString(1, student.getFirstName());
st1.setString(2, student.getSecondName());
st1.executeUpdate();
} catch(SQLException e) {
	e.printStackTrace();
throw new DaoException(" Cannot create the student ", e);
} finally { 
try { 
if(rs!=null) { 
rs.close(); 
}  
}  catch(SQLException e) { 
new DaoException(" Closing error", e); 
} 
}
return student;
}


	public void setStudentsSubjectsId(Student student, Subject subject) throws DaoException {
		try {
	        st5.setInt(1, student.getId());
			st5.setInt(2, subject.getId());
			st5.executeUpdate();
			} catch(SQLException e) {
	e.printStackTrace();
throw new DaoException(" Cannot create the student ", e);
}
	}
	
	
 @Override
public void update(Student student) throws DaoException {
try{
st2.setString(1, student.getFirstName());
st2.setString(2, student.getSecondName());
st2.setInt(3, student.getId());
st2.executeUpdate();
} catch(SQLException e) {
	e.printStackTrace();
throw new DaoException(" Cannot update the student  ", e);
}
}

@Override

public void delete(Student student) throws DaoException {
try {
st3.setInt(1, student.getId());
st3.executeUpdate();
} catch(SQLException e) {
throw new DaoException(" Cannot delete the student  "   , e);
} 
}

@Override

public List<Student> getAllStudents() throws DaoException {
List<Student> list = new ArrayList<Student>();
ResultSet rs=null;
try {
rs=st4.executeQuery();
while(rs.next()) {
Student student = new Student();
student.setId(rs.getInt("ID"));
student.setFirstName(rs.getString("FIRST_NAME"));
student.setSecondName(rs.getString("SECOND_NAME"));
list.add(student);
}

} catch(SQLException e) {
throw new DaoException(" Cannot select the list of students ", e);
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

public List<Integer> getSubjectsId(int key) throws DaoException  {
	ResultSet rs = null;
	List<Integer> list = new ArrayList<Integer>();
	try {
	st6.setInt(1, key);
		rs=st6.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt("SUBJECTS_ID"));
		}
	} catch(SQLException e) {
throw new DaoException(" Cannot select the list of students ", e);
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
		

@Override

public  void close() throws DaoException {  
try {
st1.close();
} catch(SQLException e) {
throw new DaoException("Closing error ", e);
} finally {
try{
st2.close();
} catch(SQLException e) {
throw new DaoException("Closing error ", e);
} finally {
try {
st3.close();
} catch(SQLException e) {
throw new DaoException("Closing error ", e);
} finally {
try {
st4.close();
} catch(SQLException e) {
throw new DaoException("Closing error ", e);
} finally {
try {
connection.close();
} catch(SQLException e) {
throw new DaoException("Closing error ", e);
}
}
}
}
}
}
}


