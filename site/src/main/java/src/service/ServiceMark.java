package src.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import src.database.*;
import src.dao.*;
import src.dto.*;
import java.util.*;
import java.sql.*;

@Service
@Scope("session")

public class ServiceMark {
	
	
	private DaoMark dm;
	
	private DaoListOfMarks dl;
	
	@Autowired 
	
	ServiceMark() throws DaoException, SQLException{
		dm=new DaoMark();
		dl=new DaoListOfMarks();
	}
	
	public Mark addMark(Mark mark) throws DaoException {
		 return dm.add(mark);
	}
	public void updateMark(Mark mark) throws DaoException{
		dm.update(mark);
	}
	public void deleteMark(Mark mark)throws DaoException {
		dm.delete(mark);
	}
	

	public List<ReportCard> getAllMarks(Student student) {
	dl.getAllMarks(student);
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