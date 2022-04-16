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

public class BOJ_G4_4179_불 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int R, C;
	static char[][] maze;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Point> fireList = new ArrayList<>();
	static Point jihoon;

	static int time = 0;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());

		maze = new char[R][C];
		for (int r = 0; r < R; r++) {
			String src = input.readLine();
			for (int c = 0; c < C; c++) {
				maze[r][c] = src.charAt(c);
				if (maze[r][c] == 'F') {
					fireList.add(new Point(r, c, 0));
				} else if (maze[r][c] == 'J') {
					jihoon = new Point(r, c, 0);
				}
			}
		} // 입력 완료!

//		for(char[] row : maze) {
//			System.out.println(Arrays.toString(row));
//		}

		if (bfs()) {
			output.append(time);
		} else {
			output.append("IMPOSSIBLE");
		}

		System.out.println(output);
	}

	private static boolean bfs() {
		Queue<Point> qFire = new LinkedList<>();
		Queue<Point> qJihoon = new LinkedList<>();

		for (Point p : fireList) {
			qFire.offer(p);
		}

		qJihoon.offer(jihoon);

		while (!qJihoon.isEmpty()) {
			int sizeFire = qFire.size();
			while (sizeFire-- > 0) {
				Point head = qFire.poll();

				for (int d = 0; d < 4; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];

					if (isIn(nr, nc) && (maze[nr][nc] == '.' || maze[nr][nc] == 'J')) {
						maze[nr][nc] = 'F';
						qFire.offer(new Point(nr, nc, head.depth + 1));

					}
				}
			}

			int sizeJihoon = qJihoon.size();
			while (sizeJihoon-- > 0) {
				Point head = qJihoon.poll();

				for (int d = 0; d < 4; d++) {
					int nr = head.r + deltas[d][0];
					int nc = head.c + deltas[d][1];

					if (!isIn(nr, nc)) {
						time = head.depth + 1;
						return true;
					}

					if (isIn(nr, nc) && maze[nr][nc] == '.') {
						maze[nr][nc] = 'J';
						qJihoon.offer(new Point(nr, nc, head.depth + 1));
					}
				}
			}

		}

		return false;
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	static class Point {
		int r, c, depth;

		public Point(int r, int c, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + " , d=" + depth + "]";
		}
	}

	static String src = "4 4\n" + "####\n" + "#JF#\n" + "#..#\n" + "#..#";

}
