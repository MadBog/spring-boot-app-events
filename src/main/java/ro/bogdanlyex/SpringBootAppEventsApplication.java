package ro.bogdanlyex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootAppEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppEventsApplication.class, args);
	}
}
