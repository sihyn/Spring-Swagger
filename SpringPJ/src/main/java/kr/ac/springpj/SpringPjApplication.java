package kr.ac.springpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringPjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPjApplication.class, args);
	}

}
