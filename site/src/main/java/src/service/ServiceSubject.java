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

@Service
@Scope("session")

public class ServiceSubject {
	
	private SubjectDao sd;
	
	
	@Autowired 
	ServiceSubject() throws DaoException, SQLException{
		sd=new SubjectDao();
		
	}
	
	public Subject addSubject(Subject subject) throws DaoException {
		 return sd.add(subject);
	}
	public void updateSubject(Subject subject) throws DaoException{
		sd.update(subject);
	}
	public void deleteSubject(Subject subject)throws DaoException {
		sd.delete(subject);
	}
	
	public List<Subject> ListSubjects() throws DaoException {
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