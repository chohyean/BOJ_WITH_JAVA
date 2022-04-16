package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_7576_토마토 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int M, N; // 상자 가로칸의 수, 세로칸의 수
	static int[][] box;
	static List<Point> ripeTomatoes = new ArrayList<>();
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());

		box = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(tokens.nextToken());
				if (box[r][c] == 1) {
					ripeTomatoes.add(new Point(r, c));
				}
			}
		} // 입력 완료!

//		for(int[] row : box) {
//			System.out.println(Arrays.toString(row));
//		}

		bfs();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					answer = 0; // 토마토가 모두 익지 못했으면 -1 출력인데 나중에 answer-1을 출력해야 하니까 0으로...
					break;
				}
			}
		}
		System.out.println(answer - 1);

	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][M];

		for (Point p : ripeTomatoes) {
			queue.offer(new Point(p.r, p.c));
			visited[p.r][p.c] = true;
		}

		answer = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point head = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];

					if (isIn(nr, nc) && box[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						box[nr][nc] = 1;
						queue.offer(new Point(nr, nc));
					}
				}
			}
			answer++;
		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	static String src = "5 5\n" + "-1 1 0 0 0\n" + "0 -1 -1 -1 0\n" + "0 -1 -1 -1 0\n" + "0 -1 -1 -1 0\n" + "0 0 0 0 0";

}
