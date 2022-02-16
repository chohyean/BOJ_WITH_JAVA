package com.boj.sorting;
/**
 * 2751.수 정렬하기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_S5_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(input.readLine()));
		}
		
		Collections.sort(list);
		
		for(int l : list) {
			output.append(l).append("\n");
		}
		
		System.out.println(output);
		

	}

}
