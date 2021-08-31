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

	// コンストラクタ
	public ConsoleView(Service service) {
		this.service = service;
	}

	public void displayMainMenu() throws Exception {
		System.out.println("メインメニュー");
		System.out.println("１．患者を追加する");
		System.out.println("２．患者を一覧する");
		System.out.println("３．患者を編集する");
		System.out.println("４．患者を削除する");
		System.out.println("５．終了");

		String s = input();// 選択肢受付

		if (s.equals("1")) {
			displayPatientCreate();// 患者追加画面へ
		} else if (s.equals("2")) {
			displayPatientList();// 患者一覧画面へ
			displayMainMenu();// 再帰
		} else if (s.equals("3")) {
			displayPatientUpdate();// 患者情報編集画面へ
		} else if (s.equals("4")) {
			displayPatientDelete();// 患者削除画面へ
		} else if (s.equals("5")) {
			;// 何もせず（終了）
		} else {
			displayMainMenu();// 再帰
		}
	}

	public void displayPatientCreate() throws Exception {
		String name;
		String bloodType;
		String height;

		System.out.println("患者を追加します！");
		System.out.println("氏　名");
		name = input();
		System.out.println("血　液　型");
		bloodType = input();
		System.out.println("身　長");
		height = input();

		// bloodType.toCharArray()[0] 將字串轉換成字元
		displayConfirmPatientCreate(name, bloodType.toCharArray()[0], Double.parseDouble(height));

	}

	public void displayConfirmPatientCreate(String name, char bloodType, double height) throws Exception {
		System.out.println("下記の患者を追加しますが良いですか？");
		System.out.println("氏　名" + name);
		System.out.println("血　液　型" + bloodType);
		System.out.println("身　長" + height);
		System.out.println("-----------------------------------------");
		System.out.println("1. 追加実行");
		System.out.println("2．キャンセル");

		String s = input();

		if (s.equals("1")) {
			// 患者を追加
			service.createPatient(name, bloodType, height);
			displayMainMenu();
		} else if (s.equals("2")) {
			displayMainMenu();
		} else {
			displayConfirmPatientCreate(name, bloodType, height);
		}
	}

	public void displayPatientList() throws Exception {
		System.out.println("患者リストを表示します！");
		for (Patient patient : service.getPatients()) {
			patient.display();// 患者情報を表示
		}
		System.out.println("-----------------------------------------");

	}

	public void displayPatientUpdate() throws Exception {
		System.out.println("患者リストを表示します！");
		// hospital.display();
		System.out.println("-----------------------------------------");

		System.out.println("患者を修正します！");
		System.out.println("患者ID");
		String id = input();
		System.out.println("氏　名");
		String name = input();
		System.out.println("血　液　型");
		String bloodType = input();
		System.out.println("身　長");
		String height = input();

		displayConfirmPatientUpdate(Integer.parseInt(id), name, bloodType.toCharArray()[0], Double.parseDouble(height));

	}

	public void displayConfirmPatientUpdate(int id, String name, char bloodType, double height) throws Exception {

		Patient p = service.getPatient(id);

		System.out.println("下記の患者を編集しますが良いですか？");
		System.out.println("患者ID" + id);
		System.out.println("氏　名" + p.getName());
		System.out.println("血　液　型" + p.getBloodType());
		System.out.println("身　長" + p.getHeight());
		System.out.println("↓");
		System.out.println("氏　名" + name);
		System.out.println("血　液　型" + bloodType);
		System.out.println("身　長" + height);
		System.out.println("-----------------------------------------");
		System.out.println("1. 編集実行");
		System.out.println("2．キャンセル");

		String s = input();// 選択肢受付
		if (s.equals("1")) {
			service.updatePatient(id, name, bloodType, height);
			displayMainMenu();
		} else if (s.equals("2")) {
			displayMainMenu();
		} else {
			displayConfirmPatientUpdate(id, name, bloodType, height);// 再帰
		}
	}

	public void displayPatientDelete() throws Exception {
		System.out.println("患者リストを表示します！");
		// hospital.display();

		System.out.println("-----------------------------------------");

		System.out.println("患者を削除します！");
		System.out.println("患者ID");

		String id = input();

		displayConfirmPatientDelete(Integer.parseInt(id));
	}

	public void displayConfirmPatientDelete(int id) throws Exception {

		// 削除対象患者の確認
		Patient p = service.getPatient(id);

		System.out.println("下記の患者を削除しますが良いですか？");
		System.out.println("患者ID" + id);
		System.out.println("氏　名" + p.getName());
		System.out.println("血　液　型" + p.getBloodType());
		System.out.println("身　長" + p.getHeight());
		System.out.println("-----------------------------------------");
		System.out.println("1. 削除実行");
		System.out.println("2．キャンセル");

		String s = input();// 選択肢受付

		if (s.equals("1")) {

			service.deletePatient(id);
			displayMainMenu();// メインメニューへ戻る
		} else if (s.equals("2")) {
			displayMainMenu();// メインメニューへ戻る
		} else {
			displayConfirmPatientDelete(id);// 再帰
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
