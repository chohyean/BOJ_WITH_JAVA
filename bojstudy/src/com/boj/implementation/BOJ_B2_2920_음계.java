package com.boj.implementation;
import java.util.Scanner;

public class BOJ_B2_2920_음계 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] num = new int[8];
		for(int i = 0; i < 8; i++) {
			num[i] = scanner.nextInt();
		}
		
		int ascCnt = 0, desCnt = 0;
		for(int i = 0; i < 7; i++) {
			if(num[i] < num[i+1]) {
				ascCnt++;
			}else {
				desCnt++;
			}
		}
		
		if(ascCnt == 7) {
			System.out.println("ascending");
		}else if(desCnt == 7) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}

	}

}
