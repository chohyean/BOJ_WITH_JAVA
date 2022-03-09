package com.boj.math;
import java.util.Scanner;

public class BOJ_B3_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		
		int minH = Math.min(y, Math.abs(h-y));
		int minW = Math.min(x, Math.abs(w-x));
		System.out.println(Math.min(minH, minW));

	}

}
