package spring.entities; 

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="list")
public class ListOfAnswers {
	
@Id  
@Column(name="id_list")
@GeneratedValue(strategy=GenerationType.IDENTITY)  
private int id;

@Column(name="number_of_answer")

private int numberOfAnswer;

@ManyToOne (cascade=CascadeType.ALL)
@JoinColumn (name="id_vote", updatable=false)
Vote idVote;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}

 public void setNumberOfAnswer(int numberOfAnswer) {
this.numberOfAnswer=numberOfAnswer;
}
public int getNumberOfAnswer() {
return numberOfAnswer;

}
public void setIdVote(Vote idVote ) {
this.idVote = idVote;
} 
public Vote getIdVOte() {
return idVote;
}
public ListOfAnswers() {
}


}
