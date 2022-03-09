package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_S4_10866_덱 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static Deque<Integer> deque = new ArrayDeque<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		int cnt = 1;
		while(cnt <= N) {
			
			String command = scanner.next();
			switch(command) {
				case "push_front":
					deque.addFirst(scanner.nextInt());
					break;
				case "push_back":
					deque.addLast(scanner.nextInt());
					break;
				case "pop_front":
					if(deque.isEmpty()) output.append(-1).append("\n");
					else output.append(deque.removeFirst()).append("\n");
					break;
				case "pop_back":
					if(deque.isEmpty()) output.append(-1).append("\n");
					else output.append(deque.removeLast()).append("\n");
					break;
				case "size":
					output.append(deque.size()).append("\n");
					break;
				case "empty":
					if(deque.isEmpty()) output.append(1).append("\n");
					else output.append(0).append("\n");
					break;
				case "front":
					if(deque.isEmpty()) output.append(-1).append("\n");
					else output.append(deque.peekFirst()).append("\n");
					break;
				case "back":
					if(deque.isEmpty()) output.append(-1).append("\n");
					else output.append(deque.peekLast()).append("\n");
					break;
			}
			cnt++;
		}
		System.out.println(output);
	}

}
