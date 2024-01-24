package com.example.models.nested;

public class Account {
	private String accountNested;
	private Customer customerNested;
	public Account() {
		super();
	}
	public Account(String accountNested) {
		super();
		this.accountNested = accountNested;
	}
	public String getAccountNested() {
		return accountNested;
	}
	public void setAccountNested(String accountNested) {
		this.accountNested = accountNested;
	}
	public Customer getCustomerNested() {
		return customerNested;
	}
	public void setCustomerNested(Customer customerNested) {
		this.customerNested = customerNested;
	}
	
	
}
