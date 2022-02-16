package com.boj.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2750.수 정렬하기
 * @author ashle
 *
 */
public class BOJ_B1_2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int a: arr) {
			System.out.println(a);
		}
		

	}

}
