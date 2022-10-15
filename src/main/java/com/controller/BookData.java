package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Encapsulation;



public class BookData extends HttpServlet {
public BookData() {
	super();
}
protected void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException,IOException{
	response.setContentType("text/html");
	HttpSession session = request.getSession();
	Object obj = session.getAttribute("Object");
	Encapsulation emp = null;
	if(obj!=null) {
		emp = (Encapsulation)obj;
	}
	PrintWriter pw = response.getWriter();
	pw.print("<html><body><table>");
	pw.print("<tr><th>Id</th><th>Description</th><th>Genre</th><th>SoldCopies</th></tr>");
	pw.print("<tr><td>"+emp.getId()+"</td>");
	pw.print("<tr><td>"+emp.getDescripton()+"</td>");
	pw.print("<tr><td>"+emp.getGenre()+"</td>");
	pw.print("<tr><td>"+emp.getSold()+"</td>");
	pw.print("<tr><td><button><a href='index.html'>Homepage</a></td></tr>");
	pw.print("</table></body></html>");
}
}
