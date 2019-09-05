package com.cg.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bank.bean.AccountDetails;
import com.cg.bank.bean.Transactions;
import com.cg.bank.service.BankService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BankController {
	@Autowired
	BankService bankService;
	
	@PostMapping
	public void createAccount(@RequestBody AccountDetails account) {
		bankService.createAccount(account);
	}
	
	@GetMapping
	public List<AccountDetails> showAccounts(){
		return bankService.showAllAccounts();
	}
	
	@GetMapping("/validate/{accountNumber}")
	public boolean depositAmount(@PathVariable("accountNumber") int accountNumber){
		return bankService.validateAccount(accountNumber);
	}
		
	@GetMapping("/{accountNumber}")
	public AccountDetails getAccount(@PathVariable("accountNumber") int accountNumber){
		return bankService.getAccountDetails(accountNumber);
	}
	@GetMapping("/balance/{accountNumber}")
	public AccountDetails showAccountBalance(@PathVariable("accountNumber") int accountNumber){
		return bankService.showBalance(accountNumber);
	}
	
	@PutMapping("/deposit/{accountNumber}")
	public AccountDetails depositAmount(@PathVariable("accountNumber") int accountNumber, @RequestBody AccountDetails account){
		return bankService.depositAmount(accountNumber,account);
	}
	
	@PutMapping("/withdraw/{accountNumber}")
	public AccountDetails withdrawAmount(@PathVariable("accountNumber") int accountNumber, @RequestBody AccountDetails account){
		return bankService.withdrawAmount(accountNumber,account);
	}
	
	@PutMapping("/transfer/{senderAccountNumber}/{recieverAccountNumber}")
	public AccountDetails fundTransfer(@PathVariable("senderAccountNumber") int senderAccountNumber, @PathVariable("recieverAccountNumber") int recieverAccountNumber, @RequestBody AccountDetails account){
		return bankService.fundTransfer(senderAccountNumber,recieverAccountNumber,account);
	}
	
	@GetMapping("/transactions/{accountNumber}")
    public List<Transactions> getTransactionsByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
        return bankService.getTransactionsByAccountNumber(accountNumber);
      
    }
 
	
}
