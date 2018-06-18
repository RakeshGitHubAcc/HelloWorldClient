package com.learnjava.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.learnjava.client.model.Customer;

@RestController
@RequestMapping("/test")
public class CustomerClientFeignConntroller {
	@Autowired
	CustomerClient customerClient;

	@RequestMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = null;
		try {
			customers = customerClient.findAllCustomers();
		} catch (RestClientException rce) {
			rce.printStackTrace();
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
}
