package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// enkele imports ...


@WebServlet("/identificatie.htm")
public class IdentificatieServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "/WEB-INF/JSP/identificatie.jsp";


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
HttpSession session = request.getSession(false); 
if (session != null) { 
String gebruikersnaam =
(String) session.getAttribute("gebruikersnaam"); 

if (gebruikersnaam != null) { 
request.setAttribute("gebruikersnaam", gebruikersnaam); 
}
}
request.getRequestDispatcher(VIEW).forward(request, response);
}
@Override
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
// is handled by filter
// request.setCharacterEncoding("UTF-8");
HttpSession session = request.getSession(); 
session.setAttribute("gebruikersnaam", 
request.getParameter("gebruikersnaam"));
response.sendRedirect(request.getRequestURI()); // redirect->huidige
}
}