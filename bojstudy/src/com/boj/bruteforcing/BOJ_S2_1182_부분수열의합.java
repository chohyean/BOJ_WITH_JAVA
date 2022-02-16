package com.boj.bruteforcing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_1182_부분수열의합 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N; // 정수의 개수
	private static int S; // 그 수열의 원소를 다 더한 값
	private static int[] seq;
	private static boolean[] isChecked;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		
		seq = new int[N];
		isChecked = new boolean[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(tokens.nextToken());
		}
		
		generateSubset(0, 0);
		
		if(S == 0) { // 공집합도 합이 0이니까 그건 빼줘야됨!
			System.out.println(answer-1);
		}else {
			System.out.println(answer);
		}

	}

	private static void generateSubset(int cnt, int sum) {
		if(cnt == N) {
			if(sum == S) {
				answer++;
			}
			return;
		}
		
		isChecked[cnt] = true;
		generateSubset(cnt + 1, sum + seq[cnt]);
		isChecked[cnt] = false;
		generateSubset(cnt + 1, sum);
	}
}
