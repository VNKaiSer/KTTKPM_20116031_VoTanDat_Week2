package com.example.models.nested;

public class Customer {
	private String customerNested;

	public String getCustomerNested() {
		return customerNested;
	}

	public void setCustomerNested(String customerNested) {
		this.customerNested = customerNested;
	}

	public Customer() {
		super();
	}

	public Customer(String customerNested) {
		super();
		this.customerNested = customerNested;
	}

}
