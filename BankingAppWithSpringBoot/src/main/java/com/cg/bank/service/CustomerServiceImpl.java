package com.cg.bank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dao.CustomerRepository;
import com.cg.bank.dao.TransactionRepository;
import com.cg.bank.dto.Customer;
import com.cg.bank.dto.Transaction;
import com.cg.bank.exception.MyBankException;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custDao;
	@Autowired
	private TransactionRepository transactionDao;
	Transaction transaction = new Transaction();

	@Override
	public int addCustomer(Customer customer) throws MyBankException {
		int custId = (int) (Math.random()*10000);
		customer.setCustId(custId);
		custDao.save(customer);
		return custId;
	}

	@Override
	public Customer getCustomerBalance(int custId) throws MyBankException {
		
		 try {
	           
	            Optional<Customer> data = custDao.findById(custId);
	           
	            if(data.isPresent()) {
	            	Customer customer = data.get();
	                return customer;
	            }
	            else {
	                throw new MyBankException("Employee with id" +custId+ "dos not exist");
	            }
	           
	        } catch (Exception e) {
	           
	            throw new MyBankException(e.getMessage());
	        }
		
	}

	@Override
	public Customer deposit(int sourceCustId,double amount) throws MyBankException {
		

		 try {
	           double updatedAmount=0.0;
	            Optional<Customer> data = custDao.findById(sourceCustId);
	           
	            if(data.isPresent()) {
	            	Customer customer = data.get();
	            	updatedAmount= customer.getBalance()+amount;
	            	customer.setBalance(updatedAmount);
	            	custDao.save(customer);
	            	transaction.setTransType("Credit");
	            	Date transDate = new Date();
	        		transaction.setTransDate(transDate);
	        		transaction.setCustId(sourceCustId);
	        		transaction.setAmount(amount);
	        		transactionDao.save(transaction);
	                 return customer;
	            }
	            else {
	                throw new MyBankException("Employee with id" +sourceCustId+ "dos not exist");
	            }
	           
	        } catch (Exception e) {
	           
	            throw new MyBankException(e.getMessage());
	        }
	}

	@Override
	public Customer withdraw(int sourceCustId,double amount) throws MyBankException {
		 try {
	           double updatedAmount=0.0;
	            Optional<Customer> data = custDao.findById(sourceCustId);
	           
	            if(data.isPresent()) {
	            	Customer customer = data.get();
	            	updatedAmount= customer.getBalance()-amount;
	            	customer.setBalance(updatedAmount);
	            	custDao.save(customer);
	            	transaction.setTransType("Debit");
	            	Date transDate = new Date();
	        		transaction.setTransDate(transDate);
	        		transaction.setCustId(sourceCustId);
	        		transaction.setAmount(amount);
	        		transactionDao.save(transaction);
	                 return customer;
	            }
	            else {
	                throw new MyBankException("Employee with id" +sourceCustId+ "dos not exist");
	            }
	           
	        } catch (Exception e) {
	           
	            throw new MyBankException(e.getMessage());
	        }
	}

	@Override
	public Customer transferFund(int sourceCustId, int destCustId, double amount) throws MyBankException {
		
		try {
	           double updatedAmountAtSource=0.0;
	            Optional<Customer> datAtSource = custDao.findById(sourceCustId);
	           
	            if(datAtSource.isPresent()) {
	            	Customer sourceCustomer = datAtSource.get();
	            	updatedAmountAtSource= sourceCustomer.getBalance()-amount;
	            	sourceCustomer.setBalance(updatedAmountAtSource);
	            	custDao.save(sourceCustomer);
	            	transaction.setTransType("debit");
	            	Date transDate = new Date();
	        		transaction.setTransDate(transDate);
	        		transaction.setCustId(sourceCustId);
	        		transaction.setAmount(amount);
	        		transactionDao.save(transaction);
	         
	            }
	            else {
	                throw new MyBankException("Employee with id" +sourceCustId+ "dos not exist");
	            }
	            
	            double updatedAmountAtDest=0.0;
	            Optional<Customer> dataAtDest = custDao.findById(sourceCustId);
	           
	            if(dataAtDest.isPresent()) {
	            	Customer customer = dataAtDest.get();
	            	updatedAmountAtDest= customer.getBalance()+amount;
	            	customer.setBalance(updatedAmountAtDest);
	            	transaction.setTransType("debit");
	            	Date transDate = new Date();
	        		transaction.setTransDate(transDate);
	        		transaction.setCustId(sourceCustId);
	        		transaction.setAmount(amount);
	        		transactionDao.save(transaction);
	            	return customer;
	            	
	            }
	            else {
	                throw new MyBankException("Employee with id" +sourceCustId+ "dos not exist");
	            }
	           
	        } catch (Exception e) {
	           
	            throw new MyBankException(e.getMessage());
	        }
	}

	@Override
	public List<Transaction> getAllTransactionById(int custId) throws MyBankException {
		List<Transaction> transList= new ArrayList<>();
		Transaction transaction = new Transaction();
		if(transactionDao.existsById(custId)){
			
			transList=transactionDao.getTransactionsByCustId(custId);
			
		}
		else {
			throw new MyBankException("Invalid customer!!!");
		}

		return transList;
	}

}
