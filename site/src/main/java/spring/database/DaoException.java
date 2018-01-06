package spring.database; 
import java.sql.*;
public class DaoException extends Exception {
private String message;
private Throwable e;
public DaoException() {
}
public DaoException(String message) {
super(message);
}
public DaoException(String message, Throwable e ) {
super(message, e);
}
public DaoException(Throwable e) {
super(e);
}
} 