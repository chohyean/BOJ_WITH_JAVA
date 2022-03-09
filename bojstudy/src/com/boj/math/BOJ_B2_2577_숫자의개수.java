package com.boj.math;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B2_2577_숫자의개수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int num = a * b * c;
		String str = String.valueOf(num);

		
		int[] arr = new int[10];
		for(int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)-'0']++;
		}
		
		for(int v : arr) {
			System.out.println(v);
		}
		

	}

}
