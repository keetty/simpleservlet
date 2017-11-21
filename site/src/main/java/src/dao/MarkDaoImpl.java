package src.dao; 
import src.database;
import src.dto;
import java.sql.*;
import java.util.Map;
public interface MarkDaoImpl {
public Mark add(Mark mark) throws  DaoException;
public void update(Mark mark) throws  DaoException;
public void delete(Mark mark) throws  DaoException;
public void close() throws  DaoException;
}