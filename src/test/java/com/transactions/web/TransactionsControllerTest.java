package com.transactions.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.transactions.ApplicationConfiguration;
import com.transactions.service.TransactionsService;
import com.transactions.util.TimeUtil;

import builder.TransactionBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransactionsService transactionsService;

	@MockBean
	private ApplicationConfiguration configuration;

	@Before
	public void setUp() {
		Mockito.when(configuration.getTimeFrame()).thenReturn(2);
	}

	@Test
	public void shouldReturnCreated_whenTransationIsValid() throws Exception {
		String json = TransactionBuilder.getTransactionInJson(10d, TimeUtil.nowInMillis() + 1000);
		mvc.perform(post("/transactions").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void shouldReturnNoContent_whenTransationIsOld() throws Exception {
		String json = TransactionBuilder.getTransactionInJson(10d, TimeUtil.nowInMillis() - 60001);
		mvc.perform(post("/transactions").content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
