package fancyfoods.web;

import fancyfoods.food.Food;
import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class SayHelloJNDI extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

        out.append("<html>");
        out.append("Hello valued customer!<br/>");

        try {
            InitialContext ctx = new InitialContext(); // what happens on a command line for stuff like this?
            String jndiName = "osgi:service/" + CurrentOffers.class.getName();
            CurrentOffers offers = (CurrentOffers) ctx.lookup(jndiName);

            out.append("<table>");
            for (SpecialOffer offer : offers.getCurrentOffers()) {
                writeRowForOffer(out, offer);
            }
            out.append("</table>");

        } catch (NamingException e) {
            out.append("No special offers today - try tomorrow.");
        }

        out.append("</html>");
	}

    private void writeRowForOffer(PrintWriter out, SpecialOffer offer) {
        out.append("<tr>");
        String description = offer.getDescription();
        Food food = offer.getOfferFood();
        out.append("<td>" + food.getName() + "</td>");
        out.append("<td>" + food.getPrice() + "</td>");
        out.append("<td>" + description + "</td>");
        out.append("</tr>");
    }
}
