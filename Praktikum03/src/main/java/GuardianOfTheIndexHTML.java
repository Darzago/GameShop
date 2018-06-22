import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="/GuardianOfTheIndexHTML", urlPatterns={"/protected/*"})
public class GuardianOfTheIndexHTML implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("username") == null)
		{
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Zugriff ist nicht erlaubt");
		}
		else 
		{
			//before servlet execution
			chain.doFilter(request, response);
			//after servlet execution
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
