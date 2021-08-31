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
	 * プロパティファイルからプロパティを読み込みます。
	 * 
	 * @param filePath ファイルパス
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
	 * 文字列を内部処理用の文字コート(UTF8)を変更します。
	 * 
	 * @param s 文字列
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
