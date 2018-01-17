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



@Repository("student")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class ServiceStudent {
	
	@Autowired
	private SessionFactory sessionFactory;

  
	
	public void add(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {	
	transaction= session.beginTransaction();
        session.save(student);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
    throw  e;
} finally {
	
        session.close();
}
	}
	public void update(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
try {
transaction= session.beginTransaction();
        session.update(student);
        transaction.commit();
} catch(Exception e) {
	transaction.rollback();
	throw e;
} finally {
        session.close();
	}
	}
	public void delete(Student student) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		try {
			transaction= session.beginTransaction();
        session.delete(student);
        transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			
        session.close();
	}
	}
	
	public List<Student> getListStudents() {
		Session session = sessionFactory.openSession();
		Query query;
		List<Student> list=null;
		try {
        query = session.createQuery(  " FROM Student");
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
		