package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import spring.dto.*;
import spring.entities.*;
import java.util.*;
import spring.dao.*;
import spring.showing.Voice;
import spring.showing.ShowVote;

@Service("voting")

public class ServiceVoting {

@Autowired
CreateVotingDao createVotingDao;

@Transactional(rollbackFor = ValidationException.class, propagation = Propagation.REQUIRED)
public ShowVote createVoting(String nameOfVote, String question, String[] variants) throws ValidationException {
	
	ShowVote showVote = new ShowVote();
	
	
	//Validation
	
	if(nameOfVote=="" || question=="" || variants.length<2) {
		showVote.setState("Check in input data");
	} else {
		
	//Create new object Vote and save in the table Vote
	Vote vote=new Vote();
		vote.setName(nameOfVote);
		vote.setQuestion(question);
	createVotingDao.createNewVote(vote);
	
	//Write in fields of the ShowVote class
	showVote.setId(vote.getId());
	showVote.setName(vote.getName());
	showVote.setQuestion(vote.getQuestion());
	Map<Integer, String> var= new HashMap();
	
	//Create new object Answers and save in the table Answers which is related to Vote table

	for(int i=0; i<variants.length; i++ ) {
		//Validation of variants of answer
		if(variants[i].isEmpty()) {
			throw new ValidationException("The input data must not be empty");
		} else {
		Answers answers = new Answers();
		answers.setNumber(i+1);
		answers.setTitle(variants[i]);
		answers.setVoteId(vote);
	createVotingDao.createNewAnswers(answers);
	
	//Write in Map of variants for the ShowVote class
	var.put(i+1, variants[i]);
	}
	}
	showVote.setMapVariants(var);
	
	//Create new object State which can get to 3 values: "inactive"(when Vote has created, but not active), "active"(when users can vote), "closed"(when ysers cannot have voted already
	//This object is related to Vote object
	State state = new State();
		state.setState("inactive");
		state.setVoteId(vote);
	createVotingDao.createNewState(state);
	//Write in state field of the ShowVote class
	showVote.setState(state.getState());
			
	}
	
	return showVote;
	
}

//Changing of state from "inactive" to "active" for beginning of the vote or from "active" to "closed" for finishing vote
@Transactional
public void changeStateOfVoting(String activity, int id) {
	
	State state=new State();
		Vote vote=new Vote();
		vote.setId(id);
	state.setId(createVotingDao.getId(id));
	state.setState(activity);
		createVotingDao.updateState(state);
	}
	
//Select all information about certain vote
public ShowVote showVote(int id) {
	
	ShowVote showVote=new ShowVote();
	Vote vote=createVotingDao.getVote(id);
		showVote.setId(vote.getId());
		showVote.setName(vote.getName());
		showVote.setQuestion(vote.getQuestion());
		Map<Integer, String> variants=new HashMap();
		List<ListOfVariants> list=createVotingDao.getListAnswers(id);
			for(ListOfVariants variant : list) {
			variants.put(variant.getNumber(),variant.getTitle());
		}
		showVote.setMapVariants(variants);
			if(createVotingDao.getStateOfVoteId(id).equals("active")) {
		showVote.setState("The vote is active");
		} else if(createVotingDao.getStateOfVoteId(id).equals("closed")) {
		 showVote.setState("The vote has closed. ou can see statistic");	
		 Map<Integer, Integer> mapOfStatistic=new HashMap();
		List<StatisticForUser> statistic=createVotingDao.getListStatistic(id);
			for(StatisticForUser stat : statistic) {
		mapOfStatistic.put(stat.getNumber(), stat.getQuantity());
		}
		showVote.setMap(mapOfStatistic);
		
		}
		return showVote;
}
		
@Transactional
public Voice addVoice(int id, String numberOfVariant) {
	Voice voice = new Voice();
	//Validation
	if(numberOfVariant.isEmpty()) {
			voice.setMessage("You must choose one variant of answer");
		} else {
	ListOfAnswers list=new ListOfAnswers();
		if(createVotingDao.getStateOfVoteId(id).equals("active")) {
	//Add new entry to the table ListOfAnswers
	list.setNumberOfAnswer(Integer.valueOf(numberOfVariant));
	Vote vote=createVotingDao.getVote(id);
	list.setIdVote(vote);
	createVotingDao.addNewAnswer(list);
	voice.setQuestion(vote.getQuestion());
	voice.setNumber(list.getNumberOfAnswer());
	voice.setMessage("Your voice is got");
	} else if(createVotingDao.getStateOfVoteId(id).equals("inactive")) {
	voice.setMessage("You must begin vote");
	} else if(createVotingDao.getStateOfVoteId(id).equals("closed")) {
	voice.setMessage("Vote has closed");
	}
		}
	return voice;
}


@Transactional
public void addStatistic(int id) {
	//Get the lists of answers and variants of answers
	List<ListOfVariants> list=createVotingDao.getListAnswers(id);
	List<Integer> list1=createVotingDao.getAnswer(id);
	
	//Look for the same values of answers in the ListOfAnswers table
	for(ListOfVariants variants : list) {
		List<Integer> statisticList=new ArrayList();
		for(Integer i : list1) {
			if(i==variants.getNumber()) {
				statisticList.add(i);
			}
			
		} 
		//Add results of count into the statistic table
		Statistic statistic = new Statistic();
			statistic.setNumber(variants.getNumber());
			statistic.setTitle(variants.getTitle());
			statistic.setQuantity(statisticList.size());
			statistic.setVoteId(id);
		createVotingDao.addStatistic(statistic);
}
}
			
}