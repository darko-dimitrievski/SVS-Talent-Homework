package com.seavus.webcalculator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class WebCalculatorServlet extends HttpServlet {
	CalculatorImpl calculator = new CalculatorImpl();
	ArrayList<String> calculations = new ArrayList<String>();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session = req.getSession();
		session.setAttribute("calculations", calculations);
		calculate(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		session = req.getSession();
		session.setAttribute("calculations", calculations);
		calculate(req, resp);
	}

	private void calculate(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String operation = req.getParameter("operation");
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		resp.setContentType("text/html");
		HttpSession session = req.getSession();

		if (operation.equals("add")) {
			// resp.getWriter().println(calculator.add(num1, num2));
			calculations.add(num1 + " + " + num2 + " = "
					+ calculator.add(num1, num2));
		} else if (operation.equals("substract")) {
			calculations.add(num1 + " - " + num2 + " = "
					+ calculator.substract(num1, num2));
		} else if (operation.equals("session")) {
			resp.getWriter().println(session.getAttribute("calculations"));
		}

	}
}
