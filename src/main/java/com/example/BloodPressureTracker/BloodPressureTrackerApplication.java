package com.example.BloodPressureTracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BloodPressureTracker.model.BloodPressure;
import com.example.BloodPressureTracker.model.BloodPressureRepository;
import com.example.BloodPressureTracker.model.User;
import com.example.BloodPressureTracker.model.UserRepository;

@SpringBootApplication
public class BloodPressureTrackerApplication {
	private static final Logger log = LoggerFactory.getLogger(BloodPressureTrackerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BloodPressureTrackerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bloodPressureDemo(BloodPressureRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("save blood pressure");
			repository.deleteAll();
			//urepository.deleteAll();
			
			repository.save(new BloodPressure("1.1.2021", 120, 80, 72));
			repository.save(new BloodPressure("2.1.2021", 135, 78, 81));
			repository.save(new BloodPressure("3.1.2021", 118, 93, 75));
			repository.save(new BloodPressure("4.1.2021", 140, 90, 63));
			
			// Test users user(user), admin(admin)
			User user1 = new User("user", "$2a$06$2FtjqzBuNoPOdVDmN.mep.1PeP8QZnKtk8FQGIvOVKqrO4M0nS2QC", "USER");
			User user2 = new User("admin", "$2a$06$RsWjb6Vvl5oI/7RvrnxfJuDxGC2aTF83UFypj5raWqBbKyAuSAhJ2", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);

			log.info("get blood pressure");
			for (BloodPressure book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
