package exemplo.jsf.richfaces4.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HibernateSessionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HibernateUtil.openSession();
			HibernateUtil.currentSession().beginTransaction();
			chain.doFilter(request, response);
			HibernateUtil.currentSession().getTransaction().commit();			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} finally {
			HibernateUtil.closeCurrentSession();	
		}
	}

	public void init(FilterConfig c) throws ServletException {
		
	}

	public void destroy() {
		
	}
	
}
