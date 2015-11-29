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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CodeGenerator implements Serializable {
	private static final long serialVersionUID = 175990L;
	private CodeBook coder = new CodeBook();
	private DecodeBook decoder = new DecodeBook();
	private FileParse parser = new FileParse();
	private Random rand = new Random();
	private static final int MAX_PICK = 75000;
	private Set<Integer> used = new HashSet<Integer>();
	private static int highF = (MAX_PICK /3)/25;
	private static int midF= ((MAX_PICK/3) / 5) /100;
	private static int lowF = ((MAX_PICK/3) /(100/65))/300;
	
	
	//gencode books is O(n^) as it depends both on the size of the file and the amount of codes generated
	public void generateCodeBooks(String wordFile) throws Exception{
		Collection<String> words = parser.parse(wordFile);
		
		int counter = 1;
		int next = rand.nextInt(75000)+1;
		for (String word : words) {
			int numCodes = computeFrequency(counter);
			int numCodeCount = 0;
			coder.addCode("xxxx", 0);
			decoder.addCode(0,"xxxx");
			while(numCodeCount < numCodes){
				next = rand.nextInt(75000)+1;
				//System.out.println(next);
				boolean unique = used.add(next);
				
				if(unique){
					
					//used.add(next);
					numCodeCount++;
					//System.out.println(word + " " + numCodeCount);
					coder.addCode(word, next);
					decoder.addCode(next, word);
				}//end if unique
			}//end while nCC < nC
			counter++;
		}//end fore word:words

	}//end generateCodeBooks
	
	
	// compute frequency runs 0(1) just an check on a size
	private int computeFrequency(int counter) {
		// TODO Auto-generated method stub
		
		if(counter<=25){
			return highF;
			//return 1000;
			
		} else if (counter <= 100){
			return midF;
			//return 170;
		}
		else if (counter <= 300){
			return lowF;
			//return 56;
		} else 
			
		return 43;
	}// end ComputeFrequency
	
	public CodeBook getCodeBook(){
		return this.coder;
	}// get
	
	public DecodeBook getDecodeBook(){
		return this.decoder;
	}

}
