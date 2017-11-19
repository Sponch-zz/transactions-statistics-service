package com.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.domain.Statistics;
import com.transactions.service.StatisticsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	@ApiOperation(value = "Calculate statistics of transactions in the last 60 secs", response = Statistics.class)
	@ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved statistics")
	})
	@RequestMapping(method = RequestMethod.GET, path="/statistics", produces = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> transactions() {
		Statistics statistics = statisticsService.getStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
}