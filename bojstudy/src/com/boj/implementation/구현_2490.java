package com.boj.implementation;

import java.util.Scanner;

/**
 * 2490.윷놀이
 * 
 * @author ashle
 *
 */
public class 구현_2490 {

	private static int[] arr; // 윷짝들
	private static int cnt;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		arr = new int[4];

		for (int i = 0; i < 3; i++) {
			cnt = 0;

			for (int j = 0; j < arr.length; j++) {

				arr[j] = scanner.nextInt();

				if (arr[j] == 0) {
					cnt++;
				}
			}

			switch (cnt) {
			case 0:
				System.out.println("E");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			case 4:
				System.out.println("D");
				break;
			}
		}

	}
}
