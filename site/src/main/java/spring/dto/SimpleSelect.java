package spring.database;
import java.sql.*; 
public class SimpleSelect {
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
private void MyDatabase() {
try {
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/student_db";
String login = "root";
String password = "IVANpozd2707";
Connection con = DriverManager.getConnection(url, login, password);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM student");
while (rs.next()) {
String str = rs.getString(3);
System.out.println(str);
}
} catch (ClassNotFoundException e) {
System.out.println("Не найден драйвер для доступа к бд   "    +       e.getMessage());  
} catch (SQLException e) {
System.out.println( " Ошибка срединения   "       + e.getMessage());
}  finally {
if(rs!=null){
try {
rs.close();
} catch(SQLException e) {
System.out.println( e.getMessage());
}
} if(stmt!=null) {
try {
stmt.close();
} catch(SQLException e) {
System.out.println( e.getMessage());
}
} if(con!=null) {
try {
con.close();
} catch(SQLException e) {
System.out.println(" Соединение не закрыто   "  + e.getMessage());
}
}
}
}
public static void main(String[] args) {
SimpleSelect s = new SimpleSelect();
s.MyDatabase();
}
}