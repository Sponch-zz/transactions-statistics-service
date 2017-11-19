package com.transactions.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.transactions.domain.Statistics;
import com.transactions.domain.Transaction;

@Component()
public class StatisticsService implements CallbackService<List<Transaction>>{
	
	private Statistics statistics = new Statistics();

	public Statistics getStatistics() {
		return statistics;
	}

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
	
	private void updateStatistics(Statistics statistics) {
		synchronized (statistics) {	
			this.statistics = statistics;
		}
	}
}
