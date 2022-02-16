package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_B2_20299_3대측정 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;
	
	private static int N, K, l; // 신청한 동아리 수, 팀원3명의 능력합에 대한 가입조건, 개인능력치에 대한 가입조건
	private static int[] clubMem; // 동아리
	private static int cnt; // 가입이 가능한 동아리 수
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		l = Integer.parseInt(tokens.nextToken());
		
		clubMem = new int[3];
		cnt = 0;
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			clubMem[0] = Integer.parseInt(tokens.nextToken());
			clubMem[1] = Integer.parseInt(tokens.nextToken());
			clubMem[2] = Integer.parseInt(tokens.nextToken());
			
			int abilitySum = clubMem[0] + clubMem[1] + clubMem[2]; // 팀원 3명의 능력 합
		
			// 개인 능력치가 각각 가입조건을 넘으면서, 능력합도 가입조건을 넘을 때
			if(clubMem[0] >= l && clubMem[1] >= l && clubMem[2] >= l && abilitySum >= K) {
				cnt++; // 가입된 동아리 수 증가
				output.append(clubMem[0] + " " + clubMem[1] + " " + clubMem[2] + " "); // 가입된 동아리 학생들 능력치
			}
		}
		System.out.println(cnt);
		System.out.println(output);


	}
}
