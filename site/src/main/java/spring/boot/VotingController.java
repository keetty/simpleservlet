package spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import  org.springframework.beans.factory.annotation.Autowired;
import spring.dto.*;
import spring.service.*;
import java.util.*;
import spring.showing.*;


@RestController
@RequestMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VotingController {

@Autowired
ServiceVoting serviceVoting;


    @RequestMapping(value="/start", method = RequestMethod.POST)
	@ResponseBody
	//Using dto object for showing information about just created vote in the JSON format
    public  ShowVote createVote(@RequestParam(value="nameOfVote") String nameOfVote,@RequestParam(value="question") String question, @RequestParam(value="variant") String[] variants)  throws ValidationException {
		 return   serviceVoting.createVoting(nameOfVote, question, variants);
	}
	
	
	@RequestMapping(value="/start", method = RequestMethod.PUT)
	public void changeStatusOfVote(@RequestParam(value="id") int id, @RequestParam(value="activity") String activity) {
		//If activity=active the voiting is working. if activity=closed the voiting is closed and vote is impossible
		serviceVoting.changeStateOfVoting(activity, id);
		if(activity.equals("closed")) {
			//When the vote has been closed we have to get a statistic
		serviceVoting.addStatistic(id);
		}
	}
	
	
	@RequestMapping(value="/start", method = RequestMethod.GET)
	@ResponseBody
	//Using dto object for showing information in the JSON format
	public ShowVote showVote(@RequestParam(value="id") int id) {
	return serviceVoting.showVote(id);	
	}
	
	@RequestMapping(value="start/add", method = RequestMethod.POST)
	@ResponseBody
	public Voice addVoice(@RequestParam(value="id") int id, @RequestParam(value="numberOfVariant") String numberOfVariant) {
		
		return serviceVoting.addVoice(id, numberOfVariant);
		
	}

}