package src.dao; 
import src.database.*;
import src.dto.*;
import java.sql.*;
import java.util.List;
public interface StudentDaoImpl {
public Student add(Student student) throws  DaoException;
public void update(Student student) throws  DaoException;
public void delete(Student student) throws  DaoException;
public List<Student> getAllStudents() throws  DaoException;
public void close() throws  DaoException;
}