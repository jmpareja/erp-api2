package com.jmpsolutions.erpapi2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmpsolutions.erpapi2.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
