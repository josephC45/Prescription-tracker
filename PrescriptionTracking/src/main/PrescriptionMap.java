package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


/*
 * Description: 
 * <p> This class creates a hash map of the prescriptions and the details you enter.<p>
 * 
 * @author: Joseph Curto
 * @version: 04/07/2019
 */

public class PrescriptionMap {
	
	HashMap<Integer,Prescription> hmap = new HashMap<Integer, Prescription>();
	
	
	/*
	 * <p>The medDocumentation method acts as the UI, beginning with the questions, "Do you wish to enter any prescriptions?"
	 * If you do, then you type yes, otherwise any other word typed in will give the exiting program prompt and terminate the program.
	 * As the user types in the prescription name, dosage, daily amount, and how many hours apart the medication should be taken, they 
	 * will then be added to the hash map with the keys corresponding to the order in which you entered your prescription.<p>
	 * <p> After the questions have been asked, then the initial question of, "Do you wish to enter any prescriptions?" will be asked
	 * until the user types in "no".<p>
	 */
	public void medDocumentation() {
		
		Scanner scan = new Scanner(System.in);
		int key = 0;
		boolean prescript_Decision = true;
		
		do {
		System.out.print("Do you wish to enter any prescriptions?");
		String perscriptCount = scan.next();
		System.out.println();
		
		if(perscriptCount.equalsIgnoreCase("yes")) {
			
			System.out.print("Prescription Name: ");
			String prescriptionName = scan.next();
			
			System.out.print("Enter the dosage in milligrams: ");
			float dosage = scan.nextFloat();
			
			System.out.print("Enter the daily amount: ");
			int dailyIntake = scan.nextInt();
			
			System.out.print("Enter how many hours apart between dosages: ");
			int hoursApart = scan.nextInt();
		
			System.out.println();
			
			Prescription perscript = new Prescription(prescriptionName, dosage, dailyIntake, hoursApart);
			hmap.put(key,perscript);
			key++;
			
		}//end if
		else {
			prescript_Decision = false;
			
			printData();
			printMap();
			
			System.out.println();
			
			System.out.println("Thank you for using my progam!");
			System.exit(0);
		}//end else
		
	}//end do
		
		while(prescript_Decision == true); 
		scan.close();
		
	}//end medAddition
	
	/*
	 * The printData method simply formats the header of the table that will be printed out when the program terminates
	 */
	public void printData() {
		System.out.printf("%-24s %-14s %-13s %-15s", "Prescription Name", "Dosage", "Daily Intake", "Hours Apart");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
	}//end printData method

	/*
	 * The printMap method prints the elements of the hash map to the table.
	 */
	public void printMap() {
		for(Entry<Integer, Prescription> entry: hmap.entrySet()) {
			System.out.println(entry.getValue());
		}//end for
	}//end printMap
}
