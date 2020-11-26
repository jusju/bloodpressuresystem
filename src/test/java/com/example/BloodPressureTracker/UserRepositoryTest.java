package com.example.BloodPressureTracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.BloodPressureTracker.model.User;
import com.example.BloodPressureTracker.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;

	@Test
	public void CreateNewUser() {
		User user = new User("user name", "$2a$06$vRN/vQ4VW8p.L51PNJYvte0OOI51nXx/QSQHhHY0SCEwdLIuj89v6", "USER");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
}
