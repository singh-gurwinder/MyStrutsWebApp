package com.kuts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GetNewIDTagHandler extends SimpleTagSupport {
	
	/**
	 * @author Sidhu
	 * Tag Handler to generate new CustomerID
	 */
	
	public void doTag() throws JspException {
		PageContext pageContext = (PageContext) getJspContext();
		JDBCAccess user = new JDBCAccess();
		Integer newID = user.getNewID();
		if (newID != null && newID > 0) {
			//out.print("<input type=\"hidden\" name=\"ID\" value=\"" + newID + "\">");
			pageContext.getRequest().setAttribute("newUserID", newID);
		} else {
			pageContext.getRequest().setAttribute("resultmessage", "Unable to Generate new Customer ID");
			try {
				pageContext.forward("showresult.jsp");
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
