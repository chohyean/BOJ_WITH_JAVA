package com.boj.string;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_2675_문자열반복 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int R = scanner.nextInt();
			String str = scanner.next();

			
			for(int i = 0; i < str.length(); i++) {
				for(int j = 0; j < R; j++) {
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
