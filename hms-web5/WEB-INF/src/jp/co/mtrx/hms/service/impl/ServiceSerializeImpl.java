/**
 * 
 */
package jp.co.mtrx.hms.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;

import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
public class ServiceSerializeImpl extends Service {
	// コンストラクタ
	public ServiceSerializeImpl(Properties prop) throws Exception {
		super(prop.getProperty("hms.saveData.serialize.filePath"));
	}

	@Override
	protected Object readFromFile(String filePath) throws Exception {
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filePath));
		Object o = stream.readObject();
		stream.close();
		return o;

	}

	@Override
	protected void writeToFile(String filePath, Object o) throws Exception {
		assert o instanceof Serializable : "Serializableオブジェクトではない！";

		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filePath));
		stream.writeObject(o);
		stream.close();
	}

}
