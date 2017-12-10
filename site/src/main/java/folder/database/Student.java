package folder.database; 
import org.springframework.stereotype.Component;

@Component
public class Student {

private String firstName = "Петров";
private String secondName="Иван";



public void setFirstName(String firstName ) {
this.firstName = firstName;
} 
public String getFirstName() {
return firstName;
}
public void setSecondName(String secondName ) {
this.secondName = secondName;
} 
public String getSecondName() {
return secondName;
}
public Student() { 
}
public String toString() {
 return firstName     +
  secondName;
}
}

