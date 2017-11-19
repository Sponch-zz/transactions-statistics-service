package com.transactions.repository;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transactions.ApplicationConfiguration;
import com.transactions.domain.Transaction;
import com.transactions.service.CallbackService;
import com.transactions.util.TimeUtil;

/**
 * Repository of Transaction that is maintained for a period of time
 * 
 * @author csponchiado
 *
 */
@Component
public class TransactionsRepository implements Repository<Transaction> {

	/**
	 * List of transactions received
	 */
	private Queue<Transaction> queue = new ConcurrentLinkedQueue<>();

	/**
	 * Thead to clean old transactions
	 */
	private Thread cleanerThread = new Thread(new CleanerQueue());

	/**
	 * Callback to update statistics
	 */
	@Autowired
	private CallbackService<List<Transaction>> callback;

	/**
	 * Period of time that transaction can live in the list to calculate the
	 * statistics
	 */
	@Autowired
	private ApplicationConfiguration configuration;

	public TransactionsRepository() {
		cleanerThread.start();
	}

	@Override
	public void add(Transaction transaction) {
		queue.add(transaction);
	}

	/**
	 * Get transactions from the last X minutes, not considerate future timestamp
	 */
	public List<Transaction> get() {
		return queue.stream().filter(t -> t.getTimestamp() < TimeUtil.nowInMillis()).collect(Collectors.toList());
	}

	/**
	 * Remove old transactions after a period of time
	 */
	public void removeOldTransactions() {
		Long startTimeFrame = TimeUtil.getTimestampMinusSeconds(configuration.getTimeFrame());
		queue.stream().filter(t -> t.getTimestamp() < startTimeFrame).forEach(t -> queue.remove(t));
		callback.callback(get());
	}

	class CleanerQueue implements Runnable {
		@Override
		public void run() {
			while (true) {
				if (queue.size() > 0) {
					removeOldTransactions();
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					System.out.println("Error to clean list of transactions");
				}
			}
		}
	}
}
