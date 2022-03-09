package com.boj.implementation;
import java.util.Scanner;

public class BOJ_B1_1546_평균 {
	
	static int N;
	static double[] score;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		score = new double[N];
		for(int i = 0; i < N; i++) {
			score[i] = scanner.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(max < score[i]) {
				max = (int) score[i];
			}
		}
		
		double sum = 0;
		for(int i = 0; i < N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		System.out.println((double) (sum / N));
	}

}
