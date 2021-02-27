package com.jmpsolutions.erpapi2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmpsolutions.erpapi2.entity.Address;
import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.AddressRepository;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner loadDbFromFile(EmployeeRepository empRepository, AddressRepository addrRepository) {
		Resource resData = new ClassPathResource("static/employee.json");
		String strJson = getFileContents(resData);
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		objectMapper.setDateFormat(sdf);
		try {
			List<Employee> lstEmployee = objectMapper.readValue(strJson, new TypeReference<List<Employee>>() {});
			log.info("Size of list: " + lstEmployee.size());
			lstEmployee.forEach(employee -> {
				Address address = employee.getAddress();
				if (address != null) {
					addrRepository.save(employee.getAddress());
				}
				empRepository.save(employee);
			});
		} catch (Exception e) {
			log.error(e.getMessage());;
		}
		return args -> {
			log.info("Finished loading data."); 
		};
		
	}
	
	private String getFileContents(Resource res) {
		String resData = StringUtils.EMPTY;
        try {
        	InputStream inputStream = res.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            resData = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("IOException", e);
        }
        
        return resData;
	}
}
