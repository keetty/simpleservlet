package spring.showing; 

import java.util.*;

public class ShowVote {

private int id;

private String name;

private String question;

private Map<Integer, String> variants;

private String state;

private Map<Integer, Integer> map;


public void setId(int id ) {
this.id = id;
} 
public int getId() {
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
public void setMapVariants(Map<Integer, String> variants) {
this.variants=variants;
}
public Map<Integer, String> getMapVariants() {
return variants;
}

public void setState(String state) {
this.state = state;
} 
public String getState() {
return state;
}
public void setMap(Map<Integer, Integer> map) {
this.map=map;
}
public Map<Integer, Integer> getMap() {
return map;
}
public ShowVote() {
}


}
