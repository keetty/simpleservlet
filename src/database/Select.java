package src.database;
import java.sql.*; 
import java.util.*;
import java.io.PrintWriter;

public class Select {
public static void main(String[] args) throws DaoException {
try {
Student s = new Student();
s.setFirstName("Иванов");
s.setSecondName("Иван");
StudentDao sd = new StudentDao();
sd.create(s);

} catch(SQLException e) {
throw new DaoException();
} catch(DaoException e) {
System.out.println(e.getMessage());
}
}
}