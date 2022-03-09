package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_2477_참외밭 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int K;
	static int[][] arr;
	static int areaMax = Integer.MIN_VALUE;
	static int sub = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(input.readLine());
		
		arr = new int[6][2];
		for(int i = 0; i < 6; i++){
			tokens = new StringTokenizer(input.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		// 모듈러스 이용해서 써클 돌려~~ 
		for(int i = 0; i < 6; i++) {
			int area = arr[i%6][1] * arr[(i+1)%6][1];
			if(areaMax < area) {
				areaMax = area; // 전체 넓이 최댓값 
				sub = arr[(i+3)%6][1] * arr[(i+4)%6][1]; // 두번째 변의 다음다음 변과 다음다음다음 변의 면적이 빼줄 면적이다 
			}
		}

		System.out.println((areaMax - sub) * K);
			
	}

}
