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



@Repository("students_subjects")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class ServiceStudentSubject {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setStudentsSubjectsId(Cord cord) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {
transaction	= session.beginTransaction();
		session.save(cord);
		transaction.commit();
} catch(Exception e) {
	transaction.rollback();
	throw e;
} finally {
        session.close();
       
	}
	}
	
	public List<Integer> getSubjectsId(int key)  {
		Session session = sessionFactory.openSession();
		Query query;
		List<Integer> list=null;
		try {
        query = session.createQuery("SELECT subject_id FROM Cord WHERE student_id= :par");
		query.setParameter("par", key);
		list=query.list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
        return list;
	}
	
	public int getStudentSubjectId(int key1, int key2) {
		Session session = sessionFactory.openSession();
		Query query;
		int i;
		try {
		String qu="SELECT id FROM Cord WHERE student_id= :stId AND subject_id= :sbId";
        query=session.createQuery(qu);
		query.setParameter("stId", key1);
		query.setParameter("sbId", key2);
		i=(int)query.uniqueResult();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
        return i;
		
	}
	}