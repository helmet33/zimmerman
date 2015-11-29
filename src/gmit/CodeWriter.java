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

// Class that handles writing the codes to file
public class CodeWriter{
	// O(N) depends on number of codes
	public void save(List<Integer> codes, String file) throws Exception{
		if(codes == null || codes.size()==0){
			throw new Exception("Gadzooks there are no codes..");//+ e.getMessage()
		}
		
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(file)));
		int counter = 0;
		
		for (Integer in : codes) {
			// Format with leading zeros
			String i = String.format("%05d", in);
			out.write(i);
			out.write("\t");
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
	

		
}//class
