package src.service; 

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import src.dao.*;
import src.dto.*;
import java.util.*;

@Service
@Scope("session")

public class ServiceMark {
	
	private DaoMark dm;
	private DaoListOfMarks dl;
	
	@Autowired 
	
	public Service() throws DaoException, SQLException{
		dm=new DaoMark();
		dl=new DaoListOfMarks();
	}
	
	public Subject addMark(Mark mark) throws DaoException {
		 return sd.add(mark);
	}
	public void updateMark(Mark mark) throws DaoException{
		sd.update(mark);
	}
	public void deleteMark(Mark mark)throws DaoException {
		sd.delete(mark);
	}
	

	public List<ReportCard> getAllMarks(Student student) {
	dl.getAllMarks(student);
	}
	
	@PreDestroy
	public void close DaoMark() throws DaoException{
	
	dm.close();
	}
	
	@PreDestroy 
	
	public void closeDao() throws DaoException {
		dl.close();
	}
}