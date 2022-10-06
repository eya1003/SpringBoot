package tn.esprit.spring.tp1jpaentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.spring.entity"})
public class Tp1jpaentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1jpaentityApplication.class, args);
    }

}
