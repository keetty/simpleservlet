package spring.dto; 

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="students_subjects")


public class Cord {
@Id
@Column(name="SS_ID")  
@GeneratedValue(strategy=GenerationType.IDENTITY)  
private Integer id;

@Column(name="STUDENTS_ID")
private Integer student_id;

@Column(name="SUBJECTS_ID")  

private Integer subject_id;

@OneToMany(mappedBy = "mark")
private List<Mark> marks=new ArrayList<Mark>();

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
public void setStudentId(Integer student_id ) {
this.student_id = student_id;
} 
public Integer getStudentId() {
return student_id;
}
public void setSubjectId(Integer subject_id ) {
this.subject_id = subject_id;
} 
public Integer getSubjectId() {
return subject_id;
}
public void setMarks(List<Mark> marks) {
	this.marks=marks;
}
public List<Mark> getMarks() {
	return marks;
}
public Cord() { 
}
public String toString() {
 return String.valueOf(id);
}
}

