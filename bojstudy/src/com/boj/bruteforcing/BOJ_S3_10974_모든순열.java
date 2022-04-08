package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_10974_모든순열 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = i+1;
		}
//		System.out.println(Arrays.toString(nums));
		
		permutation(N, new int[N], new boolean[N]);

	}
	
	private static void permutation(int toChoose, int[] choosed, boolean[] visited) {
		if(toChoose == 0) {
			for(int c : choosed) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[N - toChoose] = nums[i];
				permutation(toChoose-1, choosed, visited);
				visited[i] = false;
			}
		}
		
	}

}
