package com.transactions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Application Configuration
 * @author csponchiado
 *
 */
@Component
public class ApplicationConfiguration {

	/**
	 * Time frame to calculate statistics
	 */
	@Value("${statistics.timeFrame}")
	private Integer timeFrame;

	public Integer getTimeFrame() {
		return timeFrame;
	}
}
