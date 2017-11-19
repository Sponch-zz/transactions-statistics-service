package com.transactions.service;

/**
 * Service that receive callbacks
 * @author csponchiado
 *
 * @param <T>
 */
public interface CallbackService<T> {
	
	/**
	 * Receive calbacks with objects of type T
	 * @param t
	 */
	public void callback(T t);
}
