package io.mtech.jpa.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaRestApplication.class, args);
	}

}
