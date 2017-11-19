package com.transactions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.ApplicationConfiguration;
import com.transactions.domain.Transaction;
import com.transactions.service.TransactionsService;
import com.transactions.util.TimeUtil;
import com.transactions.web.exception.OldTransactionException;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;

	@Autowired
	private ApplicationConfiguration configuration;

	/**
	 * Rest API endpoint to receive transactions
	 * @return 201 Created if transactions has a valid timestamp
	 *   			 204 No Content if transaction is older than time frame
	 * @throws OldTransactionException if timestamp is older than time frame
	 */
	@ApiOperation(value = "Add Transactions", nickname = "transactions")
  @ApiResponses(value = { 
  		@ApiResponse(code = 201, message = "Successfully created transaction"),
    @ApiResponse(code = 204, message = "Transaction has old timestamp")
  }) 
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, path="/transactions", produces = "application/json")
	public void transactions(@RequestBody Transaction transaction) throws OldTransactionException {
		if (TimeUtil.isOlderThanTimeFrame(transaction.getTimestamp(), configuration.getTimeFrame())) {
			throw new OldTransactionException();
		}
		transactionsService.addTransaction(transaction);
	}
}
