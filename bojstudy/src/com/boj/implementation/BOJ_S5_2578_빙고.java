package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_S5_2578_빙고 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int[][] bingo;
	private static boolean[][] flag;
	private static int num;
	private static int bingoCnt = 0;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		bingo = new int[5][5];
		flag = new boolean[5][5];
		for (int r = 0; r < 5; r++) {
//			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < 5; c++) {
//				bingo[r][c] = Integer.parseInt(tokens.nextToken());
				bingo[r][c] = scanner.nextInt();
			}
		}
		
		for(int i = 0; i < 25; i++) {
			num = scanner.nextInt();
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (bingo[r][c] == num) {
						flag[r][c] = true;
					}
				}
			}
			bingoCheck();
			if(bingoCnt >= 3) {
				System.out.println(i+1);
				break;
			}
			
			bingoCnt = 0;
		}

	}

	private static void bingoCheck() {
		// 왼쪽부터 오른쪽 빙고
		for(int r = 0; r < 5; r++) {
			int cnt = 0;
			for(int c = 0; c < 5; c++) {
				if(flag[r][c] == true) {
					cnt++;
				}
			}
			if(cnt == 5) bingoCnt ++;
		}
		// 위부터 아래 빙고
		for(int c = 0; c < 5; c++) {
			int cnt = 0;
			for(int r = 0; r < 5; r++) {
				if(flag[r][c] == true) {
					cnt++;
				}
			}
			if(cnt == 5) bingoCnt ++;
		}
		// 왼쪽상단->오른쪽하단 대각선 빙고
		int cnt = 0;
		for(int r = 0; r < 5; r++) {
			if(flag[r][r] == true) {
				cnt++;
			}
			if(cnt == 5) bingoCnt++;
		}
		// 오른쪽상단 ->왼쪽하단 대각선 빙고
		int cntR = 0;
		for(int r = 0; r < 5; r++) {
			if(flag[r][4-r] == true) {
				cntR++;
			}
			if(cntR == 5) bingoCnt++;
		}	
	}

}
