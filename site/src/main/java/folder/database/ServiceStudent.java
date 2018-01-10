package folder.database;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
 
 @Service
 public class ServiceStudent {

 
  public void addStudent(Student student) {
	  
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
	}