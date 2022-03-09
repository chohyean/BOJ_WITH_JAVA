package com.boj.implementation;
import java.util.Scanner;

public class BOJ_B2_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		String str;
		for(int t = 1; t <= T; t++) {
			str = scanner.next();
			
			int cnt = 0;
			int sum = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'O') {
					cnt++;
					sum += cnt;
				}else {
					cnt = 0;
				}
			}
			
			System.out.println(sum);
		}

	}

}
