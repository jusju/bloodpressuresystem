package com.example.BloodPressureTracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.BloodPressureTracker.web.BloodPressureController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BloodPressureTrackerApplicationTests {
	
	@Autowired
	private BloodPressureController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
