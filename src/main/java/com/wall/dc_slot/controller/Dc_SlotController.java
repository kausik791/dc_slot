package com.wall.dc_slot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wall.dc_slot.exception.DcSlotAlreadyExistsException;
import com.wall.dc_slot.exception.DcSlotNotFoundException;
import com.wall.dc_slot.model.Dc_Slot;
import com.wall.dc_slot.service.Dc_SlotService;

@Controller
@RequestMapping("/root/v1")
public class Dc_SlotController {
	
	private static final Logger logger = LoggerFactory.getLogger(Dc_SlotController.class);

	@Autowired
	private Dc_SlotService service;

	@PostMapping("/add-dc-slot")

	public ResponseEntity<Dc_Slot> addDc_Slot(@RequestBody Dc_Slot slot) throws DcSlotAlreadyExistsException {
		logger.info("Inside addDc_Slot method");
		return ResponseEntity.ok(service.addDc_Slot(slot));
	}

	@GetMapping("/getslot/{dc_number}")
	@ResponseBody
	public ResponseEntity<Dc_Slot> searchDc_Slot(@PathVariable("dc_number") int dc_number)	
			throws DcSlotNotFoundException {
		logger.info("Inside searchDc_Slot method");
		return ResponseEntity.ok(service.searchDc_Slot(dc_number));

	}

	@PutMapping("/update-dc-slot")
	@ResponseBody
	public ResponseEntity<Dc_Slot> updateDc_Slot(@RequestBody Dc_Slot slot) {
		logger.info("Inside updateDc_Slot method");
		return ResponseEntity.ok(service.updatehDc_Slot(slot));
	}

	@DeleteMapping("/delete-dc-slot/{dc_number}")
	@ResponseBody
	public ResponseEntity<Dc_Slot> deletDc_Slot(@PathVariable("dc_number") int dc_number) throws DcSlotNotFoundException {
		logger.info("deletDc_Slot");
		return ResponseEntity.ok(service.deleteDc_Slot(dc_number));
	}
}
