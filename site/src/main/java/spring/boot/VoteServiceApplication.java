package spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@SpringBootApplication(scanBasePackages = "spring")
@EntityScan(basePackages = "spring.entities")
public class VoteServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(VoteServiceApplication.class, args);	
	}
	 @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        if (emf.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return emf.unwrap(SessionFactory.class);
    }
	
	 
}
