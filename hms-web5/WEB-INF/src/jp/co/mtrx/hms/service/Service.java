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

	// csv形式である場合のsaveFileFormatの値
	private static final String SAVE_FILE_FORMAT_CSV = "csv";

	// 保存ファイル名
	private String saveFileName = null;

	// DBでないとき使用
	private Hospital hospital = null;// 唯一の病院

	// Serviceのインスタンスを取得する
	public static Service newInstance(Properties prop) throws Exception {
		Service service = null;

		// DB保存
		if (Boolean.parseBoolean(prop.getProperty("hms.db.enabled"))) {
			service = new ServiceJdbcImpl(prop);
		} else if (prop.getProperty("hms.saveData.format").equals(SAVE_FILE_FORMAT_CSV)) {
			service = new ServiceCsvImpl(prop); // csv保存
		} else {// シリアライズ保存
			service = new ServiceSerializeImpl(prop);
		}
		return service;
	}

	// コンストラクタ
	public Service(String saveFilePath) throws Exception {
		this.saveFileName = saveFilePath;

		// 病院の初期化
		if (isFilePathExists(saveFileName)) {
			hospital = (Hospital) readFromFile(saveFileName);
		} else {
			hospital = new Hospital();
		}
	}

	/*
	 * ファイルまたはフォルダーが存在するかどうかを取得する
	 * 
	 * @param filePath
	 * 
	 * @return 存在する場合 true
	 */
	private boolean isFilePathExists(String filePath) {
		if (filePath == null) {
			return false;
		}

		File file = new File(filePath); // filePath:data/hms.ser

		return file.exists();
	}

	// ファイルから読み込み
	protected abstract Object readFromFile(String filePath) throws Exception;

	// ファイルを書き込み
	protected abstract void writeToFile(String filePath, Object o) throws Exception;

	// 患者リストを取得する
	public List<Patient> getPatients() throws Exception {
		return Arrays.asList(hospital.patients);
	}

	// 患者を取得する
	public Patient getPatient(int id) throws Exception {
		return hospital.getPatient(id);
	}

	// 患者を追加する
	public void createPatient(String name, char bloodType, double height) throws Exception {
		// 追加実行
		hospital.createPatient(name, bloodType, height);
		// データ保管
		writeToFile(saveFileName, hospital);
	}

	// 患者を更新する
	public void updatePatient(int id, String name, char bloodType, double height) throws Exception {
		// 更新実行
		hospital.updatePatient(id, name, bloodType, height);
		// データ保管
		writeToFile(saveFileName, hospital);
	}

	// 患者を削除する
	public void deletePatient(int id) throws Exception {
		// 削除実行
		hospital.deletePatient(id);
		// データ保管
		writeToFile(saveFileName, hospital);
	}
}
