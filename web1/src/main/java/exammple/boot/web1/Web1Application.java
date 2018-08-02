package exammple.boot.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Web1Application {
	public HelloController helloController() {
		return new HelloController();
	}

	public static void main(String[] args) {
		SpringApplication.run(Web1Application.class, args);
	}
}
