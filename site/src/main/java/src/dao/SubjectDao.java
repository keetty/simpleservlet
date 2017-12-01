package src.dao; 
import src.database;
import src.dto;
import java.sql.*;
import java.util.*;
import src.database.*;
import org.springframework.stereotype.Repository;

@Repository

public class SubjectDao implements SubjectDaoImpl {
private final String sql1="INSERT INTO SUBJECTS" + "(NAME_OF_SUBJECT) VALUES" 
+ "(?)";
private final String sql2="UPDATE SUBJECTS SET NAME_OF_SUBJECT=? WHERE ID = ?";
private final String sql3="DELETE FROM SUBJECTS WHERE ID = ?";
private final String sql4="SELECT ID, NAME_OF_SUBJECT FROM SUBJECTS ";
private final String sql5="SELECT NAME_OF_SUBJECT FROM SUBJECTS WHERE ID=?";


private Connection connection;
private PreparedStatement st1;
private PreparedStatement st2;
private PreparedStatement st3;
private PreparedStatement st4;
private PreparedStatement st5;



public SubjectDao() throws SQLException {
ConnectionFactory mf = new ConnectionFactory();
connection=mf.getConnection();
st1=connection.prepareStatement(sql1);
st2=connection.prepareStatement(sql2);
st3=connection.prepareStatement(sql3);
st4=connection.prepareStatement(sql4);
st5=connection.prepareStatement(sql5);

}

@Override

public Subject add(Subject subject) throws DaoException {
try {
st1.setString(1, subject.getNameOfSubject());
st1.executeUpdate();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} 
return subject;
}


 @Override
public void update(Subject subject) throws  DaoException {

try{
st2.setString(1, subject.getNameOfSubject());	
st2.setInt(2, subject.getId());
st2.executeUpdate();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
}
}


@Override

public void delete(Subject subject) throws  DaoException {
try {
st3.setInt(1, subject.getId());
st3.executeUpdate();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} 
}

@Override

public List<Subject> getAllSubjects() throws  DaoException {
List<Subject> list = new ArrayList<Subject>();
ResultSet rs = null;
try {
rs=st4.executeQuery();
while(rs.next()) {
Subject subject = new Subject();
subject.setId(rs.getInt("ID"));
subject.setNameOfSubject(rs.getString("NAME_OF_SUBJECT"));
list.add(subject);
}
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
	try {
		if(rs!=null) {
			rs.close();
		}
	} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
}
}
return list;
}

public Subject getNameSubject(Subject subject) throws DaoException{
	ResultSet rs = null;
	try {
	st5.setInt(1, subject.getId());
	rs=st5.executeQuery();
	rs.next();
	subject.setNameOfSubject(rs.getString("NAME_OF_SUBJECT"));
	} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
	try {
		if(rs!=null) {
			rs.close();
		}
	} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
}
} return subject;
}
	

@Override

public  void close() throws  DaoException {
try {
st1.close();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
try{
st2.close();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
try {
st3.close();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
try {
st4.close();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
} finally {
try {
connection.close();
} catch(SQLException e) {
throw new DaoException(e.getMessage(), e);
}
}
}
}
}
}
}


