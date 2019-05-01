package main;
import java.util.Calendar;


/* Description:
 * <p> The main class begins by greeting the user with various sayings depending on the time of day.<p>
 * <p> Next, the statement, "This is a prescription tracker" is printed to the console to inform the user what the 
 * purpose of the program is.<p>
 * <p> Lastly, a instance of the PrescriptionMap class is created and called map, which allows the calling of methods within
 * the PrescriptionMap class<p>
 * <p> Details on the information found in the method calls can be found in the documentation provided in the PrescriptionMap class.<p>
 * 
 * @author: Joseph Curto
 * @version: 04/27/2019
 */
public class Main {
	
	public static PrescriptionMap map = new PrescriptionMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timeOfDay();
		System.out.println("This is a prescription tracker");
		System.out.println();
		map.medDocumentation();
		
		map.deletionPrompt();
		System.out.println();
		
		map.alterations();
	}//end main
	
	/*
	 * The timeOfDay method checks the time on a 24hr base and returns the specified greeting.
	 */
	public static void timeOfDay() {
		Calendar cal = Calendar.getInstance();
		int time = cal.get(Calendar.HOUR_OF_DAY);
		
		if(time >= 0 && time < 12) {
			System.out.println("Good morning user! It is " + cal.getTime());
		}
		else if(time >= 12 && time <= 15) {
			System.out.println("Good afternoon user! It is " + cal.getTime());
		}
		else if(time > 15 && time <= 19) {
			System.out.println("Good evening user! It is " + cal.getTime());
		}
	}//end timeOfDay

}//end main 
