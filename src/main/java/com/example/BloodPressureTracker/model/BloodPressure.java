package com.example.BloodPressureTracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BloodPressure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bloodpressureid;
	private String datethis;
	private int systolic;
	private int diastolic;
	private int pulse;
	
    @ManyToOne
    @JoinColumn(name = "id")
	private User user;

	public BloodPressure() {
	}

	public BloodPressure(String datethis, int systolic, int diastolic, int pulse, User user) {
		super();
		this.datethis = datethis;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse = pulse;
		this.user = user;
	}



	public Long getBloodpressureid() {
		return bloodpressureid;
	}

	public void setBloodpressureid(Long bloodpressureid) {
		this.bloodpressureid = bloodpressureid;
	}

	public String getDatethis() {
		return datethis;
	}

	public void setDatethis(String datethis) {
		this.datethis = datethis;
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
	
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BloodPressure [bloodpressureid=" + bloodpressureid + ", datethis=" + datethis + ", systolic=" + systolic
				+ ", diastolic=" + diastolic + ", pulse=" + pulse + ", user=" + user + "]";
	}
}
