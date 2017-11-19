package com.transactions.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that is generated if timestamp of transaction is older than time frame
 * @author csponchiado
 *
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class OldTransactionException extends Exception {

	private static final long serialVersionUID = -6743425426346243687L;

	public OldTransactionException() {
		super();
	}
}
