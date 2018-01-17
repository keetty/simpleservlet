package spring.dto; 

import javax.persistence.*;

@Entity
@Table(name="marks")

public class Mark {
	
@Id
@Column(name="M_ID")  
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;


@ManyToOne (cascade=CascadeType.ALL)
@JoinColumn (name="STUDENT_SUBJECT_ID")
 
private Cord studentSubjectId;


@Column(name="MARKS")  

private Integer mark;


public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}
public void setStudentSubjectId(Cord studentSubjectId ) {
this.studentSubjectId = studentSubjectId;
} 
public Cord getStudentSubjectId() {
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
