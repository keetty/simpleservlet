package spring.dto; 


public class ListMark {
	
private Integer M_ID;
 
private String NAME_OF_SUBJECT;

private Integer MARKS;


public void setId(Integer M_ID ) {
this.M_ID = M_ID;
} 
public Integer getId() {
return M_ID;
}
public void setNameOfSubject(String NAME_OF_SUBJECT ) {
this.NAME_OF_SUBJECT = NAME_OF_SUBJECT;
} 
public String getNameOfSubject() {
return NAME_OF_SUBJECT;
}
public void setMark(int MARKS ) {
this.MARKS = MARKS;
} 
public int getMark() {
return MARKS;
}
public ListMark() {
}
public String toString() {
 return NAME_OF_SUBJECT  + " " +  String.valueOf(MARKS);
}
}
