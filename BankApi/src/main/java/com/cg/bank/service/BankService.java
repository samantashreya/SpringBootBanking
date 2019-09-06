package com.cg.bank.service;

import java.util.List;

import com.cg.bank.bean.Customer;
import com.cg.bank.bean.Transactions;

public interface BankService {
	public void createAccount(Customer account);
	public boolean validateAccount(int accountNumber);
	public List<Customer> showAllAccounts();
	public Customer getCustomer(int accountNumber);
	public Customer showBalance(int accountNumber);
	public Customer depositAmount(int accountNumber, Customer account);
	public Customer withdrawAmount(int accountNumber, Customer account);
	public Customer fundTransfer(int senderAccountNumber, int recieverAccountNumber, Customer account);
	public List<Transactions> getTransactionsByAccountNumber(int accountNumber);

}
