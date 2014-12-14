package com.kuts;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;

public class ViewDeleteUser implements RequestAware {
	
	/**
	 * @author Sidhu
	 * Handles request for view/delete Customer
	 */

	Map<String, Object> request = null;
	Log log=LogFactory.getLog(ViewDeleteUser.class);

	@Override
	public void setRequest(Map<String, Object> req) {
		request = req;
	}

	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest servletrequest = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		String userIDtoDelete = servletrequest.getParameter("userIDtoDelete");
		JDBCAccess user = new JDBCAccess();
		if (userIDtoDelete != null) {
			String result = user.deleteUser("DELETE FROM Customer WHERE ID="
					+ userIDtoDelete);
			if (result.equals("deleted")){
				request.put("resultmessage", "Customer deleted.");
				log.info("Customer deleted. Customer ID: " + userIDtoDelete);
			}
			else{
				request.put("resultmessage", "Unable to delete Customer.");
				log.info("Unable to Delete customer.");
			}
			return "delete";
		}
		String userID = servletrequest.getParameter("userID");
		if (userID == null)
			return "getUserID";
		ArrayList<Customer> customer = user
				.getUsers("SELECT * FROM Customer WHERE ID=" + userID);
		request.put("user", customer.get(0));
		return "viewUser";
	}

}
