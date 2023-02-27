package com.srensamblador.springapp;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@IntegrationTest
@Sql("classpath:db/data.sql")
class PriceIT {

	private final static String ENDPOINT = "/prices";

	@Autowired
	private MockMvc mockMvc;

	@DisplayName("Must give the expected price value for a product given a date")
	@ParameterizedTest(name = "Date: {0} - Expected price: {1}")
	@CsvSource({ "2020-06-14T10:00:00,35.50", "2020-06-14T16:00:00,25.45", "2020-06-14T21:00:00,35.50",
			"2020-06-15T10:00:00,30.50", "2020-06-16T21:00:00,38.95" })
	void verify_price_for_a_product_given_a_date(String dtStr, String price) throws Exception {
		mockMvc.perform(get(ENDPOINT).param("brand", "1").param("product", "35455").param("date", dtStr))
				.andExpect(status().isOk()).andExpect(jsonPath("$.price", is(price)));
	}

	@DisplayName("Must give a 404 if there is no price range for the given date")
	@Test
	void no_price_for_date() throws Exception {
		mockMvc.perform(
				get(ENDPOINT).param("brand", "1").param("product", "35455").param("date", "2000-01-01T00:00:00"))
				.andExpect(status().isNotFound());
	}

	@DisplayName("Must give a 404 if the product does not exist")
	@Test
	void product_does_not_exist() throws Exception {
		mockMvc.perform(
				get(ENDPOINT).param("brand", "1").param("product", "9999").param("date", "2020-06-14T16:00:00"))
				.andExpect(status().isNotFound());
	}
	
	@DisplayName("Must give a 404 if the brand does not exist")
	@Test
	void brand_does_not_exist() throws Exception {
		mockMvc.perform(
				get(ENDPOINT).param("brand", "9999").param("product", "35455").param("date", "2020-06-14T16:00:00"))
				.andExpect(status().isNotFound());
	}

}
