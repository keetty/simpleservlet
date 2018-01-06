package spring.dto; 

public class Mark {
private Integer id;
private Integer studentId;
private Integer subjectId;
private Integer studentSubjectId;
int mark;


public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
public void setStudentId(Integer studentId ) {
this.studentId = studentId;
} 
public Integer getStudentId() {
return studentId;
}
public void setSubjectId(Integer subjectId ) {
this.subjectId = subjectId;
} 
public Integer getSubjectId() {
return subjectId;
}
public void setStudentSubjectId(Integer studentSubjectId ) {
this.studentSubjectId = studentSubjectId;
} 
public Integer getStudentSubjectId() {
return studentSubjectId;
}
public void setMark(int mark ) {
this.mark = mark;
} 
public int getMark() {
return mark;
}
public Mark() {
}
public String toString() {
 return String.valueOf(mark);
}
}
