package com.jmpsolutions.erpapi2;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmpsolutions.erpapi2.entity.Address;
import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.AddressRepository;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;
import com.jmpsolutions.erpapi2.util.ErpApiUtil;

/**
 * Spring configuration that loads json file to H2 database.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	/**
	 * Loads JSON file to H2 database.
	 * This is executed by spring framework after application is loaded.
	 * 
	 * @param empRepository Employee repository injected by spring framework
	 * @param addrRepository Address repository injected by spring framework
	 * @return the command line arguments
	 */
	@Bean
	CommandLineRunner loadDbFromFile(EmployeeRepository empRepository, AddressRepository addrRepository) {
		Resource resData = new ClassPathResource("static/employee.json");
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		objectMapper.setDateFormat(sdf);
		try {
			String strJson = ErpApiUtil.getFileContents(resData);
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
}
