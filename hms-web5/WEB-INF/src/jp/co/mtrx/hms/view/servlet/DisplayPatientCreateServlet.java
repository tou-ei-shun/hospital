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
@WebServlet("/displayPatientCreate")
public class DisplayPatientCreateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 入力欄の初期値をセットする
//		req.setAttribute("name", "名前を入れる");
//		req.setAttribute("bloodType", "B");
//		req.setAttribute("height", "0");

		HttpSession session = req.getSession();
		session.setAttribute("name", "名前を入れる");
		session.setAttribute("bloodType", "B");
		session.setAttribute("height", "0");

		System.out.println("SERVLET :" + getClass().getName() + "#doGet()");
		getServletContext().getRequestDispatcher("/jsp/patientCreate.jsp").forward(req, resp);
	}

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
		getServletContext().getRequestDispatcher("/jsp/patientCreate.jsp").forward(req, resp);

	}

}
