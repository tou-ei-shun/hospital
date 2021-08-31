/**
 * 
 */
package jp.co.mtrx.hms.util;

import java.io.BufferedInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.io.InputStream;

/**
 * @author t-eishun
 *
 */
public class Utility {

	/**
	 * 
	 * �v���p�e�B�t�@�C������v���p�e�B��ǂݍ��݂܂��B
	 * 
	 * @param filePath �t�@�C���p�X
	 * @return
	 * @throws Exception
	 * 
	 */

	public static Properties readPropertiesFromFile(String filePath) throws Exception {
		Properties properties = new Properties();
		InputStream in = new BufferedInputStream(Utility.class.getClassLoader().getResourceAsStream(filePath));
		properties.load(in);
		in.close();
		return properties;
	}

	/*
	 * 
	 * ���������������p�̕����R�[�g(UTF8)��ύX���܂��B
	 * 
	 * @param s ������
	 * 
	 * @return
	 * 
	 * @throws UnsupportedEncodingException
	 * 
	 */

	public static String transfer2Unicode(String s) throws UnsupportedEncodingException {
		return new String(s.getBytes("8859_1"), "JISAutoDetect");
	}

}
