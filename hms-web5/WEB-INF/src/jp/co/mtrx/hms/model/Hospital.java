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
		// 追加可能インデックス取得
		int indexToCreate = findIndex(-1);
		// 配列を増量して追加可能インデックス再取得
		if (indexToCreate == -1) {
			Patient[] newPatients = new Patient[patients.length + 1];
			for (int i = 0; i < patients.length; i++) {
				newPatients[i] = patients[i];
			}
			patients = newPatients;
			indexToCreate = findIndex(-1);
		}
		// 新しい患者作成
		patients[indexToCreate] = new Patient(newPatientId(), name, bloodType, height);

	}

	public void display() {
		System.out.println("---患者を一覧する---");

		for (int i = 0; i < patients.length; i++) {
			if (patients[i] != null) {
				patients[i].display();
			} else {
				System.out.println("\tnull");
			}
		}
	}

	public void updatePatient(int id, String name, char bloodType, double height) {
		System.out.println("---患者を更新する(" + id + "," + name + "," + bloodType + "," + height + ") ---");

		int indexToUpdate = findIndex(id);
		patients[indexToUpdate].updatePatient(id, name, bloodType, height);
	}

	public void deletePatient(int id) {
		System.out.println("---患者情報を削除する（" + id + "を削除）--");
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
