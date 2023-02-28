package top.lemcoo.chainresponsibility;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChainResponsibilityPatternApplication {

	@Bean
	public CustomerProcessor customerProcessor() {
		return new CustomerProcessor();
	}

	public static void main(String[] args) {
		SpringApplication.run(ChainResponsibilityPatternApplication.class, args);
	}

}
