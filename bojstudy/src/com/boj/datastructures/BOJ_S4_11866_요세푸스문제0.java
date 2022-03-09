package com.boj.datastructures;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_S4_11866_요세푸스문제0 {
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);	
		}
		
		int cnt = 1;
		int num = 1; // 번호 
		while(list.size() < N) {
			if(cnt % K != 0) {
				queue.offer(queue.poll());
			}else {
				list.add(queue.poll());
			}
			cnt++;
		}
		
		StringBuilder output = new StringBuilder();
		output.append("<");
		for(int a : list) {
			output.append(a).append(", ");
		}
		output.setLength(output.length()-2);
		output.append(">");
		System.out.println(output);

	}

}
