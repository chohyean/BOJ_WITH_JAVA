package com.boj.binary_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_1072_게임 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int X, Y, Z; // 게임 횟수, 이긴 게임, 승률 (소수점 버림) 
	static int cnt = 0;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());
		Z = (int) ((long) Y * 100 / X);
		
		int start = 0;
		int end = (int) 1e9;
		
		
		binarySearch(Z, start, end);
		System.out.println(result);

	}
	
	public static void binarySearch(int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            int N = (int) ((long) (Y+mid) * 100 / (X+mid));
            
            if(N != target){
            	result = mid;
            	end = mid - 1;
            }else {
            	start = mid + 1;
            }
        }
        
    }

}
