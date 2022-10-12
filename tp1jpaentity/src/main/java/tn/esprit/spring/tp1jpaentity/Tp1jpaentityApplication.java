package tn.esprit.spring.tp1jpaentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.spring.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.controllers","tn.esprit.spring.services"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.repositories"})
public class Tp1jpaentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1jpaentityApplication.class, args);
    }

}
