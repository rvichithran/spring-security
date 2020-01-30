package learn.spring.security.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringSecurityH2dbApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityH2dbApplication.class, args);
	}
}
