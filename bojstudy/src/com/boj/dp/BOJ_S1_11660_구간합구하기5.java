package com.boj.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1_11660_구간합구하기5 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M; // 표의 크기, 합을 구해야 하는 횟수 
	static int[][] arr;
	static int[][] DP;
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 1; c <= N; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());  
			}
		}
		
		DP = new int[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				// (1, 1)부터 (r, c)까지의 합 저장 
				DP[r][c] = DP[r-1][c] + DP[r][c-1] - DP[r-1][c-1] + arr[r][c];
			}
		}

		
		for(int m = 0; m < M; m++) {
			tokens = new StringTokenizer(input.readLine());
			x1 = Integer.parseInt(tokens.nextToken());
			y1 = Integer.parseInt(tokens.nextToken());
			x2 = Integer.parseInt(tokens.nextToken());
			y2 = Integer.parseInt(tokens.nextToken());
			
			// (x1,y1)부터 (x2,y2)까지의 합
			int answer = DP[x2][y2] - DP[x2][y1-1] - DP[x1-1][y2] + DP[x1-1][y1-1];
			output.append(answer + "\n");
			
		}
		System.out.println(output);
		

	}

}
