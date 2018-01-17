package spring.dto; 

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="subjects")

public class Subject {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
@Column(name="S_ID")	
private Integer id;

@Column(name="NAME_OF_SUBJECT")  
private String nameOfSubject;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
public void setNameOfSubject(String nameOfSubject ) {
this.nameOfSubject = nameOfSubject;
} 
public String getNameOfSubject() {
return nameOfSubject;
}
public Subject() {
}
public String toString() {
return    nameOfSubject;
}
}

