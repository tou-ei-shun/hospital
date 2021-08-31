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

import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
@WebServlet("/submitPatientDelete")
public class SubmitPatientDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String id = Utility.transfer2Unicode(req.getParameter("id"));
		String id = req.getParameter("id");

		try {
			// サービス取得
			Service service = (Service) getServletContext().getAttribute("service");
			// 追加実行
			service.deletePatient(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/jsp/patientList.jsp").forward(req, resp);
	}

}
