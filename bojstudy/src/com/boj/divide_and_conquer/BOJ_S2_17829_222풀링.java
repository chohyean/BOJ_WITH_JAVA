package com.boj.divide_and_conquer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_17829_222풀링 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		matrix = new int[N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				matrix[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for(int[] row : arr) {
//			System.out.println(Arrays.toString(row));
//		}
		
		System.out.println(pooling(0, 0, N));
	}

	private static int pooling(int r, int c, int size) {
		
		int miniArr[] = new int[4];
		
		if(size == 2) {
			int idx = 0;
			for(int i = r; i <r+2; i++){
				for(int j = c; j <c+2; j++) {
					miniArr[idx++] = matrix[i][j];
				}
			}
		}else {
			size = size / 2;
			
			miniArr[0] = pooling(r, c, size);
			miniArr[1] = pooling(r, c+size, size);
			miniArr[2] = pooling(r+size, c, size);
			miniArr[3] = pooling(r+size, c+size, size);
		}
		
		Arrays.sort(miniArr);
		return miniArr[2];
		
	}

}
