package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bank.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
