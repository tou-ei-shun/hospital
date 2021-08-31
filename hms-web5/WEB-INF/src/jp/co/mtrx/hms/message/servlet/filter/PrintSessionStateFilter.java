/**
 * 
 */
package jp.co.mtrx.hms.message.servlet.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author t-eishun
 *
 */
@WebFilter("/*")
public class PrintSessionStateFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpSession session = httpReq.getSession();// セッション取得

		System.out.println("FILTER IN :" + getClass().getName() + "#doFilter()");
		printSessionAttributes(session);// セッションの属性表示

		// 次のフィルタへ
		chain.doFilter(req, resp);

		System.out.println("FILTER OUT :" + getClass().getName() + "#doFilter()");
		printSessionAttributes(session);// セッションの属性表示

	}

	@Override
	public void init(FilterConfig args0) throws ServletException {

	}

	// * セッションの属性を表示
	private void printSessionAttributes(HttpSession session) {
		// 全リクエスト属性名を取得
		Enumeration<String> attrNames = session.getAttributeNames();
		if (!attrNames.hasMoreElements()) {
			System.out.println("Session Attributes : EMPTY");
			return;
		}
		StringBuffer buf = new StringBuffer();
		buf.append("Session Attributes : \n");
		for (int i = 0; attrNames.hasMoreElements(); i++) {
			String name = attrNames.nextElement();
			Object value = session.getAttribute(name);
			buf.append(" [");
			buf.append(i);
			buf.append("] ");
			buf.append(name);
			buf.append("=");
			buf.append(value);
			if (attrNames.hasMoreElements()) {
				buf.append("\n");
			}
		}
		System.out.println(buf);
	}

}
