package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PreDestroy;
import spring.database.*;
import spring.dto.*;
import java.util.*;
import java.sql.*;
import org.springframework.context.annotation.ScopedProxyMode;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.ScrollMode;


@Repository("mark")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class ServiceMark {
	
	 @Autowired
	private SessionFactory sessionFactory;
	
	
public void add(Mark mark) {
	Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {	
	transaction= session.beginTransaction();
        session.save(mark);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
    throw  e;
} finally {
	
        session.close();
}
	}
	public void update(Mark mark) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {
transaction= session.beginTransaction();
        session.update(mark);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
	throw e;
} finally {
        session.close();
	}
	}
	public void delete(Mark mark) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		try {
			transaction= session.beginTransaction();
        session.delete(mark);
        transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			
        session.close();
	}
	}
	

	public List<Map<Subject, Mark>> getAllMarks(Student student) {
	Session session = sessionFactory.openSession();
		SQLQuery query;
		ScrollableResults results=null;
		List<Map<Subject, Mark>> list=new ArrayList<Map<Subject,Mark>>();
		Map<Subject,Mark> map = new HashMap<Subject, Mark>();
		try {
			
		String qu="SELECT M.ID, NAME_OF_SUBJECT, MARKS FROM STUDENTS as S JOIN STUDENTS_SUBJECTS as T on S.ID=T.STUDENTS_ID JOIN SUBJECTS as U on U.ID=T.SUBJECTS_ID JOIN MARKS as M on T.ID=M.STUDENTS_SUBJECTS_ID  WHERE S.ID= :stID  ORDER BY U.ID ";
        query=session.createSQLQuery(qu).addEntity(Mark.class);
		query.setFetchSize(Integer.MIN_VALUE);
        results = query.scroll(ScrollMode.FORWARD_ONLY);
		query.setParameter("stID", student.getId());
		while (results.next()) {
			Mark mark = new Mark();
			Subject subject = new Subject();
			mark.setId(results.getInteger(1));
			subject.setNameOfSubject(results.getString(2));
			mark.setMark(results.getInteger(3));
			map.put(subject, mark);
			list.add(map);
		}
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(results!=null) {
				try {
					results.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			session.close();
		}
        
		return list;
	}
		
	}
	
	
	
	
	
}