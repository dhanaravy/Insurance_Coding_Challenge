package com.model;

import java.time.LocalDate;

public class Payment {
	private int id;
	private LocalDate paymentDate;
	private double amount;
	private int clientId;
	
	public Payment() {
		super();
	}

	public Payment(int id, LocalDate paymentDate, double amount, int clientId) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.clientId = clientId;
	}

	public Payment(LocalDate paymentDate, double amount, int clientId) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.clientId = clientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentDate=" + paymentDate + ", amount=" + amount + ", clientId=" + clientId
				+ "]";
	}
	
	
}
