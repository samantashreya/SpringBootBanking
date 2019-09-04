package com.cg.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transaction;
import com.cg.bank.exception.MyBankException;
import com.cg.bank.service.CustomerService;

@RestController
@RequestMapping("/bank")
public class BankingController {
	@Autowired

	private CustomerService custService;
	@GetMapping("/transaction/{custId}") 
	public List<Transaction> getTransactionsById(@PathVariable int custId) throws MyBankException {
		return custService.getAllTransactionById(custId);
	}
	@PostMapping("/customer")
	public int addCustomer(@RequestBody Customer customer) throws MyBankException{
		return custService.addCustomer(customer);
	}
	@GetMapping("/showBalance/{custId}")
	public Customer getBalance(@PathVariable int custId) throws MyBankException{
		return custService.getCustomerBalance(custId);
	}
	@PutMapping("/deposit/{custId}/{amount}")
	public Customer depositAmount(@PathVariable int custId,@PathVariable double amount ) throws MyBankException {
		return custService.deposit(custId, amount);
	}
	
	@PutMapping("/withdraw/{custId}/{amount}")
	public Customer withdrawAmount(@PathVariable int custId,@PathVariable double amount) throws MyBankException {
		return custService.withdraw(custId, amount);
	}
	
	@PutMapping("/transfer/{sourceCustId}/{destCustId}/{amount}")
	public Customer fundTransfer(@PathVariable int sourceCustId,@PathVariable int destCustId,double amount) throws MyBankException{
		return custService.transferFund(sourceCustId, destCustId, amount);
	}
}
