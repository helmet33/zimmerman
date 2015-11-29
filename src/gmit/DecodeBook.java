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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Class that manages a decoding book
public class DecodeBook implements Serializable {
	private static final long serialVersionUID = 175990L;
	
	private Map<Integer, String> decoder = new HashMap<Integer, String>();
	
	// O(1) lokup map 
	public String decode(int number){
		return decoder.get(number);
	}
	// O(1) add to map
	public void addCode(int code, String word){
		decoder.put(code, word);
	}
	//  O(1)
	public Map<Integer, String> getDecoder() {
		return decoder;
	}
	//  O(1)
	public void setDecoder(Map<Integer, String> decoder) {
		this.decoder = decoder;
	}
	//  O(1)
	public int getSize(){
		return this.decoder.size();
	}
	
	public void load(String file){
		setDecoder(deser(file));
	}
	
	public void ser(String file){
		try
	      {
	         
			FileOutputStream fileOut =
	         new FileOutputStream(file);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(decoder);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved to " + file);
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		
	}//Garrett test ser
	
	
	
	@SuppressWarnings("unchecked")
	private Map<Integer, String> deser(String file){
		Map<Integer, String> e = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Map<Integer, String>) in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.println("File deserialised successfully.");
	         return e;
	      }catch(IOException i)
	      {
	         System.out.println(i.getMessage());
	    	  //i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return null;
	      }
	}//Garrett test deser
	
}
