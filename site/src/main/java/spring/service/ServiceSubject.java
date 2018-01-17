package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import spring.database.*;
import spring.dto.*;
import java.util.*;
import java.sql.*;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.ScopedProxyMode;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

@Repository("subject")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)


public class ServiceSubject {
	
	
	
	@Autowired
	
 private SessionFactory sessionFactory;
	
	
	public void add(Subject subject) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {	
	transaction= session.beginTransaction();
        session.save(subject);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
    throw  e;
} finally {
	
        session.close();
}
	
	}
	public void update(Subject subject) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {
transaction= session.beginTransaction();
        session.update(subject);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
	throw e;
} finally {
        session.close();
	}
	}
	public void delete(Subject subject) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		try {
			transaction= session.beginTransaction();
        session.delete(subject);
        transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			
        session.close();
	}
	}
	
	public List<Subject> getListSubjects()  {
		Session session = sessionFactory.openSession();
		Query query;
		List<Subject> list = null;
		try {
        query = session.createQuery("FROM Subject");
		list= query.list();
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
        return list;
	}
	public Subject getNameSubject(int id)  {
		Session session = sessionFactory.openSession();
		Subject subject;
		Transaction transaction=null; 
		try {
			transaction= session.beginTransaction();
        subject=(Subject)session.get(Subject.class, id);
        transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			
        session.close();
	}
		return subject;
        
	}
	
	
}