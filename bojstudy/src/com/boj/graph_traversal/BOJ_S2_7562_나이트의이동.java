package com.boj.graph_traversal;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_7562_나이트의이동 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T; // 테케 
	static int I; // 체스판의 한 변의 길이 
	static boolean[][] board;
	static int deltas[][] = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	static Queue<Point> queue = new LinkedList<>();
	static Point start, end;
	static int answer = 0;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			I = Integer.parseInt(input.readLine());
			
			board = new boolean[I][I];
			tokens = new StringTokenizer(input.readLine());
			start = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())); // 나이트가 현재 있는 칸
			board[start.x][start.y] = true; 
			queue.add(new Point(start.x, start.y));
			
			tokens = new StringTokenizer(input.readLine());
			end = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())); // 나이트가 이동하려고 하는 칸
			
			answer = 0;
			
			bfs();
			queue.clear();
			
			output.append(answer + "\n");
		}
		System.out.println(output);
		

	}
	
	public static void bfs() {
		
		aa: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				Point p = queue.poll();
				
				if(p.x == end.x && p.y == end.y) break aa; // 나이트가 이동하려고 하는 칸 도착 
				
				for(int d = 0; d < 8; d++) { // 이동 
					int nr = p.x + deltas[d][0];
					int nc = p.y + deltas[d][1];
					
					if(isIn(nr, nc) && !board[nr][nc]) {
						board[nr][nc] = true; // 방문처리 
						queue.add(new Point(nr, nc));
					}
				}
			}
			answer++;
		}

	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && r<I && 0<=c && c<I;
	}
	

}
