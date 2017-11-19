package com.transactions.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.transactions.domain.Statistics;
import com.transactions.domain.Transaction;

import builder.TransactionBuilder;

public class StatisticsServiceTest {

	private StatisticsService service = new StatisticsService();
	
	@Test
	public void shoudShowEmptyStatistics_whenNoTransaction() {
		Statistics statistic = service.getStatistics();
		assertValues(statistic, 0d, 0d, 0d, 0d, 0L); 
	}
	
	@Test
	public void shoudShowEmptyStatistics_whenRemovedAllTransaction() {
		service.callback(new ArrayList<>());
		Statistics statistic = service.getStatistics();
		assertValues(statistic, 0d, 0d, 0d, 0d, 0L); 
	}
	
	@Test
	public void shoudShowCorrectValues_whenTransaction() {
		List<Transaction> transactions = TransactionBuilder.generateTransactions(3);
		service.callback(transactions);
		Statistics statistic = service.getStatistics();
		assertValues(statistic, 60d, 20d, 30d, 10d, 3L); 
	}
	
	@Test
	public void shoudShowCorrectValues_whenTransactionInvertedTransactions() {
		List<Transaction> transactions = TransactionBuilder.generateTransactions(3);
		transactions.sort((Transaction t1, Transaction t2) -> t2.getAmount().compareTo(t1.getAmount()));
		service.callback(transactions);
		Statistics statistic = service.getStatistics();
		assertValues(statistic, 60d, 20d, 30d, 10d, 3L); 
	}
	
	private void assertValues(Statistics statistic, Double sum, Double avg, Double max, Double min, Long count) {
		Assert.assertEquals(avg, statistic.getAvg());
		Assert.assertEquals(max, statistic.getMax());
		Assert.assertEquals(min, statistic.getMin());
		Assert.assertEquals(sum, statistic.getSum());
		Assert.assertEquals(count, statistic.getCount());
	}
}
