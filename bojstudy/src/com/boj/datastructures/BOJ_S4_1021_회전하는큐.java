package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_S4_1021_회전하는큐 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static LinkedList<Integer> deque = new LinkedList<Integer>();
	static int[] nums;

	public static void main(String[] args) throws IOException {
	
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		nums = new int[M];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int cnt = 0;
		for(int i = 0; i < M; i++) {
			// 뽑으려는 수의 인덱스가 중간보다 왼쪽인지, 오른쪽인지 판단 
			if(deque.indexOf(nums[i]) <= deque.size()/2) { 
				while(deque.peekFirst() != nums[i]) {
					deque.addLast(deque.removeFirst()); // 2번 연산 
					cnt++;
				}
			}else {
				while(deque.peekFirst() != nums[i]) {
					deque.addFirst(deque.removeLast()); // 3번 연산 
					cnt++;
				}
			}
			deque.removeFirst(); // 뽑으려는 수 뽑아내기 
		}
		
		System.out.println(cnt);

	}

}
