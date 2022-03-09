package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_1244_스위치켜고끄기 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int switchNum; // 스위치 개수 
	static int[] switchArr; // 스위치 상태 
	static int studentNum; // 학생 수 
	static int[][] student; // 학생 성별, 학생이 받은 수 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		switchNum = Integer.parseInt(input.readLine());
		switchArr = new int[switchNum];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < switchNum; i++) {
			switchArr[i] = Integer.parseInt(tokens.nextToken());
		}
		studentNum = Integer.parseInt(input.readLine());
		student = new int[studentNum][2];
		for(int r = 0; r < studentNum; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 2; c++) {
				student[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		System.out.println(Arrays.toString(switchArr));
//		for(int[] row : student) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for(int r = 0; r < studentNum; r++) {
			if(student[r][0] == 1) {
				for(int i = 1; i <= switchNum; i++) {
					if(i % student[r][1] == 0) { // 스위치 번호가 자기가 받은 번호의 배수이면 바꾸기 
						change(i-1);
					}
				}
//				System.out.println(Arrays.toString(switchArr));
			}else if(student[r][0] == 2) {
				boolean[] isSym = new boolean[switchNum];
				isSym[student[r][1]-1] = true; // 자기자신 대칭 
				int cnt = 1;
				// 받은 번호의 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 바꾸기 
				while(student[r][1]-1 - cnt >= 0 && student[r][1]-1 + cnt <= switchNum-1) {
					if(switchArr[student[r][1]-1 - cnt] == switchArr[student[r][1]-1 + cnt]) {
						isSym[student[r][1]-1 - cnt] = true;
						isSym[student[r][1]-1 + cnt] = true;
					}else {
						break;
					}
					cnt++;
				}
//				System.out.println(Arrays.toString(isSym));
				for(int i = 0; i < isSym.length; i++) {
					if(isSym[i]) change(i);
				}
			}

		}
		
		for(int i = 0; i < switchArr.length; i++) { // 20개씩 끊어서 출력 
			System.out.print(switchArr[i] + " ");
			if((i+1) % 20 == 0) System.out.println();
		}

	}
	
	public static void change(int idx) { // 스위치 상태 0이면 1로, 1이면 0으로 바꾸기 
		if(switchArr[idx] == 0) {
			switchArr[idx] = 1;
		}else {
			switchArr[idx] = 0;
		}
	}

}
