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

/**
 * @author t-eishun
 *
 */
@WebServlet("/displayPatientList")
public class DisplayPatientListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/jsp/patientList.jsp").forward(req, resp);
	}
}
