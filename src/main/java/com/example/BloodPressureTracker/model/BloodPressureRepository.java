package com.example.BloodPressureTracker.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BloodPressureRepository extends CrudRepository<BloodPressure, Long> {

	List<BloodPressure> findBySystolic(int systolic);

}
