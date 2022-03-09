package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_2615_오목 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int[][] board;
	static int[][] deltas = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};

	public static void main(String[] args) throws IOException {
		board = new int[19][19];
		for(int r = 0; r < 19; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int win = 0;
		int x = 0;
		int y = 0;
		aa : for(int r = 0; r < 19; r++) {
			for(int c = 0; c < 19; c++) {
				if(board[r][c] == 1) {
					if(checkOne(r, c)) {
						win = 1;
						x = r+1;
						y = c+1;
						break aa;
					}
				}else if(board[r][c] == 2) {
					if(checkTwo(r, c)) {
						win = 2;
						x = r+1;
						y = c+1;
						break aa;
					}
				}
			}
		}
		
		if(win == 0) {
			System.out.println(0);
		}else {
			System.out.println(win);
			System.out.println(x + " " + y);
		}


	}
	
public static boolean checkOne(int r, int c) {
		
		for(int d = 0; d < 4; d++) {
			int nr = r - deltas[d][0];
			int nc = c - deltas[d][1];
			
			int cnt = 1;
			if(isIn(nr, nc) && board[nr][nc] == 1) continue;
			
			while(true) {
				if(cnt > 5) break;
				nr = r + deltas[d][0] * cnt;
				nc = c + deltas[d][1] * cnt;
				
				if(isIn(nr, nc) && board[nr][nc] == 1) {
					cnt++;
				}else {
					break;
				}
			}
			if(cnt == 5) return true;
		}
		return false;
	}
	
	public static boolean checkTwo(int r, int c) {
		
		for(int d = 0; d < 4; d++) {
			int nr = r - deltas[d][0];
			int nc = c - deltas[d][1];
			
			int cnt = 1;
			if(isIn(nr, nc) && board[nr][nc] == 2) continue;
			
			while(true) {
				if(cnt > 5) break;
				nr = r + deltas[d][0] * cnt;
				nc = c + deltas[d][1] * cnt;
				
				if(isIn(nr, nc) && board[nr][nc] == 2) {
					cnt++;
				}else {
					break;
				}
			}
			if(cnt == 5) return true;
		}
		return false;
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<19 && 0<=c && c<19;
	}

}
