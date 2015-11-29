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
import java.util.Map;
// Class that handles decoding a file
public class FileDecode {
	private FileParse garrett = new FileParse();
	// O(N) depends on number of codes
	public List<String> decode(String file, DecodeBook deco) throws Exception{
		Collection<String> coded = garrett.parse(file);
		Map <Integer, String> decoder = deco.getDecoder();
		List<String> decoded = new ArrayList<String>();
		for (String string : coded) {
			
			int code = Integer.parseInt(string);
			if(decoder.get(code)!=null){
				
				String word = decoder.get(code).toString();
				decoded.add(word);
			}
			
		}
		//System.out.println("decoded" + " " + decoded.toString());
		return decoded;
		}
}
