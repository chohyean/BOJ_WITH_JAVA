package com.boj.dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_4485_녹색옷입은애가젤다지 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int N;
	static int[][] map;
	static int[][] distMap;
	static int INF = Integer.MAX_VALUE;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = 1;
		while(true) {
			N = Integer.parseInt(input.readLine());
			
			if(N == 0) break;
			
			map = new int[N][N];
			distMap = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					distMap[r][c] = INF;
				}
			}
			
			output.append("Problem " + t + ": " + dijkstra() + "\n");
			t++;
		}//테케 완료 
		System.out.println(output);
		

	}
	
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distMap[0][0] = map[0][0];
		pq.offer(new Node(0, 0, distMap[0][0]));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = node.r + deltas[d][0];
				int nc = node.c + deltas[d][1];
				
				if(isIn(nr, nc)) {
					if(distMap[node.r][node.c] + map[nr][nc] < distMap[nr][nc]) {
						distMap[nr][nc] = distMap[node.r][node.c]+ map[nr][nc];
						pq.offer(new Node(nr, nc, distMap[nr][nc]));
					}
				}
			}
		}
		return distMap[N-1][N-1];
	}
	
	static class Node implements Comparable<Node>{
		
		private int r;
		private int c;
		private int distance;
		
		public Node(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		public int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node o) {
			if(this.distance - o.distance < 0) {
				return -1;
			}
			return 1;
		}
		
		
	}
	
	public static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

}
