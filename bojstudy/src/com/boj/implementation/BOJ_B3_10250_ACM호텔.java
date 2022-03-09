package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B3_10250_ACM호텔 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	
	static int T;
	static int[][] hotel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int h = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			int n = Integer.parseInt(tokens.nextToken());
			
			hotel = new int[h][w];
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					hotel[r][c] = (h-r)*100 + (c+1);
				}
			}		
//			for(int[] row : hotel) {
//				System.out.println(Arrays.toString(row));
//			}
			int cnt = 0;
			int answer = 0;
			aa : for(int c = 0; c < w; c++) {
				for(int r = h-1; r >= 0; r--) {
					cnt++;
					if(cnt == n) { 
						answer = hotel[r][c]; 
						break aa;
					}
				}
			}
			output.append(answer + "\n");
		}
		System.out.println(output);

	}

}
