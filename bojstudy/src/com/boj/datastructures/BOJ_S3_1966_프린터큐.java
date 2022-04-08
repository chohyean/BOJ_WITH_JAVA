package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S3_1966_프린터큐 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N, M;
	static LinkedList<Document> queue;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());

			queue = new LinkedList<Document>();
			answer = 1;
			int k = 0;
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(tokens.nextToken());
				queue.offer(new Document(k++, num));
			}
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				
				Document head = queue.poll();
				boolean flag = true;
				
				Iterator<Document> iter = queue.iterator();
				while(iter.hasNext()) {
					Document next = (Document) iter.next();
					if(head.importance < next.importance) { // 현재문서 중요도보다 높은 중요도의 문서가 뒤에 있다면 
						flag = false;
						break;
					}
				}
				
				if(flag == false) {
					queue.offer(head);
				}else {
					if(head.order == M) {
						System.out.println(answer);
					}else {
						answer++;
					}
				}
			}

			
		}// 테케완료 
	}
	
	static class Document{
		int order;
		int importance;
		
		public Document(int order, int importance) {
			super();
			this.order = order;
			this.importance = importance;
		}

		@Override
		public String toString() {
			return "Document [order=" + order + ", importance=" + importance + "]";
		}
	}
}
