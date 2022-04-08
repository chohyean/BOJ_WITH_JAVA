package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S3_2606_바이러스 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; // 정점 개수 
	static int M; // 간선 개수 
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] isVisited;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
//		System.out.println(graph);
		
		bfs(1);

	}
	
	public static void bfs(int start) {
		isVisited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if(!isVisited[y]) {
					queue.offer(y);
					isVisited[y] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
