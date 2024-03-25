package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;
import com.exception.MinimumPaymentException;
import com.exception.PolicyNotFoundException;
import com.model.Client;
import com.service.PolicyService;

public class PolicyController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PolicyService policyService = new PolicyService();
		while (true) {
			System.out.println("**********POLICY OPERATION**********");
			System.out.println("press 1. Create Policy");
			System.out.println("press 2. Get Policy");
			System.out.println("press 3. Get All Policy");
			System.out.println("press 4. Update Policy");
			System.out.println("Press 5. Delete Policy");
			System.out.println("Press 6. To pay");
			System.out.println("Press 7. To Claim");
			System.out.println("press 0. for exit");
			System.out.println("**************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("Enter name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter contact info(either phone number or email):");
				String contactInfo = sc.next();
				System.out.println("Enter the policy you want to create:");
				sc.nextLine();
				String policy = sc.nextLine();
				try {
					policyService.createPolicy(name, contactInfo, policy);
					System.out.println("Policy Created Successfully !!");
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter your id:");
				int id = sc.nextInt();
				try {
					List<Client> list = policyService.fetchAllPolicy();
					Client c=policyService.fetchPolicyById(list,id);
					System.out.println(String.format("%-15s%-30s%-15s","Name","Contact Info","Policy"));
					System.out.println(String.format("%-15s%-30s%-15s",c.getName(),c.getContactInfo(),c.getPolicy()));
				} catch (SQLException | DatabaseConnectionException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					List<Client> list = policyService.fetchAllPolicy();
					System.out.println(String.format("%-15s%-30s%-15s","Name","Contact Info","Policy"));
					for(Client c:list)
						System.out.println(String.format("%-15s%-30s%-15s",c.getName(),c.getContactInfo(),c.getPolicy()));
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					List<Client>list = policyService.fetchAllPolicy();
					System.out.println("Enter your id:");
					int id1 = sc.nextInt();
					System.out.println();
					Client c = policyService.fetchPolicyById(list,id1);
					System.out.println(String.format("%-15s%-30s%-15s","Name","Contact Info","Policy"));
					System.out.println(String.format("%-15s%-30s%-15s",c.getName(),c.getContactInfo(),c.getPolicy()));
					System.out.println("What do you want to update?");
					sc.nextLine();				
					String field=sc.nextLine();
					System.out.println("Enter the new value:");
					String newVal=sc.nextLine();
					policyService.updatePolicy(id1,field,newVal);
					System.out.println("Policy updated Successfully");
				} catch (SQLException | DatabaseConnectionException | PolicyNotFoundException | InvalidInputException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter your id:");
				int id1 = sc.nextInt();
				List<Client> list;
				try {
					list = policyService.fetchAllPolicy();
					policyService.fetchPolicyById(list,id1);
					policyService.deletePolicy(id1);
					System.out.println("Policy Settled!!");
				} catch (SQLException | DatabaseConnectionException | PolicyNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Enter your id:");
				int clientId=sc.nextInt();
				System.out.println("Check your details...");
				try {
					List<Client> list1 = policyService.fetchAllPolicy();
					Client c = policyService.fetchPolicyById(list1,clientId);
					System.out.println(String.format("%-15s%-30s%-15s","Name","Contact Info","Policy"));
					System.out.println(String.format("%-15s%-30s%-15s",c.getName(),c.getContactInfo(),c.getPolicy()));
					System.out.println("Enter the amount:");
					double amount=sc.nextDouble();
					policyService.payPolicy(clientId,amount);
					System.out.println("Payment Successfull!!");
				} catch (SQLException | DatabaseConnectionException | PolicyNotFoundException | MinimumPaymentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println("Enter your id:");
				int clientId1=sc.nextInt();
				System.out.println("Check your details...");
				try {
					List<Client> list1 = policyService.fetchAllPolicy();
					Client c = policyService.fetchPolicyById(list1,clientId1);
					System.out.println(String.format("%-15s%-30s%-15s","Name","Contact Info","Policy"));
					System.out.println(String.format("%-15s%-30s%-15s",c.getName(),c.getContactInfo(),c.getPolicy()));
					System.out.println("Enter the amount to claim:");
					double amount=sc.nextDouble();
					System.out.println("Enter the claim id you received from admins:");
					String claimId=sc.next();
					System.out.println("Enter the status:");
					String status=sc.next();
					policyService.claimFromPolicy(claimId,clientId1,amount,c.getPolicy(),status);
					System.out.println("Recorded!!");
				} catch (SQLException | DatabaseConnectionException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
		sc.close();
	}
}
