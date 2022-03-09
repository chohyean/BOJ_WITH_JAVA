package com.boj.math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_S5_2609_최대공약수와최소공배수 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int gcf = 0; // 최대공약수 
	static int lcm = 0; // 최소공배수 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int max = Integer.max(a, b);
		
		for(int i = max; i > 0; i--) {
			if((a % i == 0) && (b % i == 0)) {
				gcf = i;
				lcm = i * (a/i) * (b/i);
				break;
			}
		}
		System.out.println(gcf);
		System.out.println(lcm);
		

	}

}
