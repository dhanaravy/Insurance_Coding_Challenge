package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Client;

public interface IPolicyService {

	void createPolicy(String name, String contactInfo, String policy) throws SQLException, DatabaseConnectionException;

	List<Client> fetchAllPolicy() throws SQLException, DatabaseConnectionException;

	void updatePolicy(int id1, String fieldd, String newVal) throws SQLException, DatabaseConnectionException;

	void deletePolicy(int id) throws SQLException, DatabaseConnectionException;

	void payPolicy(int clientId, double amount) throws SQLException, DatabaseConnectionException;

	void claimFromPolicy(String claimId, int clientId1, double amount, String policy, String status) throws SQLException, DatabaseConnectionException;


	

}
