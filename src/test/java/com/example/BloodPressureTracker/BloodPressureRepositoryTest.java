package com.example.BloodPressureTracker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.BloodPressureTracker.model.BloodPressure;
import com.example.BloodPressureTracker.model.BloodPressureRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BloodPressureRepositoryTest {
	
	@Autowired
	private BloodPressureRepository repository;
	
	@Test
	public void findBloodPressure() {
		List<BloodPressure> bloodPressure = repository.findBySystolic(120);
		assertThat(bloodPressure).hasSize(1);
		assertThat(bloodPressure.get(0).getDiastolic()).isEqualTo(80);
	}
	
	@Test
	public void createNewBloodPressure() {
		BloodPressure newBloodPressure = new BloodPressure(150, 96, 102);
		repository.save(newBloodPressure);
		assertThat(newBloodPressure.getId()).isNotNull();
	}
	
	@Test
	public void deleteBloodPressure() {
		
	}
}
