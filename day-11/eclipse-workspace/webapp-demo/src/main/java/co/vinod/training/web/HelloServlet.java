package co.vinod.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Received a request from some user at " + new Date());
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello, World!</h1>");
		out.println("<hr>");
		out.println("<p>This output is coming from a Servlet</p>");
		out.close();
	}
}
