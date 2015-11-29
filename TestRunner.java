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


import gmit.*;

import java.util.List;


public class TestRunner {
	
	// Used for title
	private static MenuTitle title = new MenuTitle();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CodeGenerator code = new CodeGenerator();
		CodeWriter write = new CodeWriter();
		MessageWriter message = new MessageWriter();
		long start, methodTimer;
		
		title.title();
		
		// generates codes based on mainwords file
		System.out.println("Generating codes");
		start = System.currentTimeMillis();
		methodTimer = System.currentTimeMillis();
		code.generateCodeBooks("mainWords.txt");
		System.out.println("Codes generated. Time:" + (System.currentTimeMillis() - methodTimer));
		
		// Local instances to play with

		DecodeBook db = code.getDecodeBook();
		
		
		
		FileEncoder encFile = new FileEncoder();
		
		FileDecode deco = new FileDecode();
		// test serialisation
		
		System.out.println("Testing serialisation of decode books:");
		
		System.out.println("Saving:");
		methodTimer = System.currentTimeMillis();
		db.ser("save.ser");
		System.out.println();
		System.out.println("Saved in " + (System.currentTimeMillis() - methodTimer));
		System.out.println("Loading");
		methodTimer = System.currentTimeMillis();
		db.load("save.ser");
		
		System.out.println("Loaded in " + (System.currentTimeMillis() - methodTimer) );
		//db = db.deser("save.ser");
		
		// Testing war and peace
		System.out.println();
		System.out.println("Test encode of War a Peace:");
		methodTimer = System.currentTimeMillis();
		List<Integer> encoded = encFile.encode("warnpeace.txt", code.getCodeBook());
		System.out.println("Encoding complete in "  + (System.currentTimeMillis() - methodTimer));
		
		// Save codes to file
		System.out.println();
		System.out.println("Writing codes to file:");
		methodTimer = System.currentTimeMillis();
		write.save(encoded, "encodedtest.txt");
		System.out.println("Codes written to encodedtest.txt in "  + (System.currentTimeMillis() - methodTimer));
		
		//Decode test
		System.out.println();
		System.out.println("Test decoding from file just created");
		methodTimer = System.currentTimeMillis();
		System.out.println("Decoding file");
		List<String> decoded = deco.decode("encodedtest.txt", db);
		System.out.println("File decoded in " + (System.currentTimeMillis() - methodTimer));
		
		//Save decoded message to file
		System.out.println();
		System.out.println("Saving message to messagetest.txt");
		methodTimer = System.currentTimeMillis();
		message.save(decoded, "messagetest.txt");
		System.out.println("Message saved in "  + (System.currentTimeMillis() - methodTimer));
		
		System.out.println("Total Time: " + (System.currentTimeMillis() - start));		
		

		
		
	}//main

}
