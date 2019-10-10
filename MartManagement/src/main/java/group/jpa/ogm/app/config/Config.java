package group.jpa.ogm.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan("group.jpa.ogm.app")
public class Config {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MartDB");

    @Bean
    public EntityManager entityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
