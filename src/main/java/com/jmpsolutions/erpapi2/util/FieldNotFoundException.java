package com.jmpsolutions.erpapi2.util;

/**
 * Custom Exception class for 'field not found' error/s.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
public class FieldNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FieldNotFoundException(String field) {
		super("Invalid field: " + field);
	}
}