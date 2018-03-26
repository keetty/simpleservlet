package spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
 import  org.springframework.beans.factory.annotation.Autowired;
 import spring.dto.Vote;
 import spring.service.ServiceVoting;


@RestController
@RequestMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VotingController {

@Autowired
ServiceVoting serviceVoting;


 @RequestMapping(value="/start", method = RequestMethod.POST)
    public Vote createVote()  {
		return serviceVoting.createVoting();	
	}
	@RequestMapping(value="start/{activity}", method = RequestMethod.GET)
	public void start(@PathVariable("activity") boolean activity) {
		//The beginning of voting if input condition is true(for example, pressing of the button)
		if(activity) {
	    serviceVoting.startVoting(activity);
		} else {
			//The closing of voting when a input condition is false(we pressed button "finish voting)
        System.out.println("The voiting"   +   serviceVoting.getNameOfVote()   +      "has closed");
		System.out.println("You can look at statistic");
	    serviceVoting.closeVoting(activity);			
	}
	}
	
	
	@RequestMapping(value="start/add/{numberOfVariant}", method = RequestMethod.POST)
	public void addVoice(@PathVariable("numberOfVariant") int numberOfVariant) {
		serviceVoting.addVoice(numberOfVariant);
	}

}