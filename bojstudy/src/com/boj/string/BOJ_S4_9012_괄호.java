package com.boj.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S4_9012_괄호 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int t = 1; t <= T; t++) {
			String str = scanner.next();
			char[] ps = new char[str.length()];
			boolean[] isValid = new boolean[str.length()];
			
			for(int i = 0; i < str.length(); i++) {
				ps[i] = str.charAt(i);
			}
//			System.out.println(Arrays.toString(ps));
			
//			if(ps[0] == ')' || ps[ps.length-1] == '(') {
//				// vps 아님 
//			}
			
			for(int i = 0; i < ps.length; i++) {
				if(ps[i] == '(') {
					for(int j = i+1; j < ps.length; j++) {
						if(ps[j] == ')' && !isValid[j]) {
							isValid[i] = true;
							isValid[j] = true;
							break;
						}
					}
				}
			}
			
			String answer = "YES";
			for(int i = 0; i < ps.length; i++) {
				if(!isValid[i]) {
					answer = "NO";
					break;
				}
			}
			
			System.out.println(answer);
			
		}

	}

}
