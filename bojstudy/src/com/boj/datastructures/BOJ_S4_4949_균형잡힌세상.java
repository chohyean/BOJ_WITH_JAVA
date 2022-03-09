package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_4949_균형잡힌세상 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		while(true) {
			String str = input.readLine();
			if(str.equals(".")) break;
			
			stack = new Stack<Character>();
			
			String answer = "yes";
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					if(!stack.isEmpty()) {
						if(stack.peek() == '(') stack.pop();
						else if(stack.peek() == '[') break;
					}else {
						stack.push(str.charAt(i));
					}
				}else if(str.charAt(i) == ']') {
					if(!stack.isEmpty()) {
						if(stack.peek() == '[') stack.pop();
						else if(stack.peek() == '(') break;
					}else {
						stack.push(str.charAt(i));
					}
				}
			}
			
//			System.out.println(stack);
			
			if(!stack.isEmpty()) answer = "no";
			output.append(answer + "\n");
			
		}
		System.out.println(output);
		

	}

}
