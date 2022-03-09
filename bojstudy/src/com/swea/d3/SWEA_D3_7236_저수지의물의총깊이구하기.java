package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_7236_저수지의물의총깊이구하기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int N;
	static char[][] water;
	static int[][]  deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			water = new char[N][N];
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < N; c++) {
					water[r][c] = tokens.nextToken().charAt(0);
				}
			}
			
//			for(char[] row : water) {
//				System.out.println(Arrays.toString(row));
//			}
			// 입력완료! 
			
			answer = Integer.MIN_VALUE;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int cnt = 0;
					for(int d = 0; d < 8; d++) { // 8방탐색 
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(isIn(nr, nc) && water[nr][nc] == 'W') { // 공간 안에 있으면서 W일 때 물깊이 증가 
							cnt++;
						}
					}
					if(cnt == 0) cnt = 1; // W가 하나도 없으면 물깊이는 1 
					if(answer < cnt) answer = cnt; // 각 구획의 물 깊이 중 가장 깊은 구획의 깊이 구하기 
				}
			}
			output.append("#"  + t + " " + answer + "\n");
		}
		System.out.println(output);

	}
	
	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0<= c && c < N;
	}
	
	static String src = "4\n" + 
			"6\n" + 
			"G W G G W W\n" + 
			"G W G G W G\n" + 
			"W W W W G W\n" + 
			"W G W W W G\n" + 
			"G W W W W G\n" + 
			"G W W G W G\n" + 
			"5\n" + 
			"G W G G W\n" + 
			"G W G G W\n" + 
			"W W W W G\n" + 
			"W G W W W\n" + 
			"G W W W W\n" + 
			"3\n" + 
			"G G W\n" + 
			"G W W\n" + 
			"W W W\n" + 
			"3\n" + 
			"G G G\n" + 
			"G W G\n" + 
			"G G G";

}
