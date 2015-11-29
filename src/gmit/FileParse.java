package gmit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class FileParse {
	public static Collection<String> ignored = new ArrayList<String>();// remove
	private static final int ASCII_NUM_L=48;
	private static final int ASCII_NUM_H=57;
	private static final int ASCII_MIN = 97;
	private static final int ASCII_MAX = 122;
	private static int count = 0;
	public Collection<String> parse(String file) throws Exception{
		Collection<String> cols = new ArrayList<String>();
		
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		while((line = br.readLine())!=null){
			String[] words = line.split("\\s+");
			
			for (int i = 0; i < words.length; i++) {
				String next = process(words[i]);
				if(next != null){
					cols.add(next);
				}//end if
			}//end for
		}//end while
		
		br.close();  //close file reader
		return cols; //return collection
	}//parse method
	
	private String process(String s){
		String word = s.trim().toLowerCase();
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i< word.length();i++){
			//|| word.charAt(i)==39
			if((i==0 && word.charAt(i)==34)||(i==0 && word.charAt(i)==39)){
				continue;
			}
			if((word.charAt(i) >=ASCII_MIN && word.charAt(i)<= ASCII_MAX)||(word.charAt(i) >=ASCII_NUM_L && word.charAt(i)<= ASCII_NUM_H)){
				buf.append(word.charAt(i));
			}
			else
			{
				count++; //returns words influenced by punctuation chars
				ignored.add(word); //remove
				break;
			}
		}//end for
		
		return buf.toString();
	}// end process method
	
	public int getCount(){
		return count;
	}

}//class
