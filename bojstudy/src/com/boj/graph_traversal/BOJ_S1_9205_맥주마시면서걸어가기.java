package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_9205_맥주마시면서걸어가기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int t;
	static int n; // 맥주를 파는 편의점 개수 
	static ArrayList<Point> dir;
	static ArrayList<ArrayList<Integer>> graph;
	static String answer = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(input.readLine());
		for(int tc = 1; tc <= t; tc++) {
			
			n = Integer.parseInt(input.readLine());
			
			// 상근이집, 편의점, 페스티벌 위치 
			dir = new ArrayList<>();
			for(int i = 0; i < n+2; i++) {
				tokens = new StringTokenizer(input.readLine());
				dir.add(new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
			}
			
			graph = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < n+2; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					// 50미터에 한병씩 마시는데, 맥주가 20병 들어있으니 맨해튼거리가 1000미터를 넘으면 안됨!
					if(Math.abs(dir.get(i).x - dir.get(j).x) + Math.abs(dir.get(i).y - dir.get(j).y)  <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			if(bfs(graph, n)) {
				answer = "happy";
			}else {
				answer = "sad";
			}
			
			output.append(answer + "\n");
			
		}// 테케 완료 

		System.out.println(output);
	}
	
	public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		
		boolean[] isVisited = new boolean[n+2];
		isVisited[0] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == n+1) return true;
			
			for(int next : graph.get(cur)) {
				if(!isVisited[next]) {
					isVisited[next] = true;
					queue.offer(next);
				}
			}
			
		}
		return false;
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

}
