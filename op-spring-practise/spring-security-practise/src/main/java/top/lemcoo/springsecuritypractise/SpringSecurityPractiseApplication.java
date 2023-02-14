package top.lemcoo.springsecuritypractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringSecurityPractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityPractiseApplication.class, args);
    }

}
