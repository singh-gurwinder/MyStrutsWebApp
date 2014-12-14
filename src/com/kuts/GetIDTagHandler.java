package com.kuts;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GetIDTagHandler extends SimpleTagSupport {
	
	/**
	 * @author Sidhu
	 * Tag Handler to get all CustomerID's
	 */
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		JDBCAccess user = new JDBCAccess();
		ArrayList<Integer> userID = user.getID();
		if (!userID.isEmpty()) {
			out.print("<select name=\"userID\">");
			for (Integer i : userID)
				out.print("<option value=\"" + i + "\">" + i + "</option>");
			out.print("</select>");
			out.print("<input type=\"submit\" value=\"Submit\">");
		} else{
			out.print("<br>Unable to retrieve Customer ID's.");
		}
	}

}
