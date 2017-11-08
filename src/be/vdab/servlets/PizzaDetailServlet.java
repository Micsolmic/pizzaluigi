package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.repositories.PizzaRepository;

/**
 * Servlet implementation class PizzaDetailServlet
 */
@WebServlet(urlPatterns = {"/pizzas/detail.htm", "/pizzas/details.htm"})
public class PizzaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
	private final PizzaRepository pizzaRepository = new PizzaRepository();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			pizzaRepository.read(
					Long.parseLong(request.getParameter("id"))).ifPresent(pizza -> 
					request.setAttribute("pizza", pizza));
					
			
			
		}catch(NullPointerException | NumberFormatException ex) {request.setAttribute("fout", "id niet correct");}
	
		request.getRequestDispatcher("/WEB-INF/JSP/pizzadetail.jsp").forward(request, response);
	
	}
	@Resource(name = PizzaRepository.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		pizzaRepository.setDataSource(dataSource);
	}

}
