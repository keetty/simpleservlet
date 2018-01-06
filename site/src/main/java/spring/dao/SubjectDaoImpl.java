package spring.dao; 
import spring.database.*;
import spring.dto.*;
import java.sql.*;
import java.util.List;

public interface SubjectDaoImpl {
public Subject add(Subject subject) throws DaoException;
public void update(Subject subject) throws DaoException;
public void delete(Subject subject) throws DaoException;
public List<Subject> getAllSubjects() throws DaoException;
public void close() throws DaoException;
}