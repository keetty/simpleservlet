package src.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import src.dao.*;
import src.dto.*;
import java.util.*;

@Service
@Scope("session")

public class ServiceStudent {
	
	private StudentDao sd;
	
	
	@Autowired 
	public Service() throws DaoException, SQLException{
		sd=new StudentDao();
		
	}
	
	public Student addStudent(Student student) throws DaoException {
		 return sd.add(student);
	}
	public void updateStudent(Student student) throws DaoException{
		sd.update(student);
	}
	public void deleteStudent(Student student)throws DaoException {
		sd.delete(student);
	}
	public void setStudentSubjectId(Student student, Subject subject) throws DaoException {
		sd.setStudentsSubjectsId(student, subject);
	}
	public List<Student> ListStudents() throws DaoException {
		return sd.getAllStudents();
	}
	public List<Integer> getSubjectsId() throws DaoException {
		return sd.getSubjectsId();
	}
	
	@PreDestroy 
	
	public void closeDao() throws DaoException {
		sd.close();
	}
}
		
	