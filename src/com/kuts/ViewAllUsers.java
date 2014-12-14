package com.kuts;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class ViewAllUsers implements RequestAware {
	
	/**
	 * @author Sidhu
	 * Handles request for view all Customers
	 */

	Map<String, Object> request = null;

	public String execute() {
		JDBCAccess user = new JDBCAccess();
		ArrayList<Customer> customers = user.getUsers("SELECT * FROM Customer");
		if (customers.isEmpty()) {
			request.put("resultmessage", "Unable to retrieve Customers.");
			return "failed";
		}
		request.put("Customers", customers);
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> req) {
		request = req;
	}

}
