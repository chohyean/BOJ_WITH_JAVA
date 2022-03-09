package com.swea.d3;
import java.util.Scanner;

public class SWEA_D3_13547_팔씨름 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int t = 1; t <= T; t++) {
			String str = scanner.next();
			
			int soWin = 0;
			int soLose = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'o') {
					soWin++;
				}else {
					soLose++;
				}
			}
			
			String answer = "";
			if(soLose >= 8) {
				answer = "NO";
			}else {
				answer = "YES";
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
		

	}

}
