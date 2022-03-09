package com.boj.implementation;
import java.util.Scanner;

public class BOJ_B2_2908_상수 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String a = scanner.next();
		String b = scanner.next();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		int ar = Integer.parseInt(sb.append(a).reverse().toString());
		int br = Integer.parseInt(sb2.append(b).reverse().toString());

		int ans = Math.max(ar, br);
		
		System.out.println(ans);
		
	}

}
