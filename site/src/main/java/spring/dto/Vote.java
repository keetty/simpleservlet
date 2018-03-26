package spring.dto; 


import com.fasterxml.jackson.annotation.*;
import org.springframework.stereotype.Component;
import java.util.*;


@Component("vote")
@JsonAutoDetect
public class Vote {


private boolean activity;

private String nameOfVote;

private String question;


private Map<Integer, String> variantsOfAnswer;

private List<Integer> listOfVoices;


public void setActivity(boolean avtivity) {
this.activity=activity;
}
public boolean getActivity() {
return activity;

}

public void setNameOfVote(String nameOfVote) {
this.nameOfVote=nameOfVote;
}
public String getNameOfVote() {
return nameOfVote;

}
 public void setQuestion(String question) {
this.question=question;
}
public String getQuestion() {
return question;

}
public void setVariantsOfAnswer(Map<Integer, String> variantsOfAnswer) {
this.variantsOfAnswer=variantsOfAnswer;
}
public Map<Integer, String> getVariantsOfAnswer() {
return variantsOfAnswer;

}


public void setListOfVoices(List<Integer> listOfVoices) {
this.listOfVoices=listOfVoices;
}
public List<Integer> getListOfVoices() {
return listOfVoices;

}
public Vote() {
this.setNameOfVote("Simple voting");
this.setQuestion("Some question");
Map<Integer, String> map=new HashMap();
map.put(1, "yes");
map.put(2, "no");
this.setVariantsOfAnswer(map);
List<Integer> list=new ArrayList();
this.setListOfVoices(list);

}
 
}