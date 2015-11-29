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


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

// Class that handles encoding a file
public class FileEncoder {
	private FileParse parser= new FileParse();
	private Random rand = new Random();
	
	
	// encode runs at  O(n) based on number of words
	public List<Integer> encode(String file, CodeBook codes) throws Exception{
		List<Integer> toSave = new ArrayList<Integer>();
		Collection<String> contents = parser.parse(file);
		int length = 0;
		int i = 0;
		
		for (String string : contents) {
			if (codes.getCodes(string) != null){
				
				length = codes.getCodes(string).size();
				i = rand.nextInt(length);
				int code = codes.getCodes(string).get(i);
				toSave.add(code);
				
			}
			else {
				
				toSave.add(0);
			}
		}
		return toSave;
	}

}
