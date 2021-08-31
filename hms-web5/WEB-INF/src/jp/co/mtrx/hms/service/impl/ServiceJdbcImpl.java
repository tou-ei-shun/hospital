/**
 * 
 */
package jp.co.mtrx.hms.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jp.co.mtrx.hms.model.Patient;
import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
public class ServiceJdbcImpl extends Service {

	// JDBCコネクション
	private Connection connection = null;
	// 病院ID
	private int hospitalId = -1;

	// コンストラクタ
	public ServiceJdbcImpl(Properties prop) throws Exception {
		super(null);

		initializeDB(prop.getProperty("hms.db.driver"), prop.getProperty("hms.db.url"),
				prop.getProperty("hms.db.username"), prop.getProperty("hms.db.password"));
	}

	@Override
	protected Object readFromFile(String filePath) throws Exception {
		return null;// 何もしない
	}

	@Override
	protected void writeToFile(String filePath, Object o) throws Exception {
		// 何もしない
	}

	@Override
	// 患者リストを取得する
	public List<Patient> getPatients() throws Exception {
		return queryPatients(false);
	}

	@Override
	// 患者を取得する
	public Patient getPatient(int id) throws Exception {

		return queryPatient(id);

	}

	@Override
	// 患者を追加する
	public void createPatient(String name, char bloodType, double height) throws Exception {
		insertPatient(new Patient(-1, name, bloodType, height));
	}

	@Override
	// 患者を更新する
	public void updatePatient(int id, String name, char bloodType, double height) throws Exception {
		Patient p = getPatient(id);
		p.update(name, bloodType, height);
		updatePatient(p);// 更新実行
	}

	@Override
	// 患者を削除する
	public void deletePatient(int id) throws Exception {
		deletePatient(getPatient(id));// 削除実行
	}

	// DB初期化する
	private void initializeDB(String driverName, String url, String userName, String password) throws Exception {
		// ドライバをロード
		Class.forName(driverName);
		// コネクション作成
		connection = (Connection) DriverManager.getConnection(url, userName, password);
		// トランザクションモード
		connection.setAutoCommit(false);

		// 病院id取得
		Statement stmt = (Statement) connection.createStatement();
		ResultSet rs = stmt.executeQuery("select id from hospital;");
		rs.next();
		hospitalId = rs.getInt(1);
	}

	// DBから患者リストを取得
	private List<Patient> queryPatients(boolean orderByHeightASC) throws Exception {
		List<Patient> patients = new ArrayList<Patient>();

		Statement stmt = (Statement) connection.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,bloodType,height from patient where hospitalId = '"
				+ hospitalId + "'" + (orderByHeightASC ? "order by height ASC;" : ";"));
		while (rs.next()) {
			patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getDouble(4)));
		}
		rs.close();
		stmt.close();

		return patients;
	}

	// DBから患者を取得
	private Patient queryPatient(int id) throws Exception {
		Patient patient = null;

		Statement stmt = (Statement) connection.createStatement();
		ResultSet rs = stmt.executeQuery("select id, name,bloodType, height from patient where id = '" + id + "'");
		if (rs.next()) {
			patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getDouble(4));
			rs.close();
			stmt.close();
		}
		return patient;
	}

	// DBに患者を追加
	private void insertPatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate("insert into patient(hospitalId, name, bloodType, height) values ('" + hospitalId + "','"
				+ patient.getName() + "','" + Character.toString(patient.getBloodType()) + "','" + patient.getHeight()
				+ "');");
		connection.commit();
		stmt.close();
	}

	// DBの患者を削除
	private void deletePatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate("delete from patient where id = '" + patient.getId() + "';");
		connection.commit();
		stmt.close();
	}

	// DBの患者情報を更新
	private void updatePatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate(
				"update patient set name = '" + patient.getName() + "',bloodType = '" + patient.getBloodType()
						+ "',height = '" + patient.getHeight() + "' where id = '" + patient.getId() + "';");
		connection.commit();
		stmt.close();
	}

}
