package src.dto; 
public class Student {
private Integer id;
private String firstName;
private String secondName;
private int ssid;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
public void setSsid(int ssid ) {
this.ssid = ssid;
} 
public int getSsid() {
return ssid;
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

