package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B3_20361_일우는야바위꾼 {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;

	private static int N; // 종이컵 수
	private static int X; // 간식이 왼쪽에서 몇번째 있는 종이컵인지
	private static int K; // 컵 위치 맞바꾸는 횟수
	private static int[] cup;
	private static int answer; // 간식이 위치한 최종 종이컵이 몇번째인지 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		cup = new int[N];
		cup[X-1] = 1; // 인덱스 X-1에 간식(1)이 들어있다.
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			// 위치를 바꿔준다. (인덱스이므로 1을 빼줌)
			int temp = cup[a-1];
			cup[a-1] = cup[b-1];
			cup[b-1] = temp;
		}
		
		for(int i = 0; i < N; i++) {
			if(cup[i] == 1) {
				answer = i+1; // 몇번째 종이컵인지 출력하는 거니까 인덱스에서 1을 더해줌.
			}
		}
		
		System.out.println(answer);
	}

}
