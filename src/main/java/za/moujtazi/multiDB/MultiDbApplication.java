package za.moujtazi.multiDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.moujtazi.multiDB.database.dto.wiki_data;
import za.moujtazi.multiDB.database.service.MyService;

import java.util.List;

@SpringBootApplication
public class MultiDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDbApplication.class, args);
	}



}
