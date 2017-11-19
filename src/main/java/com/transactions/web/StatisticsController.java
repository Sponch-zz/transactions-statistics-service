package com.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.domain.Statistics;
import com.transactions.service.StatisticsService;
import com.transactions.web.exception.OldTransactionException;

/**
 * Statistics controller
 * @author csponchiado
 *
 */
@RestController
public class StatisticsController {

	/**
	 * Service of statistics
	 */
	@Autowired
	private StatisticsService statisticsService;

	/**
	 * Rest API endpoint to show statistics
	 * @return 201 OK with current statistics
	 */
	@RequestMapping(value = "/statistics")
	public ResponseEntity<?> transactions() {
		Statistics statistics = statisticsService.getStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
}