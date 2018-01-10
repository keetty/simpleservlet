package folder.database;
 
 
import java.io.File; 
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
 public class HibernateUtil {
    private static  SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry  serviceRegistry;
    private static  SessionFactory buildSessionFactory() {
        try {
                sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
		return sessionFactory;
	}        
	 public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}