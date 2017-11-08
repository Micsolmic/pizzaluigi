package be.vdab.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PizzaluigiFilter
 */
@WebFilter("/*")
public class PizzaluigiFilter implements Filter {

	
	private final static String STATISTIEK = "statistiek";
	private final static Set<String> UITGESLOTEN_EXTENSIES = new
	CopyOnWriteArraySet<>(Arrays.asList("png","gif","jpg","css","js","ico"));
    /**
     * Default constructor. 
     */
    public PizzaluigiFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req =
			(HttpServletRequest) request;
			String url = req.getRequestURI();
			boolean verwerkRequest = true;
			int laatstePuntIndex = url.lastIndexOf('.');
			if (laatstePuntIndex != -1) {
			String extensie =
			url.substring(laatstePuntIndex + 1).toLowerCase();
			if (UITGESLOTEN_EXTENSIES.contains(extensie)) {
			verwerkRequest = false;
			}
			
			}

			if (verwerkRequest) {
			int index = url.indexOf(";jsessionid=");
			if (index != -1) {
			url = url.substring(0, index);
			}
			@SuppressWarnings("unchecked")
			ConcurrentHashMap<String, AtomicInteger> statistiek =
			(ConcurrentHashMap<String, AtomicInteger>) request.getServletContext()
			.getAttribute(STATISTIEK);
			AtomicInteger aantalReedsAanwezig =
			statistiek.putIfAbsent(url, new AtomicInteger(1));
			if (aantalReedsAanwezig != null) {
			aantalReedsAanwezig.incrementAndGet();
			}
			}
			}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		fConfig.getServletContext().setAttribute(STATISTIEK,
				new ConcurrentHashMap<String, AtomicInteger>());
		
	}

}
