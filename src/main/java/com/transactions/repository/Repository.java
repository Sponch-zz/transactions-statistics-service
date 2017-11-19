package com.transactions.repository;

import java.util.List;

public interface Repository<T> {

	public void add(T t);

	public List<T> get();
}
