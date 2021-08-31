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

	// JDBC�R�l�N�V����
	private Connection connection = null;
	// �a�@ID
	private int hospitalId = -1;

	// �R���X�g���N�^
	public ServiceJdbcImpl(Properties prop) throws Exception {
		super(null);

		initializeDB(prop.getProperty("hms.db.driver"), prop.getProperty("hms.db.url"),
				prop.getProperty("hms.db.username"), prop.getProperty("hms.db.password"));
	}

	@Override
	protected Object readFromFile(String filePath) throws Exception {
		return null;// �������Ȃ�
	}

	@Override
	protected void writeToFile(String filePath, Object o) throws Exception {
		// �������Ȃ�
	}

	@Override
	// ���҃��X�g���擾����
	public List<Patient> getPatients() throws Exception {
		return queryPatients(false);
	}

	@Override
	// ���҂��擾����
	public Patient getPatient(int id) throws Exception {

		return queryPatient(id);

	}

	@Override
	// ���҂�ǉ�����
	public void createPatient(String name, char bloodType, double height) throws Exception {
		insertPatient(new Patient(-1, name, bloodType, height));
	}

	@Override
	// ���҂��X�V����
	public void updatePatient(int id, String name, char bloodType, double height) throws Exception {
		Patient p = getPatient(id);
		p.update(name, bloodType, height);
		updatePatient(p);// �X�V���s
	}

	@Override
	// ���҂��폜����
	public void deletePatient(int id) throws Exception {
		deletePatient(getPatient(id));// �폜���s
	}

	// DB����������
	private void initializeDB(String driverName, String url, String userName, String password) throws Exception {
		// �h���C�o�����[�h
		Class.forName(driverName);
		// �R�l�N�V�����쐬
		connection = (Connection) DriverManager.getConnection(url, userName, password);
		// �g�����U�N�V�������[�h
		connection.setAutoCommit(false);

		// �a�@id�擾
		Statement stmt = (Statement) connection.createStatement();
		ResultSet rs = stmt.executeQuery("select id from hospital;");
		rs.next();
		hospitalId = rs.getInt(1);
	}

	// DB���犳�҃��X�g���擾
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

	// DB���犳�҂��擾
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

	// DB�Ɋ��҂�ǉ�
	private void insertPatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate("insert into patient(hospitalId, name, bloodType, height) values ('" + hospitalId + "','"
				+ patient.getName() + "','" + Character.toString(patient.getBloodType()) + "','" + patient.getHeight()
				+ "');");
		connection.commit();
		stmt.close();
	}

	// DB�̊��҂��폜
	private void deletePatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate("delete from patient where id = '" + patient.getId() + "';");
		connection.commit();
		stmt.close();
	}

	// DB�̊��ҏ����X�V
	private void updatePatient(Patient patient) throws Exception {
		Statement stmt = (Statement) connection.createStatement();
		stmt.executeUpdate(
				"update patient set name = '" + patient.getName() + "',bloodType = '" + patient.getBloodType()
						+ "',height = '" + patient.getHeight() + "' where id = '" + patient.getId() + "';");
		connection.commit();
		stmt.close();
	}

}
