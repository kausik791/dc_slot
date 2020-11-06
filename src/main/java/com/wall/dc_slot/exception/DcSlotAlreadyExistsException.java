package com.wall.dc_slot.exception;

public class DcSlotAlreadyExistsException extends Exception {

	String message;

	public DcSlotAlreadyExistsException(String message) {
		super(message);
		this.message = message;

	}

}
