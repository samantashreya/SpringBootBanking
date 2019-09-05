package com.cg.bank.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "transactions12")
public class Transactions {
    @Id
    @SequenceGenerator(name = "txn", sequenceName = "txn_seq",initialValue=2001,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "txn")
    private int transactionId;
    @Column(name="acc")
    private int accountNumber;
    private double balance;
    private double credit;
    private double debit;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	@Override
	public String toString() {
		return "TransactionDetails [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", balance="
				+ balance + ", credit=" + credit + ", debit=" + debit + "]";
	}
   
    
    

 

}