package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_2178_미로탐색 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int N, M;
	static int[][] maze;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());

		maze = new int[N + 1][M + 1];
		for (int r = 0; r < N; r++) {
			String str = input.readLine();
			for (int c = 0; c < M; c++) {
				maze[r + 1][c + 1] = str.charAt(c) - '0';
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M+1];
		
		queue.offer(new Point(1, 1));
		visited[1][1] = true;
		int move = 1;
		
		while(!queue.isEmpty()) {
			Point head = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = head.r + deltas[d][0];
				int nc = head.c + deltas[d][1];
				
				if(isIn(nr, nc) && maze[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc));
					maze[nr][nc] += maze[head.r][head.c];
				}
			}
		}
		
		return maze[N][M];
	}
	
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static boolean isIn(int r, int c) {
		return 1 <= r && r <= N && 1 <= c && c <= M;
	}

	static String src = "4 6\n" + "101111\n" + "101010\n" + "101011\n" + "111011";

}
