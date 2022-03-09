package com.boj.math;
import java.util.Scanner;

public class BOJ_B3_4153_직각삼각형 {

	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			
			if(a == 0 && b == 0 && c == 0) break;
			
			int max = Math.max(Math.max(a, b), c);
			if(max == a) {
				pita(a, b, c);
			}else if(max == b) {
				pita(b, a, c);
			}else if(max == c) {
				pita(c, a, b);
			}
			
		}

	}
	
	public static void pita(int max, int x, int y) {
		if(Math.pow(max, 2) == Math.pow(x, 2) + Math.pow(y, 2)) {
			System.out.println("right");
		}else {
			System.out.println("wrong");
		}
	}

}
