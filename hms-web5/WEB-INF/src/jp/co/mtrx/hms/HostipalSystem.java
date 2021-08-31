/**
 * 
 */
package jp.co.mtrx.hms;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import jp.co.mtrx.hms.service.Service;
import jp.co.mtrx.hms.view.ConsoleView;

/**
 * @author t-eishun
 *
 */
public class HostipalSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// プロパティ
			Properties prop = readPropertiesFromFile("hms.properties");
			// サービスの取得
			Service service = Service.newInstance(prop);
			// ビュー
			ConsoleView view = new ConsoleView(service);
			view.displayMainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// プロパティファイルからプロパティを読み込みます。
	private static Properties readPropertiesFromFile(String filePath) throws Exception {
		Properties properties = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		properties.load(in);
		in.close();
		return properties;
	}

}