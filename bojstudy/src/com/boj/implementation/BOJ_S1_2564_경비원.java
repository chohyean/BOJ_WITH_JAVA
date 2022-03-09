package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S1_2564_경비원 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	private static int w, h; // 블록의 가로, 세로 길이
	private static int storeNum;
	private static int[][] store;


	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		w = Integer.parseInt(tokens.nextToken());
		h = Integer.parseInt(tokens.nextToken());
		
		storeNum = Integer.parseInt(input.readLine());
		store = new int[storeNum][2];
		for(int i = 0; i < storeNum; i++) {
			tokens = new StringTokenizer(input.readLine());
			int storeDir = Integer.parseInt(tokens.nextToken());
			int storeLen = Integer.parseInt(tokens.nextToken());
			store[i][0] = storeDir;
			store[i][1] = storeLen;
		}
		
		tokens = new StringTokenizer(input.readLine());
		int myDir = Integer.parseInt(tokens.nextToken());
		int myLen = Integer.parseInt(tokens.nextToken());

		int min = 0;
		int minSum = 0;
		for(int i = 0; i < storeNum; i++) {
			int a = 0, b = 0;
			switch(myDir) {
				case 1:
					if(store[i][0] == 1) {
						min = Math.abs(myLen-store[i][1]);
					}else if(store[i][0] == 2) {
						a = myLen + h + store[i][1];
						b = w-myLen + h + w-store[i][1];
						min = Math.min(a, b);
					}else if(store[i][0] == 3) {
						min = myLen + store[i][1];
					}else {
						min = w-myLen + store[i][1];
					}
					break;
				case 2:
					if(store[i][0] == 1) {
						a = myLen + h + store[i][1];
						b = w-myLen + h + w-store[i][1];
						min = Math.min(a, b);
					}else if(store[i][0] == 2) {
						min = Math.abs(myLen-store[i][1]);
					}else if(store[i][0] == 3) {
						min = myLen + h-store[i][1];
					}else {
						min = w-myLen + h-store[i][1];
					}
					break;
				case 3:
					if(store[i][0] == 1) {
						min = myLen + store[i][1];
					}else if(store[i][0] == 2) {
						min = h-myLen + store[i][1];
					}else if(store[i][0] == 3) {
						min = Math.abs(myLen-store[i][1]);
					}else {
						a = myLen + w + store[i][1];
						b = h-myLen + w + h-store[i][1];
						min = Math.min(a, b);
					}
					break;
				case 4:
					if(store[i][0] == 1) {
						min = myLen + w-store[i][1];
					}else if(store[i][0] == 2) {
						min = h-myLen + w-store[i][1];
					}else if(store[i][0] == 3) {
						a = myLen + w + store[i][1];
						b = h-myLen + w + h-store[i][1];
						min = Math.min(a, b);
					}else {
						min = Math.abs(myLen-store[i][1]);
					}
					break;
			}
			minSum += min;
			
		}
		System.out.println(minSum);

	}

}
