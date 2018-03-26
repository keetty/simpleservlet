package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.dto.*;
import java.util.*;

@Service("voting")

public class ServiceVoting {

@Autowired
Vote vote;

@Autowired
Statistic statistic;


public Vote createVoting() {
	return vote;
}
public String getNameOfVote() {
	return vote.getNameOfVote();
}


public void startVoting(boolean activity) {
	vote.setActivity(activity);
	System.out.println(vote.getNameOfVote());
	System.out.println(vote.getQuestion());
	System.out.println(vote.getVariantsOfAnswer());
	}
public void addVoice(int numberOfVariant) {
vote.getListOfVoices().add(numberOfVariant);
}

public void closeVoting(boolean activity) {
	int i;
	vote.setActivity(activity);
	for(i=1; i<=vote.getVariantsOfAnswer().size(); i++) {
		System.out.println(vote.getVariantsOfAnswer().get(i)+ statistic.quantityOfVoicesByOneVariant(i));
		
	}
	vote.getListOfVoices().clear();
}
}