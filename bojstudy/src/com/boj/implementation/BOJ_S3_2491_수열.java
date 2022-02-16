package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_2491_수열 {

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int N; // 수열의 길이
	private static int[] seq; // 수열
	private static int lenAsc = 1;
	private static int lenDesc = 1;
	private static int answerAsc = 1;
	private static int answerDesc = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		seq = new int[N];
		for(int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(tokens.nextToken());
		}

		for(int i = 0; i < N-1; i++) {
			if(seq[i] <= seq[i+1]) {
				lenAsc++;
			}else {
				answerAsc = Math.max(lenAsc, answerAsc);
				lenAsc = 1;
			}
			
		}
		
		for(int i = 0; i < N-1; i++) {
			if(seq[i] >= seq[i+1]) {
				lenDesc++;
			}else {
				answerDesc = Math.max(lenDesc, answerDesc);
				lenDesc = 1;
			}
			
		}
		answerAsc = Math.max(lenAsc, answerAsc);
		answerDesc = Math.max(lenDesc, answerDesc);
		System.out.println(Math.max(answerAsc, answerDesc));

	}

}
