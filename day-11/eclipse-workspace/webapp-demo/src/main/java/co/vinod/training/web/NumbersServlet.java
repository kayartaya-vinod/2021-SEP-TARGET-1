package co.vinod.training.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/numbers")
public class NumbersServlet extends HttpServlet {
	
	// a variant of service method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String a, b;
		a = req.getParameter("from");
		b = req.getParameter("to");
		
		int from = Integer.valueOf(a), to = Integer.valueOf(b);
		 
		// while req is like a question paper in an exam, resp is like the answer sheet.
		// and out is like a pen using which you can write on the paper
		
		PrintWriter out = resp.getWriter();
		for(int i=from; i<=to; i++) {
			out.println(i);
		}
		out.close();
	}

}
