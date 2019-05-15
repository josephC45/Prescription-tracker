package main;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;


/* Description:
 * <p> The main class begins by greeting the user with various sayings depending on the time of day.<p>
 * <p> Next, the statement, "This is a prescription tracker" is printed to the console to inform the user what the 
 * purpose of the program is.<p>
 * <p> Lastly, a instance of the PrescriptionMap class is created and called map, which allows the calling of methods within
 * the PrescriptionMap class<p>
 * <p> Details on the information found in the method calls can be found in the documentation provided in the PrescriptionMap class.<p>
 * 
 * @author: Joseph Curto
 * @version: 05/15/2019
 */
public class Main {
	
	public static PrescriptionMap map = new PrescriptionMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timeOfDay();
		System.out.println("This is a prescription tracker");
		System.out.println();
		
		try {
			map.medDocumentation();
			map.deletionPrompt();
			System.out.println();
			map.alterations();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end main
	
	/*
	 * The timeOfDay method checks the time on a 24hr base and returns the specified greeting.
	 */
	public static void timeOfDay() {
		Date date = new Date();
		
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("E");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yy");
		
		System.out.println("Today is " + dateFormat1.format(date) + " " + dateFormat2.format(date));
	}//end timeOfDay

}//end main 
