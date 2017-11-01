package be.vdab.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.vdab.entities.Saus;
import be.vdab.repositories.SausRepository;;
/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen")
public class SauzenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		List<Saus> lijst = SausRepository.findAll();		
		
		request.setAttribute("sauzen", lijst);

		request.getRequestDispatcher("/WEB-INF/JSP/sauzen.jsp").forward(request, response);
		
	}

}
