package com.cg.bank.service;

import java.util.List;

import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transaction;
import com.cg.bank.exception.MyBankException;

public interface CustomerService {
	
	int addCustomer(Customer customer) throws MyBankException;
	Customer getCustomerBalance(int custId) throws MyBankException;
	Customer deposit(int id,double amount) throws MyBankException;
	Customer withdraw(int sourceCustId,double amount) throws MyBankException;
	Customer transferFund(int sourceCustId,int destId,double amount) throws MyBankException;
	List<Transaction> getAllTransactionById(int custId) throws MyBankException;
	
}

