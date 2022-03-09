package com.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 배열로 접근하지 말기! 
 * @author hyeancho
 *
 */
public class BOJ_S4_10158_개미 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	static int w, h; // 가로길이, 세로길이
	static int p, q; // 개미의 초기좌표 값
	static int t; // 개미가 움직일 시간

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		w = Integer.parseInt(tokens.nextToken());
		h = Integer.parseInt(tokens.nextToken());

		tokens = new StringTokenizer(input.readLine());
		p = Integer.parseInt(tokens.nextToken());
		q = Integer.parseInt(tokens.nextToken());
		t = Integer.parseInt(input.readLine());

		int x = (p + t) % (2*w);
		int y = (q + t) % (2*h);
		
		if(x > w) x = 2*w - x;
		if(y > h) y= 2*h - y;
		
		StringBuilder output = new StringBuilder();
		output.append(x).append(" ").append(y);
		System.out.println(output);

	}

}
