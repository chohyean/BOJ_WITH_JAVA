package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_7964_부먹왕국의차원관문 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int N, D; // 부먹 왕국의 도시 수, 이동 제한 거리 
	static int[] kingdom;
	static int answer; // 추가로 건설해야하는 차원관문의 최소 개수 

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			D = Integer.parseInt(tokens.nextToken());
			
			kingdom = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < N; i++) {
				kingdom[i] = Integer.parseInt(tokens.nextToken());
			}
			
//			System.out.println(Arrays.toString(kingdom));
			
			int cntD = 0;
			answer = 0;
			for(int i = 0; i < N; i++) {
				cntD++;
				
				if(cntD >= D || kingdom[i] == 1) {
					if(cntD >= D && kingdom[i] != 1) answer++;
					cntD = 0;
					
				}
			}
			
			output.append("#" + t + " " + answer + "\n");
			
		}
		System.out.println(output);

	}
	
	static String src = "3\n" + 
			"6 2\n" + 
			"1 0 0 0 0 1\n" + 
			"10 2\n" + 
			"0 0 1 0 1 0 0 0 0 1\n" + 
			"10 1\n" + 
			"0 0 0 0 0 0 0 0 0 0";

}
