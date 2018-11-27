package com.PintsizedSix40.SCipher;

import java.util.Arrays;

public class main {
	
	private static int[] i2a(int number) {
	    String str = (new Integer(number)).toString();
	    char[] chArr = str.toCharArray();
	    int[] arr = new int[chArr.length];
	    for (int i = 0; i< chArr.length; i++) {
	        arr[i] = Character.getNumericValue(chArr[i]);
	    }
	    return arr;
	}
	
	  public static String convertHexToString(String hex){

		  StringBuilder sb = new StringBuilder();
		  StringBuilder temp = new StringBuilder();
		  
		  for( int i=0; i<hex.length()-1; i+=2 ){
			  
		      String output = hex.substring(i, (i + 2));
		      int decimal = Integer.parseInt(output, 16);
		      sb.append((char)decimal);
		      temp.append(decimal);
		  }
		  
		  return sb.toString();
	  }

	public static String cipher(String in, int time) {
		char[] chars = in.toCharArray();
		String hexs = "";
		for(int g = 0; g < chars.length; g++) {
			hexs+=String.format("%04x", (int) chars[g]);
		}
		String[] bits = hexs.replace("0", "").split("");
		
		
			String[] bits2 = bits.clone();
			int place = 0;
			for(int x = 0; x < time; x++) {
				if(place == bits2.length) {
					place = 0;
				}
				
				String o =  bits2[x];
				String t = bits2[x+1];
				bits2[0] = t;
				bits2[1] = o;
				place++;
			
		}
			System.out.println(Arrays.toString(bits2));
			String str = "";
			for(int t = 0; t < bits2.length; t++) {
				str+=bits2[t];
			}
			return convertHexToString(str);
		
	}
	

	
	public static void main(String args[]) {
		System.out.println(cipher(args[args.length-2], Integer.parseInt(args[args.length-1])));
	}
	
	
	
	
	
}
