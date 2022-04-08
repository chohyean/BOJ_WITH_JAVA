package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B1_2775_부녀회장이될테야 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int k, n; // k층 n호 
	static int[][] apt;
	static int people = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			k = Integer.parseInt(input.readLine());
			n = Integer.parseInt(input.readLine());
			apt = new int[k+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				apt[0][i] = i;
			}

			for(int r = 1; r <= k; r++) {
				for(int c = 1; c <= n; c++) {
					for(int i = 1; i <= c; i++) {
						people += apt[r-1][i];
					}
					apt[r][c] = people;
					people = 0;
				}
			}
			
//			for(int[] row : apt) {
//				System.out.println(Arrays.toString(row));
//			}
			System.out.println(apt[k][n]);
			
		}

	}

}
