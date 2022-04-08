package com.boj.binary_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S4_1920_수찾기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[] A;
	static int M;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(A);
		
		M = Integer.parseInt(input.readLine());
		nums = new int[M];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			int result = binarySearch(A, nums[i], 0, N-1);
			if(result == -1) {
				output.append("0").append("\n");
			}else {
				output.append("1").append("\n");
			}
		}
		
		System.out.println(output);

	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == target) return mid;
			else if(arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}

}
