package com.example.BloodPressureTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodPressure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int systolic;
	private int diastolic;
	private int pulse;

	public BloodPressure() {
		super();
	}

	public BloodPressure(int systolic, int diastolic, int pulse) {
		super();
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse = pulse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

}
