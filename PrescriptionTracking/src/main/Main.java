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
 * @version: 07/28/2019
 */
public class Main {
	
	public static PrescriptionMap map = new PrescriptionMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		currentDate();
		System.out.println("This is a prescription tracker");
		System.out.println();
		
		try {
			
			map.medicalDocumentation();
			map.deletionPrompt();
			System.out.println();
			
			map.alterations();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end main
	
	public static void currentDate() {
		Date date = new Date();
		SimpleDateFormat dayOfWeek = new SimpleDateFormat("E");
		SimpleDateFormat dayMonthYear = new SimpleDateFormat("MM/dd/yy");
		
		System.out.println("Today is " + dayOfWeek.format(date) + " " + dayMonthYear.format(date));
	}

}//end main 

