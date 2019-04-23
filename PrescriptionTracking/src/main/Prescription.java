package main;

public class Prescription {
	private String prescriptionName;
	private float dosage;
	private int dailyIntake;
	private int hoursApart;

	public Prescription(String prescriptionName, float dosage, int dailyIntake, int hoursApart) {
		this.prescriptionName = prescriptionName;
		this.dosage = dosage;
		this.dailyIntake = dailyIntake;
		this.hoursApart = hoursApart;
	}//end constructor
	
	
	public String getName() {
		return this.prescriptionName;
	}//end getName
	
	public void setName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}//end setName
	
	
	public float getDosage() {
		return this.dosage;
	}//end getDosage
	
	public void setDosage(float dosage) {
		this.dosage = dosage;
	}//end setDosage
	
	
	public int getDailyIntake() {
		return this.dailyIntake;
	}//end get dailyIntake
	
	public void setDailyIntake(int dailyIntake) {
		this.dailyIntake = dailyIntake;
	}//end set dailyintake
	
	public int getHoursApart() {
		return this.hoursApart;
	}//end get hours
	
	public void setHoursApart(int hoursApart) {
		this.hoursApart = hoursApart;
	}//end sethours
	
	//compares states alphabetically
	public int compareTo(Prescription per) {
		return this.getName().compareTo(per.getName());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%1$-25s", prescriptionName));
		sb.append(String.format("%1$-15s", dosage));
		sb.append(String.format("%1$-14s", dailyIntake));
		sb.append(String.format("%1$-13s", hoursApart));
		
		return sb.toString();
	}//end toString
}//end class
