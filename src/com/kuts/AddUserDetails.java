package com.kuts;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserDetails extends ActionSupport implements RequestAware {

	/**
	 * @author Sidhu
	 * Handles request for add new Customer
	 */
	private static final long serialVersionUID = 1L;
	private Customer customerBean;
	private boolean inputReqd;
	Map<String, Object> request = null;
	Log log = LogFactory.getLog(AddUserDetails.class);

	public Customer getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(Customer customerBean) {
		this.customerBean = customerBean;
	}

	@Override
	public String execute() {
		if (inputReqd)
			return INPUT;
		JDBCAccess user = new JDBCAccess();
		String result = user.updateUser("INSERT INTO Customer VALUES ("
				+ customerBean.getID() + ", '" + customerBean.getFirstName()
				+ "', '" + customerBean.getLastName() + "', '"
				+ customerBean.getStreet() + "', '" + customerBean.getCity()
				+ "')");
		if (result.equals("updated")) {
			request.put("resultmessage", "Customer details added.");
			log.info("New Customer added. Customer ID: " + customerBean.getID());
		} else{
			request.put("resultmessage", "Unable to add Customer details.");
			log.info("Failed to add new Customer.");
		}
		return SUCCESS;
	}

	public void validate() {
		if (customerBean == null) {
			inputReqd = true;
		} else {
			if (customerBean.getFirstName().length() == 0) {

				addFieldError("customerBean.firstName",
						"First name is required.");

			}
			if (customerBean.getLastName().length() == 0) {

				addFieldError("customerBean.lastName", "Last name is required.");

			}
			if (customerBean.getStreet().length() == 0) {

				addFieldError("customerBean.street", "Street is required.");

			}
			if (customerBean.getCity().length() == 0) {

				addFieldError("customerBean.city", "City is required.");

			}
		}
	}

	@Override
	public void setRequest(Map<String, Object> req) {
		request = req;

	}
}
