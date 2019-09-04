package com.cg.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bank.dto.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query("from Transaction where custId =:custId")
	  public List<Transaction> getTransactionsByCustId(@Param("custId") int custId);
	  
}
