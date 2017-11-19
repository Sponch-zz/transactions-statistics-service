package com.transactions.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.transactions.domain.Statistics;
import com.transactions.domain.Transaction;

/**
 * Statistic service
 * @author csponchiado
 *
 */
@Component()
public class StatisticsService implements CallbackService<List<Transaction>>{
	
	/**
	 * Current statistic of transactions in the last configurated minutes
	 */
	private Statistics statistics = new Statistics();

	/**
	 * Get current statistics
	 * @return statistic
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * Receive as a callback one list of transactions to calculate statistics
	 */
	@Override
	public void callback(List<Transaction> transactions) {
		if(transactions.size() == 0) {
			updateStatistics(new Statistics());
		} else {
			Double max = Double.MIN_VALUE;
			Double min = Double.MAX_VALUE;
			Double sum = 0d;
			Long count = 0L;
			for(Transaction t : transactions) {
				if(t.getAmount() > max) {
					max = t.getAmount();
				}
				if(t.getAmount() < min) {
					min = t.getAmount();
				}
				sum += t.getAmount();
				count++;
			}
			Double avg = Double.valueOf(sum/ count);
			updateStatistics(new Statistics(sum, avg , max, min, count));
		}
	}
	
	/**
	 * Update the current statistics with the new one
	 * @param statistics
	 */
	private void updateStatistics(Statistics statistics) {
		synchronized (statistics) {	
			this.statistics = statistics;
		}
	}
}
