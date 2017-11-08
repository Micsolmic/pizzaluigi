package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Statistiek
 */
@WebServlet("/statistiek.htm")
public class Statistiek extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/statistiek.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AtomicInteger aantalMandjes = (AtomicInteger) request.getServletContext().getAttribute("aantalMandjes");
		PrintWriter out = response.getWriter();
		out.println(aantalMandjes);
	/*	request.setAttribute("aantalMandjes", aantalMandjes);
		request.getRequestDispatcher(VIEW).forward(request,response);
	*/	
	}

}
