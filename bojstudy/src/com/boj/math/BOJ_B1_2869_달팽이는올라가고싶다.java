package com.boj.math;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 다시 풀어보기!
 * @author hyeancho
 *
 */
public class BOJ_B1_2869_달팽이는올라가고싶다 {
	
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder output = new StringBuilder();
	private static StringTokenizer tokens;
	
	static int A, B, V;

	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		V = Integer.parseInt(tokens.nextToken());
		
		int day = (V-B) / (A-B);
		if((V-B) % (A-B) != 0) day++;
		
		System.out.println(day);
	}

}
