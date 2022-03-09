package com.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D2_1859_백만장자프로젝트 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	static int N;
	static int[] price;
	static int max;
	static int maxIdx = 0;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			price = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(tokens.nextToken());
			}
			
//			long profit = 0;
//			max = Integer.MIN_VALUE;
//			for(int i = N-1; i >= 0; i--) { 
//				if(max < price[i]) { // 뒤에서부터 앞의 매매가가 더 크면 max값 갱신 
//					max = price[i]; 
//				}else { // 앞의 매매가가 더 작으면 max에서 매매가를 빼준 값을 이익에 더해줌  
//					profit += max - price[i];
//				}
//			}
			// 풀이 1 
			
			int start = 0;
			long profit = 0L;
			while(start != price.length) {
				int max = max(price, start);
				if(start == max) {
					start++;
				}else {
					long sum = 0L;
					for(int i = start; i < max; i++) {
						sum += price[i];
					}
					profit += price[max]*(max-start) - sum;
					start = max + 1;
				}
			}
			// 풀이 2 
			output.append("#" + t + " " + profit + "\n");
		}
		System.out.println(output);
	}

	private static int max(int[] arr, int start) {
		int max = 0;
		int index = start;
		for(int i = index; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		
		return index;
	}
}
