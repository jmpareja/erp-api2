package com.jmpsolutions.erpapi2.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import com.jmpsolutions.erpapi2.entity.Employee;

public final class ErpApiUtil {

	// Restrict instantiation
	private ErpApiUtil() {}
	
	public static final Comparator<Employee> getComparatorBasedOnField(String field) {
		
		Comparator<Employee> myComparator = null;
		switch(field) {
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_NAME:
				myComparator = Comparator.comparing(Employee::getName);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_JOINDATE:
				myComparator = Comparator.comparing(Employee::getJoindate);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_AGE:
				myComparator = Comparator.comparing(Employee::getAge);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_COMPANY:
				myComparator = Comparator.comparing(Employee::getCompany);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_EMAIL:
				myComparator = Comparator.comparing(Employee::getEmail);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_PHONE:
				myComparator = Comparator.comparing(Employee::getPhone);
				break;
			case ErpApiConstants.ERPAPI_FIELDNAME_STR_SALARY:
				myComparator = Comparator.comparing(Employee::getSalary);
				break;
			default:
				throw new FieldNotFoundException(field);
		}
		
		return myComparator;
	}
	
	/**
	 * Helper method that loads resource file into a String object.
	 * @param res Resource file object
	 * @return String object from file
	 */
	public static String getFileContents(Resource res) throws IOException {
		String resData = StringUtils.EMPTY;
        try {
        	InputStream inputStream = res.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            resData = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw exception;
        }
        
        return resData;
	}
}
