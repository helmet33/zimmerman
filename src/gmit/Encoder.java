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

// Main Program
package gmit;
import java.util.*;
public class Encoder {
	private static CodeGenerator code;
	private static FileEncoder encFile = new FileEncoder();
	private static FileDecode decFile = new FileDecode();
	
	public static Scanner console = new Scanner(System.in);
	private static MenuTitle menu = new MenuTitle();
	public static void main(String[] args) {
		menu.title();
		int choice = menu.mainMenu();
		while (choice != 6){
			switch (choice) {
			case 1:
				genCodes();
				break;
			case 2:
				encFile();
				
				break;
			case 3:
				decFile();
				System.out.println("choice 3");
				break;
			case 4:
				loadDecode();
				break;
			case 5:
				saveDecode();
				
				break;
			case 6:
				
				break;

			default:
				break;
			}
			choice = menu.mainMenu();
		}// end mainMenu while
		System.out.println("Goodbye");
	}// end main method
	
	
	// Member methods to call objects and access objects
	
	
	
	private static void genCodes(){
		// Generates the code books
		code = new CodeGenerator();
		System.out.println("Generating Code Books");
		try {
			code.generateCodeBooks("mainWords.txt");// Uses the main words .xt file
		} catch (Exception e) {
			System.out.println("Error loading word file");//deals with errors
			e.printStackTrace();
		}
		System.out.println("Codebooks generated.");// Lets the user know
		
	}//end genCodes
	
	private static void encFile(){
		//Used to encoded a file selected by user
		List<Integer> encoded;
		System.out.println("Enter file name including extension");
		System.out.println("E.g. warnpeace.txt");
		// Ask user for input
		String filename = console.next();
		
		// Check if codes have been generated and if not generate them
		if(code == null){
			genCodes();
		}
		
		try {
			// encodes the file
			encoded = encFile.encode(filename, code.getCodeBook());
			CodeWriter write = new CodeWriter();
			DecodeBook deco = code.getDecodeBook();
			// Saves the encoded file
			write.save(encoded, "encodedfile.txt");
			// Serialises the decode book so it can be used else where
			deco.ser("decode.ser");
			System.out.println("Encoded File Written out to encodedfile.txt");
			System.out.println("Decode Book serialised to decode.ser");
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end try Catch
		
		
	}// end encFile Method
	
	private static void decFile(){
		// Decodes a file
		List<String> decoded;
		if (code == null){
			//Check to see if there are any codes if not returns to menu
			// and gives info to user
			System.out.println("No Codebooks have been generated yet.");
			System.out.println("Please use option in menu to generate");
			return;
		}
		// Option to use current decode book or load another
		System.out.println("Do you want to decode the file with the current code book Y/N:");
		System.out.println("Current codes can only decode files encode since generation.");
		char opt = console.next().charAt(0);
		System.out.println("Enter file name to decode");
		String filename = console.next();
		if (opt != 'y' && opt != 'Y'){
			// Calls loadDecode Method to load a previous file
			loadDecode();
				
		} 
		DecodeBook deco = code.getDecodeBook();
		try {
			// decodes the file
			decoded = decFile.decode(filename, deco);
			// writes the decoded message to file
			MessageWriter writer = new MessageWriter();
			writer.save(decoded, "message.txt");
			// Alerts user of success
			System.out.println("Successfuly decode file and wrote it out to message.txt");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		
	}// end decFile
	
	private static void saveDecode(){
		// Calls method to save current decode file
		// checks to see if there is anything to save
		if (code == null){
			System.out.println("There is nothing to save.");
			System.out.println("Try generating something first");
			return;

		}
		// Prompts user for file name
		System.out.println("Enter a filename to save to including file extension");
		System.out.println("Recommend file extension .ser");
		String filename = console.next();
		DecodeBook deco = code.getDecodeBook();
		deco.ser(filename);
	}// end saveDecode method
	
	private static void loadDecode(){
		// Calls method to deserialise previously saved codes
		if(code == null){
			genCodes();
		}
		// Prompts user for info
		System.out.println("Enter a file name do deserialise");
		System.out.println("include the file name");
		String filename = console.next();
		DecodeBook deco = code.getDecodeBook();
		deco.load(filename);
	}

}//end Encoder Class
