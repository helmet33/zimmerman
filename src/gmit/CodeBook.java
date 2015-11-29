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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class that looks manages an encoding book
public class CodeBook {
	
	private Map<String, ArrayList<Integer>> coder = new HashMap<String, ArrayList<Integer>>();
	// O(1) on map
	public void addCode(String word, int number){
		ArrayList<Integer> numbers = coder.get(word);
		
		if(numbers == null){
			numbers = new ArrayList<Integer>();
		}//if
		
		numbers.add(number);
		coder.put(word, numbers);
	}//addCode
	
	public List<Integer> getCodes(String word){
		return coder.get(word);
	}// getCodes
	
	public void delete(String word){
		coder.remove(word);
	}// delete
	
	public int size(){
		return coder.size();
	}//end size
		
}//end Class
