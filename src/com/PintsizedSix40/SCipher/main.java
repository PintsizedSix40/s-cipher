package com.PintsizedSix40.SCipher;

public class main {
	
	public static void println(Object in) {
		System.out.println(in);
	}
	
	public static void main(String args[]) {
		if(args.length < 3) {
			println("ERROR: Invalid Syntax. Please use the following syntax: 'encode/decode \"Input Text\" 5'");
			System.exit(0);
		}
		if(args[args.length-3].equalsIgnoreCase("encode")) {
			String ci = cipher(args[args.length-2], Integer.parseInt(args[args.length-1]));
			if(ci.equalsIgnoreCase(args[args.length-2])) {
				println("WARNING: PROVIDED KEY RESULTS IN SAME VALUE. PLEASE CHOOSE A NEW KEY!");
				System.exit(0);
			}
		println(ci);
		}else if(args[args.length-3].equalsIgnoreCase("decode")) {
			println(decipher(args[args.length-2], Integer.parseInt(args[args.length-1])));
		}else {
			println("ERROR: Invalid Syntax. Please use the following syntax: 'encode/decode \"Input Text\" 5'");
		}
		}
	
	public static String cipher(String in, int time) {
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
		for(int y = 0; y < news.length()/3; y++) {
			newss += (char) Integer.parseInt(news.substring(y*3, y*3+3));
		}
		return newss;
	}
		
	public static String decipher(String in, int time) {
		String news = "";
		String actual = "";
		for(int y = 0; y < in.length(); y++) {
			actual+= String.format("%03d",(int) in.substring(y, y+1).toCharArray()[0]);
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
