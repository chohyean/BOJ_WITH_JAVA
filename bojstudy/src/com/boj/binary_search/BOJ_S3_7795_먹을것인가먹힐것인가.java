package com.boj.binary_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_7795_먹을것인가먹힐것인가 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int N, M;
	static int[] A;
	static int[] B;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			A = new int[N];
			B = new int[M];
			
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(tokens.nextToken());
			}
			
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(tokens.nextToken());
			}
			Arrays.sort(B);
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				cnt += binarySearch(B, A[i], 0, M-1);
			}
			System.out.println(cnt);
		}

	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		int idx = -1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= target) end = mid - 1;
			else {
				idx = mid;
				start = mid + 1;
			}
		}
		return idx + 1;
	}

}
