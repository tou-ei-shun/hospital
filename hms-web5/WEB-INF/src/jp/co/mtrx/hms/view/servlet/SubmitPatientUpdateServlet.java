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
@WebServlet("/submitPatientUpdate")
public class SubmitPatientUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = Utility.transfer2Unicode(req.getParameter("id"));
//		String name = Utility.transfer2Unicode(req.getParameter("name"));
//		String bloodType = Utility.transfer2Unicode(req.getParameter("bloodType"));
//		String height = Utility.transfer2Unicode(req.getParameter("height"));

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String bloodType = req.getParameter("bloodType");
		String height = req.getParameter("height");

		try {
			// サービス取得
			Service service = (Service) getServletContext().getAttribute("service");
			// 編集実行
			service.updatePatient(Integer.parseInt(id), name, bloodType.charAt(0), Double.parseDouble(height));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("SERVLET :" + getClass().getName() + "#doPost()");
		getServletContext().getRequestDispatcher("/jsp/patientList.jsp").forward(req, resp);
	}

}
