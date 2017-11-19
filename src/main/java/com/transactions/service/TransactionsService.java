package com.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transactions.domain.Transaction;
import com.transactions.repository.Repository;

/**
 * Transaction service
 * @author csponchiado
 *
 */
@Component
public class TransactionsService {
	
	/**
	 * Repository to save transactions
	 */
	@Autowired 
	private Repository<Transaction> repository;
	
	/**
	 * Add transactions to repository
	 * @param transaction
	 */
	public void addTransaction(Transaction transaction) {
		repository.add(transaction);
	}
}
