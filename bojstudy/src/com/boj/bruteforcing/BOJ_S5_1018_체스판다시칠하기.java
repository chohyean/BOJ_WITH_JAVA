package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S5_1018_체스판다시칠하기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static char[][] board;
	static int cnt;
	static int answer = Integer.MAX_VALUE;
	static int bCnt = 0, wCnt = 0;
	static int min = 0;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		board = new char[N][M];
		for(int r = 0; r < N; r++) {
			String str = input.readLine();
			for(int c = 0; c < M; c++) {
				board[r][c] = str.charAt(c);
			}
		}

		for(int r = 0; r <= N-8; r++) {
			for(int c = 0; c <= M-8; c++) {
				bCnt = 0;
				wCnt = 0;
				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						if(BstartBoard[i][j] != board[i+r][j+c]) bCnt++;
						else if(WstartBoard[i][j] != board[i+r][j+c]) wCnt++;
						min = Integer.min(bCnt, wCnt);
					}
				}
				if(answer > min) answer = min;
			}
		}
		
		System.out.println(answer);
	}
	
	static char [][] BstartBoard = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };

    static char [][] WstartBoard = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
    };

}
