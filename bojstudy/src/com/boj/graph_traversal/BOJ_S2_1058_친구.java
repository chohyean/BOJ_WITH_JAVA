package com.boj.graph_traversal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1058_친구 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static char[][] arr;
	static boolean[][] isFriend; // 2-친구인지 체크 
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		arr = new char[N][N];
		for(int r = 0; r < N; r++) {
			String str = input.readLine();
			for(int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		isFriend = new boolean[N][N];
		answer = new int[N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(arr[r][c] == 'Y') {
					if(!isFriend[r][c]) {
						answer[r]++; // 2-친구 수 증가 
						isFriend[r][c] = true;
					}
					for(int i = 0; i < N; i++) {
						// 친구의 친구가 있고, 아직 체크하지 않았고, 친구의 친구가 내가 아닐 때 
						if(arr[c][i] == 'Y' && !isFriend[r][i] && r != i) {
							answer[r]++; // 2-친구 수 증가 
							isFriend[r][i] = true;
						}
					}
				}
			}
		}
		
		// 2-친구의 수가 가장 많은 사람 구하기 
		int max = Integer.MIN_VALUE;
		for(int a : answer) {
			if(max < a) max = a;
		}
		
		System.out.println(max);
	}
}
