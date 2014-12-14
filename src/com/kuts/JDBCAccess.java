package com.kuts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCAccess {
	
	/**
	 * @author Sidhu
	 * JDBC Utility Class
	 */

	ResultSet rs = null;

	private void runQuery(String query) {
		Connection conn = null;
		Statement st = null;

		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/",
					"SA", "");
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (NullPointerException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Customer> getUsers(String query) {
		Customer customer;
		ArrayList<Customer> custList = new ArrayList<Customer>();
		try {
			runQuery(query);
			while (rs.next()) {
				customer = new Customer();
				customer.setID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setStreet(rs.getString(4));
				customer.setCity(rs.getString(5));
				custList.add(customer);
			}
		} catch (NullPointerException | SQLException e) {
			e.printStackTrace();
		}
		return custList;
	}

	public ArrayList<Integer> getID() {
		ArrayList<Integer> idList = new ArrayList<Integer>();
		try {
			runQuery("SELECT ID FROM Customer order by ID");
			while (rs.next()) {
				idList.add(rs.getInt(1));
			}
		} catch (NullPointerException | SQLException e) {
			e.printStackTrace();
		}
		return idList;
	}

	public String deleteUser(String query) {
		try {
			runQuery(query);
			if (!rs.equals(null))
				return "deleted";
			else
				return "notdeleted";
		} catch (Exception ex) {
			return "notdeleted";
		}
	}

	public int getNewID() {
		int iD;
		try {
			runQuery("SELECT max(ID) FROM Customer");
			if (rs.next())
				iD = rs.getInt(1);
			else
				iD=-2;
		} catch (Exception ex) {
			iD = -2;
		}
		return ++iD;
	}
	
	public String updateUser(String query){
		try {
			runQuery(query);
			if (!rs.equals(null))
				return "updated";
			else
				return "notupdated";
		} catch (Exception ex) {
			return "notupdated";
		}		
	}
}
