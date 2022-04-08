package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_11725_트리의부모찾기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; // 노드의 개수 
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static boolean[] isVisited;
	static int[] parent; // 부모노드 

	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(input.readLine());

		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		parent = new int[N+1];
		isVisited = new boolean[N+1];
		
		for(int i = 0; i < N-1; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		bfs();

		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
		
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			isVisited[x] = true;
			for(int i = 0; i < list.get(x).size(); i++) {
				int next = list.get(x).get(i);
				if(!isVisited[next]) {
					parent[next] = x;
					queue.offer(next);
				}
			}
		}
	}

}
