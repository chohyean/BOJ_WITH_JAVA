package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_G5_1038_감소하는수 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N; // 몇번째 줄어드는 수인지
	private static List<Long> list; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		list = new ArrayList<Long>();
		
		if(N > 1022) {
			System.out.println(-1);
			System.exit(0);
		}
		
		for(int i = 0; i < 10; i++) {
			addNum(i, 1);
		}
		
		Collections.sort(list);
		System.out.println(list.get(N));
	}
	
	public static void addNum(long num, int len) {
		if(len > 10) return;
		
		list.add(num);
		for(int i = 0; i < 10; i++) {
			if(num % 10 > i) {
				addNum((num * 10) + i, len + 1);
			}
		}
	}

}
