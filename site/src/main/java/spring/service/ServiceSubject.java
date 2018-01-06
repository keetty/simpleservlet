package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.*;
import spring.database.*;
import spring.dto.*;
import java.util.*;
import java.sql.*;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.ScopedProxyMode;

@Service("subject")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)


public class ServiceSubject {
	
	
	
	@Autowired
	
  private SubjectDao sd;
	
	
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