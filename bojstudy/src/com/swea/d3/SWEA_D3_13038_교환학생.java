package com.swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_13038_교환학생 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC;
	static int n;
	static int[] lesson;

	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		for(int t = 1; t <= TC; t++) {
			n = Integer.parseInt(input.readLine());
			lesson = new int[7];
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < 7; i++) {
				lesson[i] = Integer.parseInt(tokens.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			for(int start = 0; start < 7; start++) { 
				// 수업이 시작하는 모든 요일 처리 
				if(lesson[start] == 0) continue;
				
				int day = start;
				int cnt = 0;
				while(true) {
					if(lesson[day%7] == 1) cnt++; // 수업이 열리면 카운팅 
					++day; // 하루지남
					if(cnt == n) { // 머무른 최소일수 
						min = Math.min(min, day-start);
						break;
					}
				}
				
			}
			output.append("#" + t + " " + min + "\n");
		}
		System.out.println(output);
	}

}
