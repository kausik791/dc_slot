package com.wall.dc_slot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.wall.dc_slot.exception.DcSlotAlreadyExistsException;
import com.wall.dc_slot.model.Dc_Slot;
import com.wall.dc_slot.repository.Dc_SlotRepository;


class Dc_SlotServiceTest {

	@InjectMocks
	private Dc_SlotService dc_SlotService;
	
	@Mock
	private Dc_SlotRepository repository;
		
	
	  @BeforeEach public void setup()
	  { MockitoAnnotations.initMocks(this); }
	 
		
	  @ParameterizedTest
	  @MethodSource("parmsOfDc_SlotTest")
		void addDc_SlotTest(Dc_Slot slot ) {
						
			Mockito.when(repository.save(Mockito.any())).thenReturn(slot);
			if(slot.getDC_number() == 1)
			Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.empty());
			if(slot.getDC_number() == 2) {
				Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(slot));	
				assertThrows(DcSlotAlreadyExistsException.class , ()->dc_SlotService.addDc_Slot(slot));
				return;
			}
			
			    
			Dc_Slot result =null;
			try {
				result = dc_SlotService.addDc_Slot(slot);
			} catch (DcSlotAlreadyExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  assertNotNull(result); 
			  assertEquals(slot.getDC_number(),result.getDC_number()); 
			  assertEquals(slot.getDC_timeslots(),result.getDC_timeslots());
			  
			  assertEquals(slot,result);
			  
		
		}
	  
	  
	 static Stream<Arguments> parmsOfDc_SlotTest(){
		 return Stream.of(
					Arguments.of( new Dc_Slot(1, "test")),
					Arguments.of( new Dc_Slot(2, "test"))
					);
	  }
	}
