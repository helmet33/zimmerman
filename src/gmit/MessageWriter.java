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

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;

import java.util.List;

// Class to save decoded message to file
public class MessageWriter {
	// Save method is O(N) as depends on size of String list
	public void save(List<String> codes, String file) throws Exception{
		if(codes == null || codes.size()==0){
			throw new Exception("Gadzooks there is nothing to write..");//+ e.getMessage()
		}
		
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
		int counter = 0;
		
		for (String word : codes) {
			// Format with leading zeros
			//String i = String.format("%05d", in);
			out.write(word);
			out.write(" ");
			counter++;
			
			if(counter % 9 == 0){
				out.write("\n");
				counter = 0;
			}// end inner if
			
		}//end fore
		
		//Close files
		out.flush();
		out.close();
		
		
		
		
	}//end Save method

}
