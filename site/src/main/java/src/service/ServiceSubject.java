package src.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import src.dao.*;
import src.database.*;
import src.dto.*;
import java.util.*;
import java.sql.*; 
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.ScopedProxyMode;




public class ServiceSubject {
	
	
	
	private SubjectDao sd;
	@Autowired
	ServiceSubject() throws DaoException, SQLException{
	  
    this.sd=sd;
  }
  
   @PostConstruct
  public void init() throws DaoException, SQLException  {
	  sd = new SubjectDao();
  }
	
	
	public Subject add(Subject subject) throws DaoException {
		 return sd.add(subject);
	}
	public void update(Subject subject) throws DaoException{
		sd.update(subject);
	}
	public void delete(Subject subject)throws DaoException {
		sd.delete(subject);
	}
	
	public List<Subject> getListSubjects() throws DaoException {
		return sd.getAllSubjects();
	}
	public Subject getNameSubject(Subject subject) throws DaoException {
		return sd.getNameSubject(subject);
	}
	
	@PreDestroy 
	
	public void closeDao() throws DaoException {
		sd.close();
	}
}