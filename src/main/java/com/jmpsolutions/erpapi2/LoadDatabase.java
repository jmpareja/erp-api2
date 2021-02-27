package com.jmpsolutions.erpapi2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jmpsolutions.erpapi2.entity.Address;
import com.jmpsolutions.erpapi2.entity.Employee;
import com.jmpsolutions.erpapi2.repository.AddressRepository;
import com.jmpsolutions.erpapi2.repository.EmployeeRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner loadDbFromFile(EmployeeRepository empRepository, AddressRepository addrRepository) {
		Address address1 = new Address("street1", "city1", "zipcode1");
		addrRepository.save(address1);
		Address address2 = new Address("street2", "city2", "zipcode2");
		addrRepository.save(address2);
		
		return args -> {
			log.info("Preloading " + empRepository.save(new Employee("joel", "2021-02-21", "42", "mycompany",
					"jmpareja@gmail.com", "myphone", "100", address1)));
			log.info("Preloading " + empRepository.save(new Employee("joel2", "2021-02-22", "42", "mycompany",
					"jmpareja@gmail.com", "myphone2", "101", address2)));
		};
	}
}
