package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * linkedlist로 했다가 시간초과 뜸!
 * @author hyeancho
 * 
 */
public class BOJ_S3_1406_에디터 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int M;
	static Stack<Character> left = new Stack<>(); // 커서를 기준으로 왼쪽 글자들 
	static Stack<Character> right = new Stack<>(); // 커서를 기준으로 오른쪽 글자들 

	public static void main(String[] args) throws IOException {
		
		String str = input.readLine();
		for(int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		M = Integer.parseInt(input.readLine());
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			String command = tokens.nextToken();
			
			switch (command) {
				case "L": // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨) 
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case "D": // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨) 
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case "B": // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) 
					if(!left.isEmpty()) {
						left.pop();
					}
					break;
				case "P": // a라는 문자를 커서 왼쪽에 추가함 
					char a = tokens.nextToken().charAt(0);
					left.push(a);
					break;
			}
		}
		
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		while(!right.isEmpty()) {
			output.append(right.pop());
		}
		System.out.println(output);
		
	}

}
