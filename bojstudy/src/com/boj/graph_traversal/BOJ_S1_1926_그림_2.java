package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author hyeancho
 * @note dfs버전
 */
public class BOJ_S1_1926_그림_2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int n, m;
	static int[][] paper;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static int paintingCnt;
	static int paintingArea;
	static int maxArea;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());

		paper = new int[n][m];
		for (int r = 0; r < n; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < m; c++) {
				paper[r][c] = Integer.parseInt(tokens.nextToken());
			}
		} // 입력 완료

		visited = new boolean[n][m];
		paintingCnt = 0;
		paintingArea = 0;
		maxArea = Integer.MIN_VALUE;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (paper[r][c] == 1 && !visited[r][c]) {
					dfs(r, c, visited);
					paintingCnt++;
					maxArea = Math.max(maxArea, paintingArea);
					paintingArea = 0;
				}
			}
		}

		System.out.println(paintingCnt);
		if (maxArea == Integer.MIN_VALUE) {
			maxArea = 0;
		}
		System.out.println(maxArea);

	}

	private static void dfs(int r, int c, boolean[][] visited) {

		visited[r][c] = true;
		paintingArea++;

		for (int d = 0; d < 4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];

			if (isIn(nr, nc) && paper[nr][nc] == 1 && !visited[nr][nc]) {
				dfs(nr, nc, visited);
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
