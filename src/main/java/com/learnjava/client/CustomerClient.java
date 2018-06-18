package com.learnjava.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnjava.client.model.Customer;

import feign.Param;


@FeignClient(name = "customerProducer", url = "http://localhost:8083/helloworld")
public interface CustomerClient {

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	List<Customer> findAllCustomers();

	@RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}")
	Customer findByCustomerId(@Param("customerId") String customerId);
}
