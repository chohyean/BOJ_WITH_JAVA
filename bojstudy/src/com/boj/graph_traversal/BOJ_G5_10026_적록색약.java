package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G5_10026_적록색약 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static char[][] painting;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visitedColor, visitedColorblind;
	static int colorCnt, colorblindCnt; // 적록색약이 아닌 사람이 봤을 때의 구역개수, 적록색약인 사람이 봤을 때의 구역개수 

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		painting = new char[N][N];
		for(int r = 0; r < N; r++) {
			String str = input.readLine();
			for(int c = 0; c < N; c++) {
				painting[r][c] = str.charAt(c);
			}
		}
		
//		for(char[] row : painting) {
//			System.out.println(Arrays.toString(row));
//		}
		
		colorCnt = 0;
		colorblindCnt = 0;
		visitedColor = new boolean[N][N];
		visitedColorblind = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visitedColor[r][c]) {
					dfsColor(r, c);
					colorCnt++;
				}
				if(!visitedColorblind[r][c]) {
					dfsColorblind(r, c);
					colorblindCnt++;
				}
			}
		}
		
		System.out.println(colorCnt + " " + colorblindCnt);
	}
	
	private static void dfsColor(int r, int c) {
		
		visitedColor[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && !visitedColor[nr][nc]) {
				if(painting[nr][nc] == painting[r][c]) {
					visitedColor[nr][nc] = true;
					dfsColor(nr, nc);
				}
			}	
		}
	}
	
	private static void dfsColorblind(int r, int c) {
		
		visitedColorblind[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr, nc) && !visitedColorblind[nr][nc]) {
				if(painting[nr][nc] == painting[r][c] || (painting[nr][nc] == 'R' && painting[r][c] == 'G') 
						|| (painting[nr][nc] == 'G' && painting[r][c] == 'R')) {
					visitedColorblind[nr][nc] = true;
					dfsColorblind(nr, nc);
				}
			}	
		}
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	static String src = "5\n" + 
			"RRRBB\n" + 
			"GGBBB\n" + 
			"BBBRR\n" + 
			"BBRRR\n" + 
			"RRRRR";

}
