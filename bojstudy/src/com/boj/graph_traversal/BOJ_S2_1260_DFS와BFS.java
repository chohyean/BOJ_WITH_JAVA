package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFS와BFS {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N, M, V; // 정점의 개수, 간선의 개수, 탐색을 시작할 정점의 번호
	private static boolean[] isVisited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
		for(int i = 0; i < N+1; i++) {
			Collections.sort(graph.get(i));
		} 
		
		isVisited = new boolean[N+1];
		dfs(V);
		System.out.println();
		isVisited = new boolean[N+1];
		bfs(V);
	}
	
	public static void dfs(int node) {
		// 현재 노드를 방문 처리
		isVisited[node] = true;
		System.out.print(node + " ");
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
//		for(int i = 0; i < graph.get(node).size(); i++) {
//			int nextNode = graph.get(node).get(i);
//			if(!isVisited[nextNode]) dfs(nextNode);
//		}
		for(int value : graph.get(node)) {
			if(!isVisited[value]) {
				dfs(value);
			}
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		// 현재 노드를 방문 처리
		isVisited[start] = true;
		// 큐가 빌 때까지 반복
		while(!queue.isEmpty()) {
			// 큐에서 하나의 원소를 뽑아 출력
			int x = queue.poll();
			System.out.print(x + " ");
			// 해당 원소와 연결된 아직 방문하지 않은 원소들을 큐에 삽입
//			for(int i = 0; i < graph.get(x).size(); i++) {
//				int y = graph.get(x).get(i);
//				if(!isVisited[y]) {
//					queue.offer(y);
//					isVisited[y] = true;
//				}
//			}
			for(int e : graph.get(x)) {
				if(!isVisited[e]) {
					isVisited[e] = true;
					queue.offer(e);
				}
			}
		}
	}

}
