package com.transactions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {

	@Value("${statistics.timeFrame}")
	private Integer timeFrame;

	public Integer getTimeFrame() {
		return timeFrame;
	}
}
