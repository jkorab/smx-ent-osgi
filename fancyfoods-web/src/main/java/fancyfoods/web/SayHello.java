package fancyfoods.web;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SayHello extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Locale locale = request.getLocale();
		String bundleName = "fancyfoods.web.messages";
		// just a regular Java resources bundle, not an OSGi one
		ResourceBundle resources = ResourceBundle.getBundle(bundleName, locale);
		//out.append("Fetching greeting by locale: " + locale);
		out.append(resources.getString("SayHello.hello"));
	}
}
