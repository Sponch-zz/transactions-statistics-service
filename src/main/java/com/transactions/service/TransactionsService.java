package com.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transactions.domain.Transaction;
import com.transactions.repository.Repository;

@Component
public class TransactionsService {
	
	@Autowired 
	private Repository<Transaction> repository;
	
	public void addTransaction(Transaction transaction) {
		repository.add(transaction);
	}
}
