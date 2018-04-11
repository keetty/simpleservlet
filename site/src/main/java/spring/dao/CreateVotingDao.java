package spring.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.transform.Transformers;
import spring.entities.*;
import spring.dto.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;


@Repository("votingDao")
public class CreateVotingDao {

@Autowired

private SessionFactory sessionFactory;

 private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


public void  createNewVote(Vote vote) {
	getSession().save(vote);

}

public void createNewAnswers( Answers answers) {
getSession().save(answers);
}

public void addNewAnswer(ListOfAnswers list) {
getSession().save(list);
}


public void createNewState(State state) {
getSession().save(state);
}

public void updateState(State state) {
getSession().update(state);
}

public void addStatistic(Statistic statistic) {
getSession().save(statistic);
}
public List<Vote> getListVotes()  {
		//Using HQL
        Query query = getSession().createQuery("FROM Vote");
		List<Vote> list= query.list();
        return list;
	}
public List<ListOfVariants> getListAnswers(int key)  {
		//Using simple dto java-object "ListOfVariants" for displaying of results of the query
        Query query = getSession().createSQLQuery("SELECT title, number FROM Answers WHERE vote_id= :par").setResultTransformer(Transformers.aliasToBean(ListOfVariants.class));
		query.setParameter("par", key);
		List<ListOfVariants> list= query.list();
		return list;
	}
public Vote getVote(int id) {
Vote vote=(Vote)getSession().get(Vote.class, id);
	return vote;
}

public List<Integer> getAnswer(int key) {
	//Using HQL
	Vote vote=new Vote();
	vote.setId(key);
		Query query = getSession().createQuery("SELECT numberOfAnswer FROM ListOfAnswers WHERE idVote= :par");
		query.setParameter("par", vote);
		List<Integer> list= query.list();
    return list;
}

public Integer getId(int key) {
	Vote vote=new Vote();
	vote.setId(key);
		Query query = getSession().createQuery("SELECT id  FROM State WHERE voteId= :par");
		query.setParameter("par", vote);
	return (Integer)query.uniqueResult();

}
public String getStateOfVoteId(int key) {
	//Using HQL
	Vote vote=new Vote();
	vote.setId(key);
		Query query = getSession().createQuery("SELECT state FROM State WHERE voteId= :par");
		query.setParameter("par", vote);
	return (String)query.uniqueResult(); 
	}	

public List<StatisticForUser> getListStatistic(int key)  {
		//Using simple dto java-object "StatisticForUser" for displaying of results of the query
        Query query = getSession().createSQLQuery("SELECT number, title, quantity FROM Statistic WHERE vote_id= :par").setResultTransformer(Transformers.aliasToBean(StatisticForUser.class));
		query.setParameter("par", key);
		List<StatisticForUser> list= query.list();
        return list;
	}
	
}
