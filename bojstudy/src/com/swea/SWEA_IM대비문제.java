package com.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_IM대비문제 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int n;
	static char[][] map;
	static int deltas[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			n = Integer.parseInt(input.readLine());
			
			map = new char[n][n];
			for(int r = 0; r < n; r++) {
				String str = input.readLine();
				for(int c = 0; c < n; c++) {
					map[r][c] = str.charAt(c);
				}
			}
//			for(char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					
					if(map[r][c] == 'A') {
						findCovered(r, c, 1);
					}else if(map[r][c] == 'B') {
						findCovered(r, c, 2);
						
					}else if(map[r][c] == 'C') {
						findCovered(r, c, 3);
						
					}
					
				}
			}
			
			int answer = 0;
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < n; c++) {
					if(map[r][c] == 'H') {
						answer++;
					}
				}
			}
			
			output.append("#" + t + " " + answer + "\n");
		}
		System.out.println(output);

	}
	
	public static void findCovered(int r, int c, int coverCnt) {	
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			int cnt = 1;
			while(cnt <= coverCnt) {
				nr = r + deltas[d][0]*cnt;
				nc = c + deltas[d][1]*cnt;
				
				if(isIn(nr, nc) && map[nr][nc] == 'H') {
					map[nr][nc] = 'X';
				}
				cnt++;
			}
			
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}

}
