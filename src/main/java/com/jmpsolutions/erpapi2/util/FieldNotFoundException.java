package com.jmpsolutions.erpapi2.util;

public class FieldNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FieldNotFoundException(String field) {
		super("Invalid field: " + field);
	}
}