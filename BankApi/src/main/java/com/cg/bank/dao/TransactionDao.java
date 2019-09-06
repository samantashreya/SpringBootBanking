package com.cg.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bank.bean.Transactions;


@Repository
public interface TransactionDao extends JpaRepository<Transactions, Integer>{
	@Query("from Transactions where acc =:acc")
	  public List<Transactions> getTransactionsByAccountNumber(@Param("acc") int accountNumber);
	 
	 

}