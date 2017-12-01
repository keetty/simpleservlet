package src.dao; 
import src.database;
import src.dto;
import java.sql.*; 
import java.util.*; 
import src.database.*; 
import org.springframework.stereotype.Repository;

@Repository

public class DaoMark implements MarkDaoImpl {  
private static final String SELECT = "SELECT ID FROM STUDENTS_SUBJECTS WHERE STUDENTS_ID=? AND SUBJECTS_ID=?";
private static final String CREATE_MARK="INSERT INTO MARKS" + "(STUDENTS_SUBJECTS_ID,  MARKS) VALUES" 
+ "(?,?)"; 
private static final String UPDATE_MARK="UPDATE MARKS SET MARKS=? WHERE ID=?"; 
private static final String DELETE_MARK="DELETE FROM MARKS WHERE ID=?"; 
private static final String SELECT_MARK = "SELECT MARKS FROM MARKS WHERE ID=?";
private  Connection connection; 
private  PreparedStatement ssid;
private  PreparedStatement insert; 
private  PreparedStatement update; 
private  PreparedStatement delete; 
private  PreparedStatement selectMark; 

public DaoMark() throws SQLException, DaoException { 
try { 
ConnectionFactory cf = new ConnectionFactory(); 
connection=cf.getConnection(); 
ssid=connection.prepareStatement(SELECT);
insert=connection.prepareStatement(CREATE_MARK); 
update=connection.prepareStatement(UPDATE_MARK); 
delete=connection.prepareStatement(DELETE_MARK); 
selectMark=connection.prepareStatement(SELECT_MARK); 
} catch(SQLException e) { 
throw new DaoException(" Cannot create the daoObject ", e); 
} 
} 

public int getStudentSubjectId(Student student, Subject subject) {
	ResultSet rs=null; 
	try {
		
		ssid.setInt(1,student.getId());
		ssid.setInt(2,subject.getId());
		rs=ssid.executeQuery();
		rs.next();
		student.setSsid(rs.getInt("ID"));
	} catch(SQLException e) { 
	e.printStackTrace();
new DaoException(" Error", e); 
} finally { 
try { 
if(rs!=null) { 
rs.close(); 
} 
} catch(SQLException e) { 
new DaoException(" Closing error", e); 
} 
} 
 return student.getSsid();
}  

public int selectOneMark(Mark mark) throws DaoException { 
ResultSet rs = null;
try {  
selectMark.setInt(1, mark.getId()); 
rs=selectMark.executeQuery();
rs.next();
mark.setMark(rs.getInt("MARKS"));
} catch(SQLException e) { 
throw new DaoException(" Cannot update the mark ", e); 
} finally { 
try { 
if(rs!=null) { 
rs.close(); 
} 
} catch(SQLException e) { 
new DaoException(" Closing error", e); 
} 
}
return mark.getMark();
}


@Override

public Mark add(Mark mark) throws DaoException { 
try {
insert.setInt(1, mark.getStudentSubjectId()); 
insert.setInt(2, mark.getMark()); 
insert.executeUpdate();
} catch(SQLException e) { 
throw new DaoException(" Cannot create the mark ", e); 
} 
return mark; 
}  
  
@Override

public void update(Mark mark) throws DaoException { 

try {  
update.setInt(1, mark.getMark());
update.setInt(2, mark.getId()); 
update.executeUpdate();
} catch(SQLException e) { 
throw new DaoException(" Cannot update the mark ", e); 
} 
}

@Override

public void delete(Mark mark) throws DaoException { 
try { 
delete.setInt(1, mark.getId()); 
delete.executeUpdate();
} catch(SQLException e) { 
throw new DaoException(" Cannot delete the mark ", e); 
} 
}







@Override

public void close() throws DaoException { 
DaoException ex=null;

try {
if(ssid!=null) {
ssid.close();
}
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
}  
try { 
if(insert!=null) { 
insert.close(); 
} 
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
} 
try { 
if(update!=null) { 
update.close(); 
} 
} catch(SQLException e) { 
ex = new DaoException( " Closing error", e); 
} 
try { 
if(delete!=null) { 
delete.close(); 
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
} if(ex!=null) { 
throw ex; 
} 
} 
}