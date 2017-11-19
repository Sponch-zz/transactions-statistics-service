package com.transactions.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.transactions.ApplicationConfiguration;
import com.transactions.domain.Statistics;
import com.transactions.service.StatisticsService;

@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StatisticsService statisticsService;

	@MockBean
	private ApplicationConfiguration configuration;

	@Before
	public void setUp() {
		Mockito.when(statisticsService.getStatistics()).thenReturn(new Statistics());
	}

	@Test
	public void shouldReturnEmptyStatistics_whenNoHaveTransactions() throws Exception {
		mvc.perform(get("/statistics").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.sum").value(0d));
	}
}
