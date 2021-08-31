/**
 * 
 */
package jp.co.mtrx.hms.model;

import java.io.Serializable;

/**
 * @author t-eishun
 *
 */
public class Hospital implements Serializable {
	// TODO Auto-generated method stub

	public int newestPatientId = 1000;
	public int setNewestPatientId = 0;

	public Patient[] patients = new Patient[6];

	public int newPatientId() {
		return ++newestPatientId;
	}

	/**
	 * @param id
	 * @return
	 */
	public Patient getPatient(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null && patients[i].getId() == id) {
				return patients[i];
			}
		}
		return null;

	}

	public void createPatient(String name, char bloodType, double height) {
		// �ǉ��\�C���f�b�N�X�擾
		int indexToCreate = findIndex(-1);
		// �z��𑝗ʂ��Ēǉ��\�C���f�b�N�X�Ď擾
		if (indexToCreate == -1) {
			Patient[] newPatients = new Patient[patients.length + 1];
			for (int i = 0; i < patients.length; i++) {
				newPatients[i] = patients[i];
			}
			patients = newPatients;
			indexToCreate = findIndex(-1);
		}
		// �V�������ҍ쐬
		patients[indexToCreate] = new Patient(newPatientId(), name, bloodType, height);

	}

	public void display() {
		System.out.println("---���҂��ꗗ����---");

		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null) {
				patients[i].display();
			} else {
				System.out.println("\tnull");
			}
		}
	}

	public void updatePatient(int id, String name, char bloodType, double height) {
		System.out.println("---���҂��X�V����(" + id + "," + name + "," + bloodType + "," + height + ") ---");

		int indexToUpdate = findIndex(id);
		patients[indexToUpdate].updatePatient(id, name, bloodType, height);
	}

	public void deletePatient(int id) {
		System.out.println("---���ҏ����폜����i" + id + "���폜�j--");
		int idexToDelete = findIndex(id);

		if (idexToDelete >= 0) {
			for (; idexToDelete + 1 < patients.length; idexToDelete++) {
				patients[idexToDelete] = patients[idexToDelete + 1];
			}
			patients[idexToDelete] = null;
		}
	}

	private int findIndex(int id) {
		int indexToFind = -1;

		for (int i = 0; i < patients.length; i++) {
			if ((patients[i] == null && id == -1) || (patients[i] != null && patients[i].getId() == id)) {
				indexToFind = i;
				break;
			}
		}
		return indexToFind;
	}

}
