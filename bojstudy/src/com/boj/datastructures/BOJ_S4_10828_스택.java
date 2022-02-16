package com.boj.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Spliterator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 10828.스택
 * @author ashle
 *
 */
public class BOJ_S4_10828_스택 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int N; // 명령의 수
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		
		for(int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());

			switch(tokens.nextToken()) {
			case "push":
				stack.push(Integer.parseInt(tokens.nextToken()));
				break;
			case "top":
				if(stack.empty()) {
					output.append("-1"+ "\n");
				}else {
					output.append(stack.peek()+ "\n");
				}
				break;
			case "size":
				output.append(stack.size()+ "\n");
				break;
			case "empty":
				if(stack.empty()) {
					output.append("1"+ "\n");
				}else {
					output.append("0"+ "\n");
				}
				break;
			case "pop":
				if(stack.empty()) {
					output.append("-1"+ "\n");
				}else {
					output.append(stack.pop()+ "\n");
				}
				break;
			}
		}
		System.out.println(output);

	}

}
