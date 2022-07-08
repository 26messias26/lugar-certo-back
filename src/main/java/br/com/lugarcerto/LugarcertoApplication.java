package br.com.lugarcerto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


//@EntityScan(basePackages = "br.com.lugarcerto.model")
@SpringBootApplication
public class LugarcertoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LugarcertoApplication.class, args);
	}

}
