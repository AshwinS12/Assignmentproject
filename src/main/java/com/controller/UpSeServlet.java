package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Encapsulation;
import com.implementation.WebImplementation;


public class UpSeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

public UpSeServlet() {
	super();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
	System.out.println("form update in Post");
	String employeeId = request.getParameter("employeeId");
	
	String id = request.getParameter("id");
	String sold = request.getParameter("sold");
	int sale = 0;
	try {
		sale = Integer.parseInt(sold);
	}catch(Exception e) {
		sale = 0;
	}
	
	Encapsulation es = new Encapsulation();
	es.setId(id);
	es.setSold(sale);
	WebImplementation we = new WebImplementation();
	
	int result = we.update(es);
	HttpSession session = request.getSession();
	session.setAttribute("Object", es);

	RequestDispatcher success = request.getRequestDispatcher("successfull.html");
	RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
	if(result>0) {
		success.forward(request, response);
	}else {
		failure.forward(request, response);
	}
}

	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	System.out.println("This is search in get");
	String Id = request.getParameter("id");

	Encapsulation ec = new Encapsulation();
	ec.setId(Id);
	WebImplementation wi = new WebImplementation();
	Encapsulation ee = wi.Search(Id);
	HttpSession session = request.getSession();
	session.setAttribute("Object", ee);
	RequestDispatcher success = request.getRequestDispatcher("/BookData");
	RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
	if(ee!=null) {
		success.forward(request, response);
	}else {
		failure.forward(request, response);
	}
}
}