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
			// プロパティ
			Properties prop = Utility.readPropertiesFromFile("hms.properties");

			// サービスの取得
			Service service = Service.newInstance(prop);

			// サービスをApplication Scopeに保管
			evt.getServletContext().setAttribute("service", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
