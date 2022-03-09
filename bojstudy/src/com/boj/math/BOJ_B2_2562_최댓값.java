package com.boj.math;
import java.util.Scanner;

public class BOJ_B2_2562_최댓값 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] nums = new int[9];
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i = 0; i < 9; i++) {
			nums[i] = scanner.nextInt();
			
		}
		
		for(int i = 0; i < 9; i++) {
			if(max < nums[i]) {
				max = nums[i];
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}

}
