package com.cg.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.bean.AccountDetails;
import com.cg.bank.bean.Transactions;
import com.cg.bank.dao.BankDao;
import com.cg.bank.dao.TransactionDao;

@Service
public class BankServiceImpl implements BankService{
	@Autowired
	BankDao bankDao;
	@Autowired
	TransactionDao transactionDao; 
	@Override
	public void createAccount(AccountDetails account) {
		Transactions transaction=new Transactions();
		transaction.setAccountNumber(account.getAccountNumber());
		transaction.setDebit(0);
		transaction.setCredit(account.getAmount());
		transaction.setBalance(account.getAmount());
		bankDao.save(account);
		transactionDao.save(transaction);
		
	}

	@Override
	public List<AccountDetails> showAllAccounts() {
		
		return bankDao.findAll();
	}

	@Override
	public AccountDetails getAccountDetails(int accountNumber) {
		
		return bankDao.findById(accountNumber).get();
	}

	@Override
	public AccountDetails showBalance(int accountNumber) {
		AccountDetails account=bankDao.findById(accountNumber).get();
		
        return account;
	}

	@Override
	public AccountDetails depositAmount(int accountNumber, AccountDetails account) {
		Optional<AccountDetails> optional=bankDao.findById(accountNumber);
		Transactions transaction=new Transactions();
		AccountDetails depositAccount=optional.get();
		transaction.setAccountNumber(depositAccount.getAccountNumber());
		transaction.setDebit(0);
		transaction.setCredit(account.getAmount());
		double balance=depositAccount.getAmount()+account.getAmount();
		transaction.setBalance(balance);
		depositAccount.setAmount(balance);
		bankDao.save(depositAccount);
		transactionDao.save(transaction);
		return depositAccount;
		}

	@Override
	public AccountDetails withdrawAmount(int accountNumber, AccountDetails account) {
		Optional<AccountDetails> optional=bankDao.findById(accountNumber);
		Transactions transaction=new Transactions();
		AccountDetails withdrawAccount=optional.get();
		transaction.setAccountNumber(withdrawAccount.getAccountNumber());
		transaction.setDebit(account.getAmount());
		transaction.setCredit(0);
		double balance=withdrawAccount.getAmount()-account.getAmount();
		transaction.setBalance(balance);
		withdrawAccount.setAmount(balance);
		bankDao.save(withdrawAccount);
		transactionDao.save(transaction);
		return withdrawAccount;
	}

	@Override
	public AccountDetails fundTransfer(int senderAccountNumber, int recieverAccountNumber, AccountDetails account) {
		withdrawAmount(senderAccountNumber, account);
		depositAmount(recieverAccountNumber, account);
		return showBalance(senderAccountNumber);
	}

	@Override
	public boolean validateAccount(int accountNumber) {
		Optional<AccountDetails> optional=bankDao.findById(accountNumber);
		if(optional.isPresent())
				return true;
			else
				return false;
}

	@Override
	public List<Transactions> getTransactionsByAccountNumber(int accountNumber) {
		return transactionDao.getTransactionsByAccountNumber(accountNumber);
	}

	

	

}
