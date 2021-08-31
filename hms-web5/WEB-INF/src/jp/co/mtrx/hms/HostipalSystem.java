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
			// �v���p�e�B
			Properties prop = readPropertiesFromFile("hms.properties");
			// �T�[�r�X�̎擾
			Service service = Service.newInstance(prop);
			// �r���[
			ConsoleView view = new ConsoleView(service);
			view.displayMainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// �v���p�e�B�t�@�C������v���p�e�B��ǂݍ��݂܂��B
	private static Properties readPropertiesFromFile(String filePath) throws Exception {
		Properties properties = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		properties.load(in);
		in.close();
		return properties;
	}

}