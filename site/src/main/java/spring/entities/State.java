package spring.entities; 

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="state_of_vote")
public class State {
	
@Id  
@GeneratedValue(strategy=GenerationType.IDENTITY) 
@Column(name="id_state") 
private int id;

@Column(name="state_of_vote")
private String state;

@ManyToOne (cascade=CascadeType.ALL)
@JoinColumn (name="id_voting", updatable=false)
private Vote voteId;

public void setId(Integer id ) {
this.id = id;
} 
public Integer getId() {
return id;
}

public void setState(String state) {
this.state = state;
} 
public String getState() {
return state;
}

public void setVoteId(Vote voteId) {
this.voteId = voteId;
} 
public Vote getVoteId() {
return voteId;
}

public State() {
}

}
