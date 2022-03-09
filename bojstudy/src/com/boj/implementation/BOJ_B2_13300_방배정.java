package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_13300_방배정 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, K; // 학생 수, 한 방에 배정할 수 있는 최대 인원 수 
	static int[][] room;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		room = new int[6][2];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken()); // 성별 
			int y = Integer.parseInt(tokens.nextToken()); // 학년 
			room[y-1][s]++;
		}
		
		
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 2; c++) {
				if(room[r][c] == 0) continue; // 비어있으면 방 추가X 
				answer += room[r][c] / K; // 나눌 수 있는 만큼 방 계산 
				if(room[r][c] % K != 0) { // 안나눠지면 하나 더 필요 
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
