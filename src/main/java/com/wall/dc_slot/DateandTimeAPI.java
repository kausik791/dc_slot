package com.wall.dc_slot;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateandTimeAPI {
	public static void main(String[] args) {
		
		
		  LocalDateTime current = LocalDateTime.now(); 
		  System.out.println(current);
		 
		
	    	Calendar calendar = Calendar.getInstance();  
	      System.out.println("Current Date = " + calendar.getTime());
	      calendar.add(Calendar.HOUR_OF_DAY, +1);
	      System.out.println("Updated Date = " + calendar.getTime());
	
		
	}

}
