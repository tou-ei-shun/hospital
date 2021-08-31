/**
 * 
 */
package jp.co.mtrx.hms.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Properties;

import jp.co.mtrx.hms.model.Hospital;
import jp.co.mtrx.hms.model.Patient;
import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
public class ServiceCsvImpl extends Service {
	// コンストラクタ
	public ServiceCsvImpl(Properties prop) throws Exception {
		super(prop.getProperty("hms.saveData.serialize.filePath"));
	}

	@Override
	protected Object readFromFile(String filePath) throws Exception {
		// 病院
		Hospital h = new Hospital();

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = null; // 行の文字列
		int lineNo = 0;// 行数
		// 1行ずつcsvファイルを読み込み
		while ((line = br.readLine()) != null) {
			lineNo++;
			String[] data = line.split(",", 0);// 行をカンマ区切りで配列に変換

			// 先頭行は最新ID値
			if (lineNo == 1) {

				// h.getPatient(Integer.parseInt(data[0].trim()));
				h.setNewestPatientId = Integer.parseInt(data[0].trim());
				continue;
			}

			// 患者情報を取り出し
			// int id = Integer.parseInt(data[0].trim());
			String name = data[1].trim();
			char bloodType = data[2].trim().toCharArray()[0];
			double height = Double.parseDouble(data[3].trim());
			// 患者を作成
			h.createPatient(name, bloodType, height);
		}
		br.close();
		return h;
	}

	@Override
	protected void writeToFile(String filePath, Object o) throws Exception {
		assert o instanceof Hospital : "Hospitalオブジェクトではない!";
		Hospital h = (Hospital) o;

		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(filePath, false)));
		// ヘッダー行
		p.print(h.newestPatientId);// 最新患者ID値
		p.println();// 改行
		// 内容セットする
		for (int i = 0; i < h.patients.length; i++) {
			Patient patient = h.patients[i];
			if (patient == null) {
				continue;
			}
			p.print(patient.getId());
			p.print(",");
			p.print(patient.getName());
			p.print(",");
			p.print(patient.getBloodType());
			p.print(",");
			p.print(patient.getHeight());
			p.println(",");
		}
		p.close();

	}
}
