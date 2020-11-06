package com.wall.dc_slot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wall.dc_slot.exception.DcSlotAlreadyExistsException;
import com.wall.dc_slot.exception.DcSlotNotFoundException;
import com.wall.dc_slot.model.Dc_Slot;
import com.wall.dc_slot.repository.Dc_SlotRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Dc_SlotService {

	@Autowired
	private Dc_SlotRepository repository;

	public Dc_Slot addDc_Slot(Dc_Slot slot) throws DcSlotAlreadyExistsException {
		//log.info("Inside addDc_Slot()......");

		if (repository.findById(slot.getDC_number()).isPresent()) {
			throw new DcSlotAlreadyExistsException("exceptionMsgForDcSlotAlreadyExists");
		}

		return repository.save(slot);

	}

	public Dc_Slot deleteDc_Slot(int dc_number) throws DcSlotNotFoundException {
		//log.info("Inside deleteDc_Slot()......");

		if (repository.findById(dc_number).isPresent()) {

			Dc_Slot slot = repository.findById(dc_number).get();
			repository.deleteById(dc_number);

			return slot;
		}

		throw new DcSlotNotFoundException("exceptionMsgForDcSlotNotFound");
	}

	public Dc_Slot searchDc_Slot(int id) throws DcSlotNotFoundException {
		//log.info("Inside searchDc_Slot()......");

		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		}

		throw new DcSlotNotFoundException("exceptionMsgForDcSlotNotFound");

	}

	public Dc_Slot updatehDc_Slot(Dc_Slot slot) {
		//log.info("Inside updatehDc_Slot()......");
		if (repository.findById(slot.getDC_number()).isPresent()) {
			Dc_Slot slot_db = repository.findById(slot.getDC_number()).get();
			slot_db.setDC_timeslots(slot.getDC_timeslots());
			return repository.save(slot_db);
		}
		return repository.save(slot);
	}

}
