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
import org.hibernate.transform.Transformers;


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
        session.merge(mark);
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
	

	public List<ListMark> getAllMarks(Integer i) {
	Session session = sessionFactory.openSession();
		Query query;
		List<ListMark> list=new ArrayList<ListMark>();
		try {
			
		String qu="SELECT M_ID, NAME_OF_SUBJECT, MARKS FROM STUDENTS as S JOIN STUDENTS_SUBJECTS as T on S.ID=T.STUDENTS_ID JOIN SUBJECTS as U on U.S_ID=T.SUBJECTS_ID JOIN MARKS as M on T.SS_ID=M.STUDENT_SUBJECT_ID  WHERE S.ID= :stID  ORDER BY U.S_ID ";
        query=session.createSQLQuery(qu).setResultTransformer(Transformers.aliasToBean(ListMark.class));
		query.setParameter("stID", i);
		list=query.list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
        
		return list;
	}
		
	}
	
	
	
	
	
