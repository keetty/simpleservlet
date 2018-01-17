package spring.dto; 

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="students")


public class Student {
	
@Id
@Column(name="ID") 
@GeneratedValue(strategy=GenerationType.IDENTITY) 
 private Integer id;

@Column(name="FIRST_NAME")  
 private String firstName;

@Column(name="SECOND_NAME")  
private String secondName;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
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

