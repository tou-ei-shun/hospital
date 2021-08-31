/**
 * 
 */
package jp.co.mtrx.hms.message.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author t-eishun
 *
 */
@WebFilter("/*")
public class SetCharacterEncodingFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("FILTER IN:" + getClass().getName() + "#doFilter()");

		// Ç±ÇÍÇ≈ÇµÇƒÇ®Ç≠Ç∆ÅAtransfer2Unicode(String)ïsóv
		// req.setCharacterEncoding(config.getInitParameter("encoding"));
		req.setCharacterEncoding("Shift_JIS");

		chain.doFilter(req, resp);
		System.out.println("FILTET OUT:" + getClass().getName() + "#doFilter()");

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;

	}

}
