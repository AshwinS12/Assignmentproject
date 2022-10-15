package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Encapsulation;
import com.implementation.WebImplementation;



public class FetchServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FetchServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form submitted on GET");
		String Id = request.getParameter("id");
		
		
		String description = request.getParameter("description");
		String genre = request.getParameter("genre");
		String sold = request.getParameter("sold");
		int sale = 0;
		try {
			sale = Integer.parseInt(sold);
		}catch(Exception e) {
			sale = 0;
		}
		Encapsulation es = new Encapsulation();
		es.setId(Id);
		es.setDescripton(description);
		es.setGenre(genre);
		es.setSold(sale);
		WebImplementation we = new WebImplementation();
		int result = we.Insert(es);
		HttpSession session = request.getSession();
		session.setAttribute("Object", es);
		
		RequestDispatcher empservlet = request.getRequestDispatcher("/BookData");
		RequestDispatcher failure = request.getRequestDispatcher("Failure.html");
		if(result>0) {
			
				empservlet.forward(request, response);
			}
		 else {
		
				failure.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		WebImplementation dao = new WebImplementation();
		List<Encapsulation> result = dao.Fetch();
		HttpSession session = request.getSession();
		session.setAttribute("Object", result);
		RequestDispatcher req = request.getRequestDispatcher("view.jsp");
		req.forward(request, response);
	}
}

