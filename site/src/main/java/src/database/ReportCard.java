package src.database; 
import java.sql.*; 
import java.util.*; 


public class ReportCard { 
private Integer id;
private int stId; 
private int subId; 
private String firstName; 
private String secondName; 
private String nameOfSubject; 
private int mark; 


public void setId(Integer id ) { 
this.id = id; 
} 
public Integer  getId() { 
return id; 
} 

public void setStudentId(int stId ) { 
this.stId = stId; 
} 
public int getStudentId() { 
return stId; 
} 
public void setSubjectId(int subId ) { 
this.subId = subId; 
} 
public int getSubjectId() { 
return subId; 
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
public void setNameOfSubject(String nameOfSubject ) { 
this.nameOfSubject = nameOfSubject; 
} 
public String getNameOfSubject() { 
return nameOfSubject; 
} 
public void setMarks(int mark ) { 
this.mark = mark; 
} 
public int getMarks() { 
return mark; 
} 

public ReportCard() { 
this.setNameOfSubject(nameOfSubject); 
this.setMarks(mark); 

} 

public String toString() { 
return nameOfSubject + String.valueOf(mark); 
} 
}