/**
 * 
 */
package jp.co.mtrx.hms.model;

import java.io.Serializable;

/**
 * @author t-eishun
 *
 */
public class Patient implements Serializable {
	private int id = 0;
	private String name = null;
	private char bloodType = ' ';
	private double height = 0d;

	/**
	 * @param name
	 * @param bloodType
	 * @param height
	 */
	public Patient(int id, String name, char bloodType, double height) {
		// TODO Auto-generated method stub
		this.id = id;
		this.name = name;
		this.bloodType = bloodType;
		this.height = height;

	}

	public void updatePatient(int id, String name, char bloodType, double height) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.bloodType = bloodType;
	}

	public void update(String name, char bloodType, double height) {
		this.name = name;
		this.height = height;
		this.bloodType = bloodType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBloodType(char bloodType) {
		this.bloodType = bloodType;
	}

	public char getBloodType() {
		return bloodType;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void display() {
//			System.out.println("id :" + id + "name :" + "bloodType :" + bloodType + "height" + height);
		System.out.println(
				"id :" + id + "  " + "name :" + name + "  " + "bloodType :" + bloodType + "  " + "height :" + height);
	}

}
