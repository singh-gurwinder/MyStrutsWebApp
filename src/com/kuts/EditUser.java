package com.kuts;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditUser extends ActionSupport implements RequestAware {

	/**
	 * @author Sidhu
	 * Handles request for edit Customer
	 */
	private static final long serialVersionUID = 1L;

	String userID, userUpdated;
	private Customer customerBean = null;
	HttpServletRequest servletrequest = null;
	Log log=LogFactory.getLog(EditUser.class);

	Map<String, Object> request = null;

	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		servletrequest = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		userID = servletrequest.getParameter("userID");
		userUpdated = servletrequest.getParameter("userUpdated");
		if (userID == null && userUpdated == null) {
			return "getuserid";
		}
		JDBCAccess user = new JDBCAccess();
		if (userUpdated == null) {
			customerBean = new Customer();
			ArrayList<Customer> customer = user
					.getUsers("SELECT * FROM Customer WHERE ID=" + userID);
			customerBean = customer.get(0);
			return INPUT;
		} else {
			String result = user.updateUser("Update Customer SET FIRSTNAME = '"
					+ customerBean.getFirstName() + "',  LASTNAME = '"
					+ customerBean.getLastName() + "', STREET = '"
					+ customerBean.getStreet() + "', CITY = '"
					+ customerBean.getCity() + "' WHERE ID = "
					+ customerBean.getID());
			if (result.equals("updated")){
				request.put("resultmessage", "Customer details updated.");
				log.info("Customer details updated. Customer ID: " + customerBean.getID());
			}
			else{
				request.put("resultmessage",
						"Unable to update Customer details.");
				log.info("Failed to updateCustomer details.");
			}
			return SUCCESS;
		}
	}

	public Customer getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(Customer customerBean) {
		this.customerBean = customerBean;
	}

	public void validate() {
		if (customerBean != null) {
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
