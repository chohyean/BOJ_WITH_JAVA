package com.boj.bruteforcing;
import java.util.Scanner;

public class BOJ_B2_2231_분해합 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int num = i;
			String str = String.valueOf(num);
			int sum = num;
			for(int j = 0; j < str.length(); j++) {
				sum += str.charAt(j)-'0';
			}
			if(sum == N) {
				answer = num;
				break;
			}
		}

		System.out.println(answer);
	}

}
