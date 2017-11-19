package com.transactions.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.transactions.ApplicationConfiguration;
import com.transactions.domain.Transaction;
import com.transactions.service.CallbackService;

import builder.TransactionBuilder;

@RunWith(SpringRunner.class)
public class TransactionRepositoryTest {

	  @Mock
	  private CallbackService<List<Transaction>> callback;
	  
	  @Mock
	  private ApplicationConfiguration configuration;
	  
	  @InjectMocks
	  TransactionsRepository transactionsRepository = new TransactionsRepository();
	  
	  @Before
	  public void setUp() {
	      Mockito.when(configuration.getTimeFrame()).thenReturn(2);
	  }
	  
	  
	  @Test
	  public void shouldMaintainTransction_whenTimeIsLessThan60Secounds() throws InterruptedException {
		  List<Transaction> list = TransactionBuilder.generateTransactions(2);
		  for(Transaction t : list) {
			  transactionsRepository.add(t);
		  }
		  Assert.assertEquals(1, transactionsRepository.get().size());
		  Thread.sleep(1100);
		  Assert.assertEquals(2, transactionsRepository.get().size());
		  Thread.sleep(1100);
		  Assert.assertEquals(1, transactionsRepository.get().size());
		  Thread.sleep(1100);
		  Assert.assertEquals(0, transactionsRepository.get().size());
	  }
}
