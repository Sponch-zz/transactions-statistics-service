package com.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.domain.Statistics;
import com.transactions.service.StatisticsService;
import com.transactions.web.exception.OldTransactionException;

@RestController
public class StatisticsController {

    @Autowired 
    private StatisticsService statisticsService;

    @RequestMapping(value = "/statistics")
    public ResponseEntity<?> transactions () throws OldTransactionException {
    		Statistics statistics = statisticsService.getStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}