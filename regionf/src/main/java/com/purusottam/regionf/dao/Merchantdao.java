package com.purusottam.regionf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.purusottam.regionf.model.Merchant;
import com.purusottam.regionf.model.User;

public class Merchantdao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userservlet?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_MERCHANTS_SQL = "INSERT INTO merchants" + "(m_id,m_name, m_mail, m_address, m_phone, m_pincode, receipe_style, receipe_price) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_MERCHANTS_BY_ID = "select m_id,m_name, m_mail, m_address,m_phone, m_pincode,receipe_style, receipe_price from merchants where m_id =?";
	private static final String SELECT_ALL_MERCHANTS = "select * from merchants";
	private static final String DELETE_MERCHANTS_SQL = "delete from merchants where m_id = ?;";
	private static final String UPDATE_MERCHANTS_SQL = "update merchants set m_id=?,m_name=?,m_mail=?,m_address=?,m_phone=?,m_pincode=?,receipe_style=?,receipe_price=? where m_id = ?;";


	public Merchantdao() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertMerchant(Merchant merchant) throws SQLException {
		System.out.println(INSERT_MERCHANTS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MERCHANTS_SQL)) {
			preparedStatement.setString(1, merchant.getM_name());
			preparedStatement.setString(2, merchant.getM_mail());
			preparedStatement.setString(3, merchant.getM_address());
			preparedStatement.setString(4, merchant.getM_phone());
			preparedStatement.setString(5, merchant.getM_pincode());
			preparedStatement.setString(6, merchant.getReceipe_style());
			preparedStatement.setString(7, merchant.getReceipe_price());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Merchant> selectAllMerchants() {
		System.out.println("enter merchant");

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Merchant> merchants = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MERCHANTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int m_id = rs.getInt("m_id");
				String m_name = rs.getString("m_name");
				String m_mail = rs.getString("m_mail");
				String m_address = rs.getString("m_address");
				String m_phone = rs.getString("m_phone");
				String m_pincode = rs.getString("m_pincode");
				String receipe_style = rs.getString("receipe_style");
				String receipe_price = rs.getString("receipe_price");
				merchants.add(new Merchant(m_id, m_name, m_mail, m_address,m_phone,m_pincode,receipe_style,receipe_price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return merchants;
	}
	
	public Merchant selectmerchant(int m_id) {
		Merchant merchant = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MERCHANTS_BY_ID);) {
			preparedStatement.setInt(1, m_id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
			String m_name = rs.getString("m_name");
			String m_mail = rs.getString("m_mail");
			String m_address = rs.getString("m_address");
			String m_phone = rs.getString("m_phone");
			String m_pincode = rs.getString("m_pincode");
			String receipe_style = rs.getString("receipe_style");
			String receipe_price = rs.getString("receipe_price");
			merchant=new Merchant(m_id, m_name, m_mail, m_address,m_phone,m_pincode,receipe_style,receipe_price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return merchant;
	}
	
	public boolean deleteUser1(int m_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MERCHANTS_SQL);) {
			statement.setInt(1, m_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
