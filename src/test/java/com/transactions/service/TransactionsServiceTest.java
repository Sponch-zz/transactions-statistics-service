package com.transactions.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.transactions.domain.Transaction;
import com.transactions.repository.Repository;

@RunWith(SpringRunner.class)
public class TransactionsServiceTest {

	@Mock
	private Repository<Transaction> repository;

	@InjectMocks
	TransactionsService transactionsService = new TransactionsService();

	@Test
	public void shouldAddTransactionToRepository_whenReceiveOneTransaction() {
		Transaction transaction = new Transaction(10d, 1L);
		transactionsService.addTransaction(transaction);
		verify(repository, times(1)).add(transaction);
	}
}
