package com.transactions.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Transaction with amount and transaction time
 * 
 * @author csponchiado
 *
 */
public class Transaction {

	/**
	 * transaction amount
	 */
	private Double amount;

	/**
	 * transaction time in epoch in millis in UTC time zone (this is not current
	 * timestamp)
	 */
	private Long timestamp;

	@JsonCreator
	public Transaction(@JsonProperty("amount") Double amount, @JsonProperty("timestamp") Long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public Double getAmount() {
		return amount;
	}

	public Long getTimestamp() {
		return timestamp;
	}

}
