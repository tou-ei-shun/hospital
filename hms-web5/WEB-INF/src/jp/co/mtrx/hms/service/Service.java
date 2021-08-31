/**
 * 
 */
package jp.co.mtrx.hms.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import jp.co.mtrx.hms.model.Hospital;
import jp.co.mtrx.hms.model.Patient;
import jp.co.mtrx.hms.service.impl.ServiceCsvImpl;
import jp.co.mtrx.hms.service.impl.ServiceJdbcImpl;
import jp.co.mtrx.hms.service.impl.ServiceSerializeImpl;

/**
 * @author t-eishun
 *
 */
public abstract class Service {

	// csv�`���ł���ꍇ��saveFileFormat�̒l
	private static final String SAVE_FILE_FORMAT_CSV = "csv";

	// �ۑ��t�@�C����
	private String saveFileName = null;

	// DB�łȂ��Ƃ��g�p
	private Hospital hospital = null;// �B��̕a�@

	// Service�̃C���X�^���X���擾����
	public static Service newInstance(Properties prop) throws Exception {
		Service service = null;

		// DB�ۑ�
		if (Boolean.parseBoolean(prop.getProperty("hms.db.enabled"))) {
			service = new ServiceJdbcImpl(prop);
		} else if (prop.getProperty("hms.saveData.format").equals(SAVE_FILE_FORMAT_CSV)) {
			service = new ServiceCsvImpl(prop); // csv�ۑ�
		} else {// �V���A���C�Y�ۑ�
			service = new ServiceSerializeImpl(prop);
		}
		return service;
	}

	// �R���X�g���N�^
	public Service(String saveFilePath) throws Exception {
		this.saveFileName = saveFilePath;

		// �a�@�̏�����
		if (isFilePathExists(saveFileName)) {
			hospital = (Hospital) readFromFile(saveFileName);
		} else {
			hospital = new Hospital();
		}
	}

	/*
	 * �t�@�C���܂��̓t�H���_�[�����݂��邩�ǂ������擾����
	 * 
	 * @param filePath
	 * 
	 * @return ���݂���ꍇ true
	 */
	private boolean isFilePathExists(String filePath) {
		if (filePath == null) {
			return false;
		}

		File file = new File(filePath); // filePath:data/hms.ser

		return file.exists();
	}

	// �t�@�C������ǂݍ���
	protected abstract Object readFromFile(String filePath) throws Exception;

	// �t�@�C������������
	protected abstract void writeToFile(String filePath, Object o) throws Exception;

	// ���҃��X�g���擾����
	public List<Patient> getPatients() throws Exception {
		return Arrays.asList(hospital.patients);
	}

	// ���҂��擾����
	public Patient getPatient(int id) throws Exception {
		return hospital.getPatient(id);
	}

	// ���҂�ǉ�����
	public void createPatient(String name, char bloodType, double height) throws Exception {
		// �ǉ����s
		hospital.createPatient(name, bloodType, height);
		// �f�[�^�ۊ�
		writeToFile(saveFileName, hospital);
	}

	// ���҂��X�V����
	public void updatePatient(int id, String name, char bloodType, double height) throws Exception {
		// �X�V���s
		hospital.updatePatient(id, name, bloodType, height);
		// �f�[�^�ۊ�
		writeToFile(saveFileName, hospital);
	}

	// ���҂��폜����
	public void deletePatient(int id) throws Exception {
		// �폜���s
		hospital.deletePatient(id);
		// �f�[�^�ۊ�
		writeToFile(saveFileName, hospital);
	}
}
