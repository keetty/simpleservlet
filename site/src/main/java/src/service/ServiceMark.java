package src.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import javax.annotation.PreDestroy;
import src.database.*;
import src.dao.*;
import src.dto.*;
import java.util.*;
import java.sql.*;
import org.springframework.context.annotation.ScopedProxyMode;
import javax.annotation.PostConstruct;


public class ServiceMark {
	
	
	private DaoMark dm;
	
	
	private DaoListOfMarks dl;
	 
	 @Autowired
	ServiceMark() throws DaoException, SQLException {
	  
    this.dm=dm;
	this.dl=dl;

  }
   @PostConstruct
  public void init() throws DaoException, SQLException {
	  dm= new DaoMark();
	  dl = new DaoListOfMarks();
  }
	

	public Mark add(Mark mark) throws DaoException {
		 return dm.add(mark);
	}
	public void update(Mark mark) throws DaoException{
		dm.update(mark);
	}
	public void delete(Mark mark)throws DaoException {
		dm.delete(mark);
	}
	

	public List<ReportCard> getAllMarks(Student student) throws DaoException{
	return dl.getAllMarks(student);
	}
	
	public int selectOneMark(Mark mark) throws DaoException {
		return dm.selectOneMark(mark);
	}
	
	public int getStudentSubjectId(Student student, Subject subject) throws DaoException {
		return dm.getStudentSubjectId(student, subject);
	}
	
	
	@PreDestroy
	public void closeDaoMark() throws DaoException{
	
	dm.close();
	}
	
	@PreDestroy 
	
	public void closeDao() throws DaoException {
		dl.close();
	}
}