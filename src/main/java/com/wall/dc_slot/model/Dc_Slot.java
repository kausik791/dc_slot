package com.wall.dc_slot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Dc_Slot {

	@Id
	private int DC_number;
	private String DC_timeslots;
	
	public int getDC_number() {
		return DC_number;
	}
	public void setDC_number(int dC_number) {
		DC_number = dC_number;
	}
	public String getDC_timeslots() {
		return DC_timeslots;
	}
	public void setDC_timeslots(String dC_timeslots) {
		DC_timeslots = dC_timeslots;
	}
	public Dc_Slot() {
	
	}
	public Dc_Slot(int dC_number, String dC_timeslots) {
	
		DC_number = dC_number;
		DC_timeslots = dC_timeslots;
	}
	
	
	
	

}
