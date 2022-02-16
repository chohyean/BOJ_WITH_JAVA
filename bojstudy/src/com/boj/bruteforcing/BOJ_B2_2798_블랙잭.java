package com.boj.bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B2_2798_블랙잭 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N, M;
	private static int[] card;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		card = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(tokens.nextToken());
		}
		
		combination(0, 0, 0);
		System.out.println(answer);

	}
	
	public static void combination(int cnt, int start, int sum) {
		if(cnt == 3) {
			if(sum <= M && answer < sum) {
				answer = sum;
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			combination(cnt+1, i+1, sum + card[i]);
		}
	}

}
