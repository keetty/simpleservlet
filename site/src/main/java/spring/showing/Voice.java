package spring.showing; 

import java.util.*;

public class Voice {

private String question;

private String message;

private int numberOfAnswer;


public void setQuestion(String question) {
this.question=question;
}
public String getQuestion() {
return question;
}

public void setNumber(int numberOfAnswer) {
this.numberOfAnswer = numberOfAnswer;
} 
public int getNumber() {
return numberOfAnswer;
}
public void setMessage(String message) {
this.message=message;
}
public String getMessage() {
return message;
}
public Voice() {
}


}
