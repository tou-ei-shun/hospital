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

import jp.co.mtrx.hms.model.Patient;
import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
@WebServlet("/displayPatientUpdate")
public class DisplayPatientUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		try {
			Service service = (Service) getServletContext().getAttribute("service");

			Patient patient = service.getPatient(Integer.parseInt(id));

//			req.setAttribute("name", patient.getName());
//			req.setAttribute("bloodType", String.valueOf(patient.getBloodType()));
//			req.setAttribute("height", String.valueOf(patient.getHeight()));

			HttpSession session = req.getSession();
			session.setAttribute("name", patient.getName());
			session.setAttribute("bloodType", String.valueOf(patient.getBloodType()));
			session.setAttribute("height", String.valueOf(patient.getHeight()));

			System.out.println("SERVLET :" + getClass().getName() + "#doGet()");

		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/jsp/patientUpdate.jsp").forward(req, resp);

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
//		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("bloodType", bloodType);
		session.setAttribute("height", height);

		System.out.println("SERVLET :" + getClass().getName() + "#doPost()");

		System.out.println("SERVLET :" + getClass().getName() + "#doPost()");
		getServletContext().getRequestDispatcher("/jsp/patientUpdate.jsp").forward(req, resp);
	}

}
