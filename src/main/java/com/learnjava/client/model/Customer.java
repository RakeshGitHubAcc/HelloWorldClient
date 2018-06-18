package com.learnjava.client.model;

import java.util.List;

import lombok.Data;

@Data
public class Customer {
	private int id;
	private String name;
	private String description;
	private List<Product> products;
}
