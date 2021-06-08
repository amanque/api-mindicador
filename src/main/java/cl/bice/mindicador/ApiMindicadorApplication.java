package cl.bice.mindicador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class ApiMindicadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMindicadorApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {return new RestTemplate();}

}
