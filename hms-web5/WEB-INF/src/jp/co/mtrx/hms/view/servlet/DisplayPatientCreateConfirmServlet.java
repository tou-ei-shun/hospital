/**
 * 
 */
package jp.co.mtrx.hms.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author t-eishun
 *
 */

@WebServlet("/displayPatientCreateConfirm")
public class DisplayPatientCreateConfirmServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String name = Utility.transfer2Unicode(req.getParameter("name"));
//		String bloodType = Utility.transfer2Unicode(req.getParameter("bloodType"));
//		String height = Utility.transfer2Unicode(req.getParameter("height"));

		String name = req.getParameter("name");
		String bloodType = req.getParameter("bloodType");
		String height = req.getParameter("height");

//		req.setAttribute("name", name);
//		req.setAttribute("bloodType", bloodType);
//		req.setAttribute("height", height);

		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		session.setAttribute("bloodType", bloodType);
		session.setAttribute("height", height);

		System.out.println("SERVLET :" + getClass().getName() + "#doPost()");

		// 入力チェック(身長のみ)
		if (!height.matches("^-?(0|[1-9]\\d*)(\\.\\d+|)$")) {
			req.setAttribute("error", "身長は半角数値で入力してください。");
			getServletContext().getRequestDispatcher("/jsp/patientCreate.jsp").forward(req, resp);
		}
		getServletContext().getRequestDispatcher("/jsp/patientCreateConfirm.jsp").forward(req, resp);
	}

}
