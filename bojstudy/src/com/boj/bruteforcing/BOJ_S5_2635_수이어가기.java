package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S5_2635_수이어가기 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	private static int num; // 첫번째 수
	private static ArrayList<Integer> answer = new ArrayList<Integer>();
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(input.readLine());

	
		for(int i = 0; i <= num; i++) {
			int a = num;
			int b = i;
			int cnt = 2;
			ArrayList<Integer> nums = new ArrayList<Integer>();
			nums.add(a);
			nums.add(b);
			
			while(true) {
				if(a - b < 0) break;
				
				int temp = a; // a값 저장해줌 
				
				a = b;
				b = temp-b;
				cnt++;
				nums.add(b);
				
			}

			if(max < cnt) {
				max = cnt;
				answer = nums;
			}
		}

		System.out.println(max);
		for(int num : answer) {
			System.out.print(num + " ");
		}
		

	}

}
