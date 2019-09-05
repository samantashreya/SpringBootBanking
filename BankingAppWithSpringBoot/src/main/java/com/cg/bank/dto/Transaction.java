package com.cg.bank.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionBoot")
public class Transaction {

	@Id
	@SequenceGenerator(name = "myseq", sequenceName = "emp_seq", initialValue = 8790, allocationSize = 7)
	@GeneratedValue(generator = "myseq", strategy = GenerationType.SEQUENCE)
	private int transId;
	private String transType;
	private Date transDate;
	private int sourceCustId;
	private int destinationCustId;
	private double amount;

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getSourceCustId() {
		return sourceCustId;
	}

	public void setSourceCustId(int sourceCustId) {
		this.sourceCustId = sourceCustId;
	}

	public int getDestinationCustId() {
		return destinationCustId;
	}

	public void setDestinationCustId(int destinationCustId) {
		this.destinationCustId = destinationCustId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
