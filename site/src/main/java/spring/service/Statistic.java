package spring.service; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.dto.*;
import java.util.*;

@Service("statistic")
public class Statistic {

@Autowired
Vote vote;

public int quantityOfVoicesByOneVariant(int variant) {
	List<Integer> list=new ArrayList();
	for(int i : vote.getListOfVoices()) {
		if(i==variant) {
			list.add(i);
		} 
	}
	
	return list.size();
}
 
}