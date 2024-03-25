package com.model;

import java.time.LocalDate;

public class Claim {
	private int id;
	private String number;
	private LocalDate dateFiled;
	private double amount;
	private String status;
	private String policy;
	private int clientId;
	
	
	public Claim() {
		super();
	}


	public Claim(String number, LocalDate dateFiled, double amount, String status, String policy, int clientId) {
		super();
		this.number = number;
		this.dateFiled = dateFiled;
		this.amount = amount;
		this.status = status;
		this.policy = policy;
		this.clientId = clientId;
	}


	public Claim(int id, String number, LocalDate dateFiled, double amount, String status, String policy,
			int clientId) {
		super();
		this.id = id;
		this.number = number;
		this.dateFiled = dateFiled;
		this.amount = amount;
		this.status = status;
		this.policy = policy;
		this.clientId = clientId;
	}
	
	
}
