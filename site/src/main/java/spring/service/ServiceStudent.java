package spring.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PreDestroy;
import spring.dao.*;
import spring.database.*;
import spring.dto.*;
import java.util.*;
import java.sql.*; 
import org.springframework.context.annotation.ScopedProxyMode;



@Service("student")
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class ServiceStudent {
	
	@Autowired
	private StudentDao sd;

  
	
	public Student add(Student student) throws DaoException {
		 return sd.add(student);
	}
	public void update(Student student) throws DaoException{
		sd.update(student);
	}
	public void delete(Student student)throws DaoException {
		sd.delete(student);
	}
	public void setStudentsSubjectsId(Student student, Subject subject) throws DaoException {
		sd.setStudentsSubjectsId(student, subject);
	}
	public List<Student> getListStudents() throws DaoException {
		return sd.getAllStudents();
	}
	public List<Integer> getSubjectsId(int key) throws DaoException {
		return sd.getSubjectsId(key);
	}
	
	@PreDestroy 
	
	public void closeDao() throws DaoException {
		sd.close();
	}
}
		
	