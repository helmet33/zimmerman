/*
 *  
 *  Garrett Jordan - G00305145
 *  Data Structures and Algoritms Project 
 *  Academic Year 2 - 2013/14 Semester 2
 *  Lecturer: John Healy
 *  Linguistic Encoding using Maps
 *  
 *  
 */

package gmit;
import java.util.*;

// Class to maintain menus and titles
public class MenuTitle {
	public static Scanner console = new Scanner(System.in);
	
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Title Screen
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void title() {
		System.out.println();
		System.out.println("*****************************************");
		System.out.println("* Data Structures and Algoritms Project *");
		System.out.println("*    Linguistic Encoding using Maps     *");
		System.out.println("*                  by                   *");
		System.out.println("*            Garrett Jordan             *");
		System.out.println("*               G00305145               *");
		System.out.println("*****************************************");

	}

	public int mainMenu() {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Main menu called from main and returning the option selected
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		int choice = 0;// option to be returned
		do {
			try {
				System.out.println();
				System.out.println("================================");
				System.out.println("           Main Menu");
				System.out.println("================================");
				System.out.println();
				System.out.println("1. Generate Codes");
				System.out.println("2. Encode File");
				System.out.println("3. Decode File");
				System.out.println("4. Load Decode Book");
				System.out.println("5. Save Decode File");
				System.out.println("6. Exit");
				System.out.println("================================");
				System.out.print("Enter option: ");// Request input

				choice = console.nextInt(); // copy users choice to variable
			} catch (Exception e) {
				System.out.println("Error! Enter an Integer Value 1 to 6");
				console.next();// Move to next other wise exception
			}
		} while (!(choice > 0 && choice <= 6));

		return choice; // choice to be returned to main()
	}// end mainMenu
	
	


}
