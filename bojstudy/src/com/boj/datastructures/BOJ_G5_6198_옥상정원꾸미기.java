package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_G5_6198_옥상정원꾸미기 {	
	
	static int N; // 빌딩의 개수 
	static Stack<Integer> stack = new Stack<>();
	static long cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(input.readLine());
			
			while(!stack.isEmpty() && stack.peek() <= a) {
				stack.pop();
			}
			
			cnt += stack.size();
			stack.push(a);
		}
		
		System.out.println(cnt);

	}

}
