package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S3_5397_키로거 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static String str;
	static Stack<Character> left;
	static Stack<Character> right;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t <= T; t++) {
			left = new Stack<Character>();
			right = new Stack<Character>();
			
			str = input.readLine();
			
			for(int i = 0; i < str.length(); i++) {
				switch(str.charAt(i)) {
					case '<':
						if(!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case '>':
						if(!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case '-':
						if(!left.isEmpty()) {
							left.pop();
						}
						break;
					default:
						left.push(str.charAt(i));
						break;
				}
			}
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			while(!right.isEmpty()) {
				output.append(right.pop());
			}
			output.append("\n");
			
		}
		System.out.println(output);

	}

}
