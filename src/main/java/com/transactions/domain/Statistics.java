package com.transactions.domain;

/**
 * Statistics of transactions 
 * @author csponchiado
 *
 */
public final class Statistics {

	/**
	 * total sum of transaction value 
	 */
    private final Double sum;
    
    /**
     * average amount of transaction value 
     */
    private final Double avg;
    
    /**
     * highest transaction value
     */
    private final Double max;
    
    /**
     * lowest transaction value
     */
    private final Double min;
    
    /**
     * total number of transactions
     */
    private final Long count;
    
    public Statistics() {
    		this(0d, 0d, 0d, 0d, 0L);
    }
    
	public Statistics(Double sum, Double avg, Double max, Double min, Long count) {
		super();
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public Double getSum() {
		return sum;
	}
	
	public Double getAvg() {
		return avg;
	}
	
	public Double getMax() {
		return max;
	}
	
	public Double getMin() {
		return min;
	}
	
	public Long getCount() {
		return count;
	}
}
