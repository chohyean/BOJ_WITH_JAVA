package com.boj.math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_11050_이항계수1 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, K;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int answer = factorial(N) / (factorial(K) * factorial(N-K));
		System.out.println(answer);
	}
	
	public static int factorial(int n) {
		int fac = 1;
		for(int i = 1; i <= n; i++) {
			fac *= i;
		}
		return fac;
	}

}
