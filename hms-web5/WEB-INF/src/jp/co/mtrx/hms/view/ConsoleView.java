/**
 * 
 */
package jp.co.mtrx.hms.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import jp.co.mtrx.hms.model.Patient;
import jp.co.mtrx.hms.service.Service;

/**
 * @author t-eishun
 *
 */
public class ConsoleView {

	Service service = null;

	// �R���X�g���N�^
	public ConsoleView(Service service) {
		this.service = service;
	}

	public void displayMainMenu() throws Exception {
		System.out.println("���C�����j���[");
		System.out.println("�P�D���҂�ǉ�����");
		System.out.println("�Q�D���҂��ꗗ����");
		System.out.println("�R�D���҂�ҏW����");
		System.out.println("�S�D���҂��폜����");
		System.out.println("�T�D�I��");

		String s = input();// �I������t

		if (s.equals("1")) {
			displayPatientCreate();// ���Ғǉ���ʂ�
		} else if (s.equals("2")) {
			displayPatientList();// ���҈ꗗ��ʂ�
			displayMainMenu();// �ċA
		} else if (s.equals("3")) {
			displayPatientUpdate();// ���ҏ��ҏW��ʂ�
		} else if (s.equals("4")) {
			displayPatientDelete();// ���ҍ폜��ʂ�
		} else if (s.equals("5")) {
			;// ���������i�I���j
		} else {
			displayMainMenu();// �ċA
		}
	}

	public void displayPatientCreate() throws Exception {
		String name;
		String bloodType;
		String height;

		System.out.println("���҂�ǉ����܂��I");
		System.out.println("���@��");
		name = input();
		System.out.println("���@�t�@�^");
		bloodType = input();
		System.out.println("�g�@��");
		height = input();

		// bloodType.toCharArray()[0] �������z��������
		displayConfirmPatientCreate(name, bloodType.toCharArray()[0], Double.parseDouble(height));

	}

	public void displayConfirmPatientCreate(String name, char bloodType, double height) throws Exception {
		System.out.println("���L�̊��҂�ǉ����܂����ǂ��ł����H");
		System.out.println("���@��" + name);
		System.out.println("���@�t�@�^" + bloodType);
		System.out.println("�g�@��" + height);
		System.out.println("-----------------------------------------");
		System.out.println("1. �ǉ����s");
		System.out.println("2�D�L�����Z��");

		String s = input();

		if (s.equals("1")) {
			// ���҂�ǉ�
			service.createPatient(name, bloodType, height);
			displayMainMenu();
		} else if (s.equals("2")) {
			displayMainMenu();
		} else {
			displayConfirmPatientCreate(name, bloodType, height);
		}
	}

	public void displayPatientList() throws Exception {
		System.out.println("���҃��X�g��\�����܂��I");
		for (Patient patient : service.getPatients()) {
			patient.display();// ���ҏ���\��
		}
		System.out.println("-----------------------------------------");

	}

	public void displayPatientUpdate() throws Exception {
		System.out.println("���҃��X�g��\�����܂��I");
		// hospital.display();
		System.out.println("-----------------------------------------");

		System.out.println("���҂��C�����܂��I");
		System.out.println("����ID");
		String id = input();
		System.out.println("���@��");
		String name = input();
		System.out.println("���@�t�@�^");
		String bloodType = input();
		System.out.println("�g�@��");
		String height = input();

		displayConfirmPatientUpdate(Integer.parseInt(id), name, bloodType.toCharArray()[0], Double.parseDouble(height));

	}

	public void displayConfirmPatientUpdate(int id, String name, char bloodType, double height) throws Exception {

		Patient p = service.getPatient(id);

		System.out.println("���L�̊��҂�ҏW���܂����ǂ��ł����H");
		System.out.println("����ID" + id);
		System.out.println("���@��" + p.getName());
		System.out.println("���@�t�@�^" + p.getBloodType());
		System.out.println("�g�@��" + p.getHeight());
		System.out.println("��");
		System.out.println("���@��" + name);
		System.out.println("���@�t�@�^" + bloodType);
		System.out.println("�g�@��" + height);
		System.out.println("-----------------------------------------");
		System.out.println("1. �ҏW���s");
		System.out.println("2�D�L�����Z��");

		String s = input();// �I������t
		if (s.equals("1")) {
			service.updatePatient(id, name, bloodType, height);
			displayMainMenu();
		} else if (s.equals("2")) {
			displayMainMenu();
		} else {
			displayConfirmPatientUpdate(id, name, bloodType, height);// �ċA
		}
	}

	public void displayPatientDelete() throws Exception {
		System.out.println("���҃��X�g��\�����܂��I");
		// hospital.display();

		System.out.println("-----------------------------------------");

		System.out.println("���҂��폜���܂��I");
		System.out.println("����ID");

		String id = input();

		displayConfirmPatientDelete(Integer.parseInt(id));
	}

	public void displayConfirmPatientDelete(int id) throws Exception {

		// �폜�Ώۊ��҂̊m�F
		Patient p = service.getPatient(id);

		System.out.println("���L�̊��҂��폜���܂����ǂ��ł����H");
		System.out.println("����ID" + id);
		System.out.println("���@��" + p.getName());
		System.out.println("���@�t�@�^" + p.getBloodType());
		System.out.println("�g�@��" + p.getHeight());
		System.out.println("-----------------------------------------");
		System.out.println("1. �폜���s");
		System.out.println("2�D�L�����Z��");

		String s = input();// �I������t

		if (s.equals("1")) {

			service.deletePatient(id);
			displayMainMenu();// ���C�����j���[�֖߂�
		} else if (s.equals("2")) {
			displayMainMenu();// ���C�����j���[�֖߂�
		} else {
			displayConfirmPatientDelete(id);// �ċA
		}
	}

	public static String input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
