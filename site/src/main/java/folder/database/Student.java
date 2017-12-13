package folder.database; 
import org.springframework.stereotype.Component;


public class Student {

private String firstName="Ivanov";
private String secondName="Ivan";



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
this.firstName=firstName;
this.secondName=secondName;
System.out.println("Bean created");
}
public String toString() {
 return firstName     +
  secondName;
}
}

