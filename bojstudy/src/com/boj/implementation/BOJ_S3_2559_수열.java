package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_2559_수열 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, K;
	static int[] seq;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		seq = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		System.out.println(Arrays.toString(seq));

		int sum = 0;
		int start = 0;
		while(start <= N-K) {
			sum = 0;
			for(int i = start; i < start + K; i++) { // start부터 start+K 전까지만 합함 
				sum += seq[i];
			}
			
			if(max < sum) {
				max = sum; // sum 중에 최댓값 갱
			}
			
			start++;
		}
		System.out.println(max);

	}

}
