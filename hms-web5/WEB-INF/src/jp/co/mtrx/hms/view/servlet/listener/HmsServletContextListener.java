/**
 * 
 */
package jp.co.mtrx.hms.view.servlet.listener;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import jp.co.mtrx.hms.service.Service;
import jp.co.mtrx.hms.util.Utility;

/**
 * @author t-eishun
 *
 */
@WebListener
public class HmsServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent evt) {

	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		try {
			// �v���p�e�B
			Properties prop = Utility.readPropertiesFromFile("hms.properties");

			// �T�[�r�X�̎擾
			Service service = Service.newInstance(prop);

			// �T�[�r�X��Application Scope�ɕۊ�
			evt.getServletContext().setAttribute("service", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
