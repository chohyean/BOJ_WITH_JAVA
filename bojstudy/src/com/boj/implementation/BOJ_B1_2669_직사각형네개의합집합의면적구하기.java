package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B1_2669_직사각형네개의합집합의면적구하기 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static boolean[][] map;
	private static int[][] rectangle;
	private static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		
		rectangle = new int[4][4];
		for(int i = 0; i < 4; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < 4; j++) {
				rectangle[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		map = new boolean[100][100];
		for(boolean[] b : map) {
			for(boolean bb : b) {
				bb = false;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int r = rectangle[i][0]; r < rectangle[i][2]; r++) {
				for(int c = rectangle[i][1]; c < rectangle[i][3]; c++) {
					map[r][c] = true;
				}
			}
		}
		
		for(boolean[] b : map) {
			for(boolean bb : b) {
				if(bb == true) sum += 1;
			}
		}
		
		System.out.println(sum);

	}

}
