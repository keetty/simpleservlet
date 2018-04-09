package spring.entities; 

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="statistic")
public class Statistic {
	
@Id  
@Column(name="id_statistic")
@GeneratedValue(strategy=GenerationType.IDENTITY)  
private int id;

@Column(name="number")
private int numberOfQuestion;

@Column(name="title")
private String title;

@Column(name="quantity")
private int quantityOfAnswers;

@Column(name="vote_id")
int  voteId;


public void setId(int id ) {
this.id = id;
} 
public int getId() {
return id;
}

public void setVoteId(int voteId) {
this.voteId = voteId;
} 
public int getVoteId() {
return voteId;
}
public void setNumber(int numberOfQuestion) {
this.numberOfQuestion = numberOfQuestion;
} 
public int getNumber() {
return numberOfQuestion;
}

public void setTitle(String title) {
this.title=title;
}
public String getTitle() {
return title;

}
public void setQuantity(int  quantityOfAnswers) {
this.quantityOfAnswers = quantityOfAnswers;
} 
public int getQuantity() {
return quantityOfAnswers;
}
public Statistic() {
}


}
