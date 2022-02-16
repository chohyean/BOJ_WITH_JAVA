package com.boj.datastructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_B2_2605_줄세우기 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int num; // 학생의 수
	private static int[] pick; // 학생들이 뽑은 번호
	private static LinkedList<Integer> result = new LinkedList<>(); // 최종적으로 줄을 선 순서
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(input.readLine());
		pick = new int[num];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < num; i++) {
			pick[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == 0) result.add(1);
				else if(pick[i] == j) {
					result.add(i-j, i+1);
				}
			}
		}
		
		for(int r : result) {
			System.out.print(r + " ");
		}
	
		
		
		
		
	}

}
