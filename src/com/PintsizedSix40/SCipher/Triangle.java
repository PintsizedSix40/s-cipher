package com.PintsizedSix40.SCipher;

public class Triangle {
	public static int DIRECTION_LEFT = 0;
	public static int DIRECTION_RIGHT = 1;
	int x;
	int y;
	int z;
	int shifted = 0;
	Triangle(int tx, int ty, int tz){
		x = tx-48;
		y = ty-48;
		z = tz-48;
	}
	
	public void shift(int dir) {
		int tx = x;
		int ty = y;
		int tz = z;
		if(dir == DIRECTION_LEFT) {
			int shiftnum = shifted % 3;
			switch( shiftnum) {
			case 0:
				x = ty;
				y = tx;
				break;
			case 1:
				y = tz;
				z = ty;
				break;
			case 2:
				z = tx;
				x = tz;
				break;
			}
			shifted++;
		}
		
		if(dir == DIRECTION_RIGHT) {
			int shiftnum = shifted % 3;
			switch( shiftnum) {
			case 0:
				
				z = tx;
				x = tz;
				break;
			case 1:
				
				x = ty;
				y = tx;
				break;
			case 2:
				y = tz;
				z = ty;
				break;
			}
			shifted--;
		}
		
		}
		
	
	
	public int get() {
		return Integer.parseInt(Integer.toString(x) + Integer.toString(y) + Integer.toString(z));
	}
	
	public void setShifted(int key) {
		shifted = key;
	}
}
