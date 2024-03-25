package com.model;

public class Client {
	private int id;
	private String name;
	private String contactInfo;
	private String policy;
	
	
	public Client() {
		super();
	}


	public Client(String name, String contactInfo, String policy) {
		super();
		this.name = name;
		this.contactInfo = contactInfo;
		this.policy = policy;
	}


	public Client(int id, String name, String contactInfo, String policy) {
		super();
		this.id = id;
		this.name = name;
		this.contactInfo = contactInfo;
		this.policy = policy;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getPolicy() {
		return policy;
	}


	public void setPolicy(String policy) {
		this.policy = policy;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", contactInfo=" + contactInfo + ", policy=" + policy + "]";
	}
	
	
	
}
