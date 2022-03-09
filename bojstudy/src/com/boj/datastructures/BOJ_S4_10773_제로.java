package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S4_10773_제로 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int K;
	static Stack<Integer> nums = new Stack<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(input.readLine());
		
		int cnt = 0;
		while(cnt < K) {
			int num = Integer.parseInt(input.readLine());
			
			if(num == 0) {
				nums.pop();
			}else {
				nums.add(num);
			}
			cnt++;
		}
		
		int sum = 0;
		if(nums.isEmpty()) {
			output.append(0);
		}else {
			for(int n : nums) {
				sum += n;
			}
			output.append(sum);
		}
		System.out.println(output);

	}

}
