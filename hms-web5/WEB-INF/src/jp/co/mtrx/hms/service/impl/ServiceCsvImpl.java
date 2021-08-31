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
	// �R���X�g���N�^
	public ServiceCsvImpl(Properties prop) throws Exception {
		super(prop.getProperty("hms.saveData.serialize.filePath"));
	}

	@Override
	protected Object readFromFile(String filePath) throws Exception {
		// �a�@
		Hospital h = new Hospital();

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = null; // �s�̕�����
		int lineNo = 0;// �s��
		// 1�s����csv�t�@�C����ǂݍ���
		while ((line = br.readLine()) != null) {
			lineNo++;
			String[] data = line.split(",", 0);// �s���J���}��؂�Ŕz��ɕϊ�

			// �擪�s�͍ŐVID�l
			if (lineNo == 1) {

				// h.getPatient(Integer.parseInt(data[0].trim()));
				h.setNewestPatientId = Integer.parseInt(data[0].trim());
				continue;
			}

			// ���ҏ������o��
			// int id = Integer.parseInt(data[0].trim());
			String name = data[1].trim();
			char bloodType = data[2].trim().toCharArray()[0];
			double height = Double.parseDouble(data[3].trim());
			// ���҂��쐬
			h.createPatient(name, bloodType, height);
		}
		br.close();
		return h;
	}

	@Override
	protected void writeToFile(String filePath, Object o) throws Exception {
		assert o instanceof Hospital : "Hospital�I�u�W�F�N�g�ł͂Ȃ�!";
		Hospital h = (Hospital) o;

		PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(filePath, false)));
		// �w�b�_�[�s
		p.print(h.newestPatientId);// �ŐV����ID�l
		p.println();// ���s
		// ���e�Z�b�g����
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
