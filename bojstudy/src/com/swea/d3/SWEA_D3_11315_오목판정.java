package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_11315_오목판정 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N;
	static char[][] map;
	static int[][] deltas = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(input.readLine());
			map = new char[N][N];
			for (int r = 0; r < N; r++) {
				String str = input.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c);
				}
			}

//			for(char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}

			output.append("#" + t + " ");
			String msg = "NO";
			aa : for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 'o') {
						if(check(r, c)) {
							msg = "YES";
							break aa; // 오목 완성되면 YES하고 반복문 빠져나오기 
						}
					}	
				}
			}
			output.append(msg + "\n");

		} // 테케 완료 
		System.out.println(output);
	}
	
	private static boolean check(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r - deltas[d][0];
			int nc = c - deltas[d][1];
			
			if(isIn(nr, nc) && map[nr][nc] == 'o') {
				continue;
			} // 중간지점 없애기 
			
			// 시작지점부터 
			int cnt = 1;
			while(cnt < 5) {
				nr = r + deltas[d][0]*cnt;
				nc = c + deltas[d][1]*cnt; // 같은 방향으로 이동 
				
				if(isIn(nr, nc) && map[nr][nc] == 'o') {
					cnt++;
				}else {
					break;
				}
			}
			
			if(cnt == 5) return true;
		}
		return false;
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	private static String src = "4\n" + "5\n" + "....o\n" + "...o.\n" + "..o..\n" + ".o...\n" + "o....\n" + "5\n"
			+ "...o.\n" + "ooooo\n" + "...o.\n" + "...o.\n" + ".....\n" + "5\n" + ".o.oo\n" + "oo.oo\n" + ".oo..\n"
			+ ".o...\n" + ".o...\n" + "5\n" + ".o.o.\n" + "o.o.o\n" + ".o.o.\n" + "o.o.o\n" + ".o.o.";

}
