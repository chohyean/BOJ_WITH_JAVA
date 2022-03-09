package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_B1_14696_딱지놀이 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N; // 총 라운드 수 
	static int a; // A가 내는 딱지 그림 총 개수 
	static int[] cardA;
	static int b; // A가 내는 딱지 그림 총 개수 
	static int[] cardB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		for(int n = 1; n <= N; n++) {
			tokens = new StringTokenizer(input.readLine());
			a = Integer.parseInt(tokens.nextToken());
			cardA = new int[5];
			for(int i = 0; i < a; i++) {
				cardA[Integer.parseInt(tokens.nextToken())]++;
			}
			
			tokens = new StringTokenizer(input.readLine());
			b = Integer.parseInt(tokens.nextToken());
			cardB = new int[5];
			for(int i = 0; i < b; i++) {
				cardB[Integer.parseInt(tokens.nextToken())]++;
			}
			// 입력 완료! 

//			System.out.println(Arrays.toString(cardA));
//			System.out.println(Arrays.toString(cardB));
			
			for(int i = 4; i >= 1; i--) { // 우선순위 : 별, 동그라미, 네모, 세모 순 
				if(cardA[i] > cardB[i]) {
					output.append("A\n");
					break;
				}else if(cardA[i] < cardB[i]){
					output.append("B\n");
					break;
				}else {
					if(i == 1) output.append("D\n");
					else continue;
				}
			}
		}
		System.out.println(output);

	}

}
