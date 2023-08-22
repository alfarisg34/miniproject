package RegistrationLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
// @EnableConfigurationProperties
// @EntityScan(basePackages = {"RegistrationLogin.Entity"})  // force scan JPA entities
public class RegisterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterLoginApplication.class, args);
	}

}
