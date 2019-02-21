package com.PintsizedSix40.SCipher.Lib;

public class main {
	/*
	 * public String cipher
	 * params:
	 * in-input unciphered string
	 * time-times to shift/key
	 * isChar-true if return is ASCII character, false if return is ASCII codes (may not convert to ASCII)
	 * 
	 * output-ciphered text (WARNING: CHECK IF CIPHERED TEXT IS THE SAME AS INPUT TEXT)
	 */
	
	public static String cipher(String in, int time, boolean isChar) {
		char[] ca = in.toCharArray();
		
		String news = "";
		for(int i = 0; i < ca.length; i++) {
			char curchar = ca[i];
			
			char[] ascii = String.format("%03d", (int) curchar).toCharArray();
			Triangle tri = new Triangle(ascii[0], ascii[1], ascii[2]);
			for(int x = 0; x < time; x++) {
				tri.shift(Triangle.DIRECTION_LEFT);
			}
			news+=String.format("%03d", tri.get());
			
		}
		String newss = "";
		if(isChar) {
		for(int y = 0; y < news.length()/3; y++) {
			newss += (char) Integer.parseInt(news.substring(y*3, y*3+3));
		}
		}else {
			newss = news;
		}
		return newss;
	}
	
	/*
	 * public String decipher
	 * params:
	 * in-input ciphered string
	 * time-times to shift/key
	 * isChar-true if input is ASCII characters, false if it is ASCII codes (use the same value you ciphered with)
	 * 
	 * output-unciphered text
	 */
	public static String decipher(String in, int time, boolean isChar) {
		String news = "";
		String actual = "";
		if(isChar) {
		for(int y = 0; y < in.length(); y++) {
			actual+= String.format("%03d",(int) in.substring(y, y+1).toCharArray()[0]);
		}
		}else {
			actual = in;
		}
		String[] arr = actual.split("(?<=\\G...)");
		for(int i = 0; i < arr.length; i++) {
			
			char[] ascii = arr[i].toCharArray();
			Triangle tri = new Triangle(ascii[0], ascii[1], ascii[2]);
			tri.setShifted(time);
			for(int x = 0; x < time; x++) {
				tri.shift(Triangle.DIRECTION_RIGHT);
			}
			
			news+=(char) Integer.parseInt(Integer.toString(tri.get()).substring(2)+Integer.toString(tri.get()).substring(0, 2));
			
		}
		return news;
	}
	
	
	
	
	
}
