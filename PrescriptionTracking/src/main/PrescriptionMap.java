package main;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;



/*
 * Description: 
 * <p> This class creates a hash map of the prescriptions and the details you enter.<p>
 * 
 * @author: Joseph Curto
 * @version: 07/28/2019
 */

public class PrescriptionMap {
	
	HashMap<Integer,Prescription> hmap = new HashMap<Integer, Prescription>();
	private static Scanner scan = new Scanner(System.in);
	
	private String prescriptionName;
	private float dosage;
	private int dailyIntake;
	private int hoursApart;
	/*
	 * 
	 * <p>The medDocumentation method acts as the UI, beginning with the questions, "Do you wish to enter any prescriptions?"
	 * If you do, then you type yes, otherwise any other word typed in will give the exiting program prompt and terminate the program.
	 * As the user types in the prescription name, dosage, daily amount, and how many hours apart the medication should be taken, they 
	 * will then be added to the hash map with the keys corresponding to the order in which you entered your prescription.<p>
	 * <p> After the questions have been asked, then the initial question of, "Do you wish to enter any prescriptions?" will be asked
	 * until the user types in "no".<p>
	 */
	public void medicalDocumentation() throws FileNotFoundException {
		
		int key = 1;
		boolean prescription_Decision = true;
		
		do {
		System.out.print("Do you wish to enter any prescriptions? Y/N: ");
		String decision = scan.next();
		System.out.println();
		
		if(decision.equalsIgnoreCase("y")) {
			
			System.out.print("Prescription Name: ");
			prescriptionName = scan.next();
		
			System.out.print("Enter the dosage in milligrams: ");
			dosage = scan.nextFloat();
			validDosageCheck();
			
			System.out.print("Enter the daily amount: ");
			dailyIntake = scan.nextInt();
			validIntakeCheck();
			
			System.out.print("Enter how many hours apart between dosages: ");
			hoursApart = scan.nextInt();
			validHoursApartCheck();
			
			System.out.println();
			
			Prescription perscript = new Prescription(prescriptionName, dosage, dailyIntake, hoursApart);
			hmap.put(key,perscript);
			key++;
			
			
		}
		else {
			prescription_Decision = false;
			
			printData();
			printMap();
			
			System.out.println();
			
		}
		
	}//end do
		
		while(prescription_Decision == true); 
		
	}
	
	
	private void validDosageCheck(){
		while(dosage > 120){
			System.out.print("You must enter a valid dosage(mg); ");
			dosage = scan.nextFloat();
		}
	}
	
	private void validIntakeCheck() {
		while(dailyIntake > 12){
			System.out.print("Please enter a lower daily intake: ");
			dailyIntake = scan.nextInt();
		}
	}
		
	private void validHoursApartCheck() {
		while(hoursApart > 24){
			System.out.print("Please enter a valid time period between dosages: ");
			hoursApart = scan.nextInt();
		}
	}
	
	
	/*
	 * The deletionPrompt provides a UI for the user to interact with which allows them to 
	 * specify what prescription they wish to remove.
	 */
	public void deletionPrompt() throws FileNotFoundException{
		System.out.print("Do you need to delete a prescription? Y/N: ");
		String decision = scan.next();
		
		while(decision.equalsIgnoreCase("y")){
			System.out.println("Which prescription would you like to delete?");
		
			numericalPrint();
		
			System.out.println();
			System.out.print("Please enter the number corresponding with the prescription: ");
			int key = scan.nextInt();
			deletePrescription(key);
			
			System.out.println("This is what remains after the deletion.");
		
			printData();
			printMap();
			System.exit(0);
		}
		
		if(decision.equalsIgnoreCase("n")){
			System.out.println("You have chosen not to delete a prescription.");
		}
	}//end deletePrompt method
	
    
	private void deletePrescription(int num) {
		hmap.remove(num);
	}
	
	
	/*
	 * The alterations method allows the user to alter already existing prescriptions.
	 */
	public void alterations() throws FileNotFoundException{
		
			System.out.print("Would you like alter a certain perscription? Y/N: ");
			String decision = scan.next();
			
			while(!decision.equalsIgnoreCase("y") || decision.equalsIgnoreCase("n")){
				System.out.print("You must enter either a Y or a N: ");
				String second_Decision = scan.next();
				
				if(second_Decision.equalsIgnoreCase("y")){
					decision = second_Decision;
				}
				
				else if(second_Decision.equalsIgnoreCase("n")){
					noAlterationPrompt();
				}
					
			}
		
			if(decision.equalsIgnoreCase("y")){
				numericalPrint();
				System.out.print("Please enter the number corresponding with the prescription you wish to alter: ");
				int key = scan.nextInt();
				
				scan.nextLine();
				System.out.print("What do you want to alter? Name, Dosage, Intake, or Hours Apart: ");
				String choice = scan.nextLine();
				
				
				//Basically allowing you to change the name of the prescription. Mainly used for misspelling.
				if(choice.equalsIgnoreCase("Name")){
					System.out.print("What would you like the new name to be: ");
					String new_Name = scan.next();
					hmap.get(key).setName(new_Name);
					
				}//end if
				
				else if(!choice.equalsIgnoreCase("Name")){
					System.out.print("What would you like the new number to be? : ");
					int new_num = scan.nextInt();
					
					//Changes the existing values to new ones.
					switch(choice){
					case "Dosage": hmap.get(key).setDosage((float)new_num); break;
					case "Intake": hmap.get(key).setDailyIntake(new_num); break;
					case "Hours Apart": hmap.get(key).setHoursApart(new_num); break;
					}//end switch
					
				}//end else if
				
				System.out.println("This is the result of the alteration.");
				printData();
				printMap();
				System.exit(0);
			}//end if
			
		else if(decision.equalsIgnoreCase("n")){
			noAlterationPrompt();
		}//end else if
			
	scan.close();
	
	}//end alterations
	
	
	private void noAlterationPrompt(){
		System.out.println("You chose not to alter any prescriptions.");
		System.exit(0);
	}
	
	/*
	 * The printData method simply formats the header of the table that will be printed out when the program terminates
	 */
	public void printData() {
		System.out.printf("%-24s %-14s %-13s %-15s", "Prescription Name", "Dosage", "Daily Intake", "Hours Apart");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		
	}

	/*
	 * The printMap method prints the elements of the hash map to the table and saves a transcript of the final version of the 
	 * prescription tracker.
	 */
	public void printMap() throws FileNotFoundException {
		PrintStream pt = new PrintStream(new FileOutputStream("Prescription_Track.txt"));
		pt.println("Prescription-Tracker version as of " + Calendar.getInstance().getTime());
		pt.println();
		pt.printf("%-24s %-14s %-13s %-15s", "Name", "Dosage(mg)", "Daily Intake", "Hours Apart");
		pt.println("-----------------------------------------------------------------");
		
		for(Entry<Integer, Prescription> entry: hmap.entrySet()) {
			System.out.println(entry.getValue());
			pt.println(entry.getValue());
		}//end for
		pt.close();
	}//end printMap
	
	
	/*
	 * numerical print is used to print the keys and the prescription names when the user is wanting to alter or delete a prescription.
	 */
	public void numericalPrint(){
		int i = 1;
		for(Entry<Integer, Prescription> entry: hmap.entrySet()) {
			System.out.println(i + ". " + entry.getValue().getName());
			i++;
		}
	}
}//end class
