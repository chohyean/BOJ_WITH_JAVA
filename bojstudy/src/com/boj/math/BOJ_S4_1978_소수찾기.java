package com.boj.math;
import java.util.Scanner;

public class BOJ_S4_1978_소수찾기 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			int prime = 0;
			
			if(num == 1) prime = -1;
			for(int k = 2; k <= num; k++) {
				if(k != num && num % k == 0) { // 자기자신이 아닌데 나눠떨어지는 수가 있다?? 소수가 아닌거야 
					prime = -1;
					break;
				}
			}
			if(prime == 0) cnt++;
		}
		
		System.out.println(cnt);

	}

}
