package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Client;
import com.util.DBUtil;

public class IPolicyServiceImpl implements IPolicyService {

	public void createPolicy(String name, String contactInfo, String policy) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtil.getDbConn();

		String sql = "insert into client(name,contact_info,policy) values(?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1,name);
		pstmt.setString(2,contactInfo);
		pstmt.setString(3,policy);

		pstmt.executeUpdate();

		DBUtil.DBClose();
	}


	public List<Client> fetchAllPolicy() throws SQLException, DatabaseConnectionException {
		List<Client> list = new ArrayList<>();
		Connection conn = DBUtil.getDbConn();

		String sql = "select * from client";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) {
			int id=rst.getInt("id");
			String name=rst.getString("name");
			String contactInfo=rst.getString("contact_info");
			String policy=rst.getString("policy");
			
			Client c=new Client(id,name,contactInfo,policy);
			list.add(c);
		}
		
		DBUtil.DBClose();
		return list;
	}


	@Override
	public void updatePolicy(int id, String field, String newVal) throws SQLException, DatabaseConnectionException {
		Connection conn = DBUtil.getDbConn();

		String sql = "update client set "+field+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		

		pstmt.setString(1,newVal);
		pstmt.setInt(2, id);


		pstmt.executeUpdate();

		DBUtil.DBClose();
		
	}


	@Override
	public void deletePolicy(int id) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtil.getDbConn();
		
		String sql = "delete from claim where client_id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		sql = "delete from payment where client_id=?";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();
		
		sql = "delete from client where id=?";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		DBUtil.DBClose();
		
	}


	public void payPolicy(int clientId, double amount) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtil.getDbConn();

		String sql = "insert into payment(date,amount,client_id) values(?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setDate(1,Date.valueOf(LocalDate.now()));
		pstmt.setDouble(2,amount);
		pstmt.setInt(3,clientId);

		pstmt.executeUpdate();

		DBUtil.DBClose();
	}


	@Override
	public void claimFromPolicy(String claimId, int clientId1, double amount, String policy, String status) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtil.getDbConn();

		String sql = "insert into claim(claim_number,date_filed,claim_amount,status,policy,client_id) values(?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, claimId);
		pstmt.setDate(2,Date.valueOf(LocalDate.now()));
		pstmt.setDouble(3,amount);
		pstmt.setString(4, status);
		pstmt.setString(5, policy);
		pstmt.setInt(6, clientId1);
		

		pstmt.executeUpdate();

		DBUtil.DBClose();
	}


	

	

}
