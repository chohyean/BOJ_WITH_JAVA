package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B1_10163_색종이 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		map = new int[1001][1001];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int startR = Integer.parseInt(tokens.nextToken());
			int startC = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			
			for(int r = startR; r < startR + w; r++) {
				for(int c = startC; c < startC + h; c++) {
					map[r][c] = i+1; // 색종이 번호로 채워서 구분하기 
				}
			}
			
		}
		
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for(int i = 1; i <= N; i++) {
			int area = 0;
			for(int r = 0; r < 1001; r++) {
				for(int c = 0; c < 1001; c++) {
					if(map[r][c] == i) {
						area++;
					}
				}
			}
			System.out.println(area);
		}

	}

}
