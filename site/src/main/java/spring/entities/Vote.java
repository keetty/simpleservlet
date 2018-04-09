package spring.entities; 

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="vote")
public class Vote {
	
@Id  
@GeneratedValue(strategy=GenerationType.IDENTITY)  
private Integer id;

private String name;

private String question;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}

public void setName(String name) {
this.name=name;
}
public String getName() {
return name;

}
 public void setQuestion(String question) {
this.question=question;
}
public String getQuestion() {
return question;

}
public Vote() {
}
public String toString() {
return name +  "       "   + question;

}

}
