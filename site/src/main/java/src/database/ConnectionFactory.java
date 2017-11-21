package src.database; 
import java.sql.*;

public class ConnectionFactory  {
 private String url = "jdbc:mysql://localhost:3306/test";
 private String login = "root";
 private String password = "IVANpozd2707";
 private String nameOfDriver = "com.mysql.jdbc.Driver";
public ConnectionFactory() {
try {
Class.forName(nameOfDriver);
} catch(ClassNotFoundException e) {
System.out.println("Не найден драйвер для доступа к бд"    +    e.getMessage());
}  
}
public Connection getConnection() throws SQLException {
return DriverManager.getConnection(url, login, password);
}
}