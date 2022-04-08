package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5_1436_영화감독숌 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int num = 666;
	static int cnt = 1;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		while(true) {
			if(cnt == N) break;
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);

	}

}
