package com.transactions.repository;

import java.util.List;

/**
 * Interface for repository of data
 * @author csponchiado
 *
 * @param <T>
 */
public interface Repository<T> {

	/**
	 * Add data in repository
	 * @param t
	 */
	public void add(T t);

	/**
	 * Get data from repositoy
	 * @return
	 */
	public List<T> get();
}
