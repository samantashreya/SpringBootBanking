package com.cg.bank.service;

import java.util.List;

import com.cg.bank.bean.AccountDetails;
import com.cg.bank.bean.Transactions;

public interface BankService {
	public void createAccount(AccountDetails account);
	public boolean validateAccount(int accountNumber);
	public List<AccountDetails> showAllAccounts();
	public AccountDetails getAccountDetails(int accountNumber);
	public AccountDetails showBalance(int accountNumber);
	public AccountDetails depositAmount(int accountNumber, AccountDetails account);
	public AccountDetails withdrawAmount(int accountNumber, AccountDetails account);
	public AccountDetails fundTransfer(int senderAccountNumber, int recieverAccountNumber, AccountDetails account);
	public List<Transactions> getTransactionsByAccountNumber(int accountNumber);

}
