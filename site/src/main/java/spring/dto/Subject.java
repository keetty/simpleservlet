package spring.dto; 
public class Subject {
private Integer id;
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
this.setNameOfSubject(nameOfSubject);
}
public String toString() {
return    nameOfSubject;
}
}

