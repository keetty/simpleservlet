package spring.entities; 

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="answers")
public class Answers {
	
@Id  
@Column(name="id_answers")
@GeneratedValue(strategy=GenerationType.IDENTITY)  
private int id;

private String title;

private int number;

@ManyToOne (cascade=CascadeType.ALL)
@JoinColumn (name="vote_id", updatable=false)
Vote voteId;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}

public void setTitle(String title) {
this.title=title;
}
public String getTitle() {
return title;

}
 public void setNumber(int number) {
this.number=number;
}
public int getNumber() {
return number;

}
public void setVoteId(Vote voteId ) {
this.voteId = voteId;
} 
public Vote getVoteId() {
return voteId;
}
public Answers() {
}


}
