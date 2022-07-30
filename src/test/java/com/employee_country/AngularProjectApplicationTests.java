package com.employee_country;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class AngularProjectApplicationTests {

	@Test
	void contextLoads() {
		
	}

	@Test
	public void getEmployeeAPITest() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		String baseUrl = "http://localhost:8080/getEmployeeById/1";

		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		Assertions.assertEquals(200, result.getStatusCodeValue());

		System.out.println("done..");
	}

}
