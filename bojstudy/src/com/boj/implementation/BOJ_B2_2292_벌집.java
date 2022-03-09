package com.boj.implementation;
import java.util.Scanner;

public class BOJ_B2_2292_벌집 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int num = 0;
		int i = 0;
		int k = 0;
		int cnt = 0;
		while(N > num) {
			num = 6 * i + 1;
			i = i + ++k;
			cnt++;
		}
		
		System.out.println(cnt);

	}

}
