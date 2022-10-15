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

public class IndelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

public IndelServlet() {
	super();
}
protected void doGet(HttpServletResponse response, HttpServletRequest request)throws ServletException,IOException{
	System.out.println("this is from Get");
	String id = request.getParameter("id");
	String description = request.getParameter("description");
	String genre = request.getParameter("genre");
	String sold = request.getParameter("sold");
	int sale = 0;
	try {
		sale = Integer.parseInt(sold);
	}catch(Exception e) {
		sale =0;
	}
Encapsulation ed = new Encapsulation();
ed.setId(id);
ed.setDescripton(description);
ed.setGenre(genre);
ed.setSold(sale);
	WebImplementation we = new WebImplementation();
	int result = we.Insert(ed);
	HttpSession session = request.getSession();
	session.setAttribute("Object", ed);
	RequestDispatcher rd =request.getRequestDispatcher("/BookData");
	RequestDispatcher rr = request.getRequestDispatcher("Sorry.html");
	if(result>0) {
		rd.forward(request, response);
	}else {
		rr.forward(request, response);
	}
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
	System.out.println("This is from Post");
String id = request.getParameter("id");
Encapsulation en = new Encapsulation();
en.setId(id);
WebImplementation wi = new WebImplementation();
int result = wi.delete(en);
RequestDispatcher rd = request.getRequestDispatcher("successfull.html");
RequestDispatcher rr = request.getRequestDispatcher("fail.html");
if(result>0) {
	rd.forward(request, response);
}else {
	rr.forward(request, response);
}
}
}

