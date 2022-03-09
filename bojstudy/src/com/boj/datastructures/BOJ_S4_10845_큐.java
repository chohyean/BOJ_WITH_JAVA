package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_S4_10845_큐 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		int cnt = 1;
		while(cnt <= N) {
			
			String command = scanner.next();
			switch(command) {
				case "push":
					int num = scanner.nextInt();
					queue.offer(num);
					break;
				case "pop":
					if(queue.isEmpty()) output.append(-1).append("\n");
					else output.append(queue.poll()).append("\n");
					break;
				case "size":
					output.append(queue.size()).append("\n");
					break;
				case "empty":
					if(queue.isEmpty()) output.append(1).append("\n");
					else output.append(0).append("\n");
					break;
				case "front":
					if(queue.isEmpty()) output.append(-1).append("\n");
					else output.append(queue.peek()).append("\n");
					break;
				case "back":
					if(queue.isEmpty()) output.append(-1).append("\n");
					else {
						int a = 1;
						while(a < queue.size()) {
							queue.offer(queue.poll());
							a++;
						}
						output.append(queue.peek()).append("\n");
						queue.offer(queue.poll());
					}
					break;
			}
			cnt++;
		}
		System.out.println(output);
	}
}
