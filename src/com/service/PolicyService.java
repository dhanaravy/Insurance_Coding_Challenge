package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.IPolicyService;
import com.dao.IPolicyServiceImpl;
import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;
import com.exception.MinimumPaymentException;
import com.exception.PolicyNotFoundException;
import com.model.Client;

public class PolicyService {
	IPolicyService iPolicyService=new IPolicyServiceImpl();
	
	public void createPolicy(String name, String contactInfo, String policy) throws SQLException, DatabaseConnectionException {
		iPolicyService.createPolicy(name,contactInfo,policy);
	}
	
	public List<Client> fetchAllPolicy() throws SQLException, DatabaseConnectionException {
		return iPolicyService.fetchAllPolicy();
	}

	public Client fetchPolicyById(List<Client> list, int id) throws PolicyNotFoundException {
		for(Client c:list)
		{
			if(c.getId()==id)
				return c;
		}
		throw new PolicyNotFoundException("Your policy is not found..Check with the admins!");
	}

	public void updatePolicy(int id1, String field, String newVal) throws SQLException, DatabaseConnectionException, InvalidInputException {
		String fieldd=field.toLowerCase().replace(" ","_");
		if(fieldd.equals("id"))
			throw new InvalidInputException("Sorry!! Your id could not be updated :<");
		else
			iPolicyService.updatePolicy(id1,fieldd,newVal);
	}

	public void deletePolicy(int id) throws SQLException, DatabaseConnectionException {
		iPolicyService.deletePolicy(id);
	}

	public void payPolicy(int clientId, double amount) throws SQLException, DatabaseConnectionException, MinimumPaymentException {
		if(amount>100)
			iPolicyService.payPolicy(clientId,amount);
		else
			throw new MinimumPaymentException("Minimum amount is >100");
	}

	public void claimFromPolicy(String claimId, int clientId1, double amount, String policy, String status) throws SQLException, DatabaseConnectionException {
		
		iPolicyService.claimFromPolicy(claimId,clientId1,amount,policy,status);
	}

}
