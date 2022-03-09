package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_18405_경쟁적전염 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N, K;
	static int[][] arr;
	static int S, X, Y;
	static boolean[][] isVisited;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N+1][N+1];
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 1; c <= N; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(input.readLine());
		S = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());

//		for(int[] row : arr) {
//			System.out.println(Arrays.toString(row));
//		}
		
		aa : for(int s = 0; s < S; s++) { 
			for(int k = 1; k <= K; k++) {
				bfs(k);
				
				if(arr[X][Y] != 0) break aa; // 구하려는 좌표 값에 바이러스가 들어왔으면 빠져나오기 
			}
		}
		
		System.out.println(arr[X][Y]);

	}
	
	public static void bfs(int virus) {
		Queue<Point> queue = new LinkedList<Point>();
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(arr[r][c] == virus) queue.offer(new Point(r, c)); // 해당 바이러스 종류인 것을 큐에 집어넣기 
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.x + deltas[d][0];
				int nc = p.y + deltas[d][1];
				
				// 안에 있고, 바이러스가 아직 존재하지 않으면 바이러스 넣기 
				if(isIn(nr, nc) && arr[nr][nc] == 0) { 
					arr[nr][nc] = virus;
				}
			}
			
		}
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
	}

	public static boolean isIn(int r, int c) {
		return 1 <= r && r <= N && 1 <= c && c <= N;
	}

}
