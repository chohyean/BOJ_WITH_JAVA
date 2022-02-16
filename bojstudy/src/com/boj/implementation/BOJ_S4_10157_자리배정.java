package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_10157_자리배정 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int C, R; // 공연장의 격자 크기
	private static int K; // 어떤 관객의 대기번호
	private static int[][] hall;
	private static boolean[][] isVisited;
	private static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(input.readLine());
		
		hall = new int[R][C];
		isVisited = new boolean[R][C];
		
		if(R * C < K) {
			System.out.println("0");
			System.exit(0);
		}
		
		int r = R-1;
		int c = 0;
		int wait = 1;
		int dir = 0;

		
		while(wait != K) {
			hall[r][c] = wait;
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			
			if(!isIn(nr, nc) || hall[nr][nc] != 0) {
				dir++;
				if(dir == 4) {
					dir = 0;
				}
				nr = r + dx[dir];
				nc = c + dy[dir];
			}
			r = nr;
			c = nc;
			++wait;
		}
		System.out.println((c+1) + " " + (R-r));

	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
