package com.boj.sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_S5_2628_종이자르기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int C, R;
	static int[][] paper;
	static int num; // 칼로 잘라야 하는 점선의 개수 
	static ArrayList<Integer> cutR;
	static ArrayList<Integer> cutC;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		paper = new int[R][C];
		cutR = new ArrayList<Integer>();
		cutC = new ArrayList<Integer>();
		cutR.add(0);
		cutR.add(R);
		cutC.add(0);
		cutC.add(C);
		
		num = Integer.parseInt(input.readLine());
		for(int i = 0; i < num; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken()); // 가로로 자르면 0, 세로로 자르면 1 
			int b = Integer.parseInt(tokens.nextToken()); // 자르는 점선 번호 
			
			if(a == 0) {
				cutR.add(b);
			}else {
				cutC.add(b);
			}
		}
	
		Collections.sort(cutR);
		Collections.sort(cutC);
		
//		System.out.println(cutR);
//		System.out.println(cutC);
		
		int max = Integer.MIN_VALUE;
		for(int r = 0; r < cutR.size()-1; r++) {
			for(int c = 0; c < cutC.size()-1; c++) {
				int area = (cutR.get(r+1)-cutR.get(r))*(cutC.get(c+1)-cutC.get(c));
				
				if(max < area) max = area;
			}
		}
		
		System.out.println(max);

	}

}
