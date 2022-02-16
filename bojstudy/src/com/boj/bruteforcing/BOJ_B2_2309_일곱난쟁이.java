package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_B2_2309_일곱난쟁이 {
	
	static int[] height = new int[9];
	static int[] choosed = new int[7];
	static int sum = 0;
	static boolean flag;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(height);
		
		combination(0, 0, 0);
		
		
	}
	
	public static void combination(int cnt, int start, int sum) {
		if(flag == true) return;
		
		if(cnt == 7) {
			if(sum == 100) {
				flag = true;
				for(int c : choosed) {
					System.out.println(c);
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			choosed[cnt] = height[i];
			combination(cnt+1, i+1, sum + choosed[cnt]);
		}
		
	}

}
