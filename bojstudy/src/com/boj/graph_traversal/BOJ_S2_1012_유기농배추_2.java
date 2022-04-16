package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_S2_1012_유기농배추_2 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());

			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				tokens = new StringTokenizer(input.readLine());
				int c = Integer.parseInt(tokens.nextToken());
				int r = Integer.parseInt(tokens.nextToken());
				map[r][c] = 1;
			}

//			for(int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			answer = 0;
			visited = new boolean[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(map[r][c] == 1 && !visited[r][c]) {
						bfs(new Point(r, c));
						answer++;
					}
				}
			}
			output.append(answer + "\n");
		}
		System.out.println(output);
	}

	private static void bfs(Point start) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.offer(start);
		visited[start.r][start.c] = true; 
		
		while(!queue.isEmpty()) {
			Point head = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = head.r + deltas[d][0];
				int nc = head.c + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
				}
			}
			
		}
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}

	static String src = "2\n" + "10 8 17\n" + "0 0\n" + "1 0\n" + "1 1\n" + "4 2\n" + "4 3\n" + "4 5\n" + "2 4\n"
			+ "3 4\n" + "7 4\n" + "8 4\n" + "9 4\n" + "7 5\n" + "8 5\n" + "9 5\n" + "7 6\n" + "8 6\n" + "9 6\n"
			+ "10 10 1\n" + "5 5";

}
