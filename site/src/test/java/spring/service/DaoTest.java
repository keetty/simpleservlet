package spring.service;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import spring.dto.*;
import spring.entities.*;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=TestConfig.class)
@Transactional
public class DaoTest {


@Autowired
CreateVotingDao createVotingDao;	

private final int  id=24;

@Before
    public void setup()
    {

    }

@Test
public void checkInGetListOfAnswers() {
List<ListOfVariants> list=createVotingDao.getListAnswers(id);
Assert.assertEquals(1, list.size());
}
@Test
public void checkInGetVote() {
Vote vote=createVotingDao.getVote(id);
String name="egege";
Assert.assertEquals("egege", vote.getName());
}
@Test
public void checkInGetAnswer() {
List<Integer> list=createVotingDao.getAnswer(id);
Assert.assertEquals(1, list.size());
}

@Test
public void chekInGetId() {
int i=createVotingDao.getId(id);
Assert.assertEquals(1, i);

}
@Test
public void chekInGetStateOfVoteId() {
String state=createVotingDao.getStateOfVoteId(id);
String state1="inactive";
Assert.assertEquals(state1, state);
}
@Test
public void checkInGetListStatistic() {
List<StatisticForUser> list=createVotingDao.getListStatistic(id);
Assert.assertEquals(0, list.size());
}

}

































