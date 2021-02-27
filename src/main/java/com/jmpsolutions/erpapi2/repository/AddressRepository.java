package com.jmpsolutions.erpapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmpsolutions.erpapi2.entity.Address;

/**
 * Interface for Address repository.
 * 
 * @author jmpareja
 * @since 2021/02/27
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
