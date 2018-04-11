package spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan("spring.entities")
public class TestConfig {

	
	@Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        if (emf.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return emf.unwrap(SessionFactory.class);
    }

@Bean
public CreateVotingDao createDao() {
return new CreateVotingDao();
}
}