package com.boj.implementation;


import java.util.Scanner;

public class 구현_2621 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] arr = new String[5];

		int maxNum, pair1, pair2, triple, quad;

		for (int i = 0; i < 5; i++) {
			arr[i] = scanner.nextLine();
//			System.out.println(arr[i]);
		}

		String[] card1 = arr[0].split(" ");
		String[] card2 = arr[1].split(" ");
		String[] card3 = arr[2].split(" ");
		String[] card4 = arr[3].split(" ");
		String[] card5 = arr[4].split(" ");

		String[] color = { card1[0], card2[0], card3[0], card4[0], card5[0] };
		String[] num = { card1[1], card2[1], card3[1], card4[1], card5[1] };

		for (int i = 1; i <= 9; i++) {
			if (num[i] == "2") {
				// 같은 숫자가 2개인 개수 파악
				if (pair1 > 0)
					pair2 = i;
				else
					pair1 = i;
			} else if (num[i] == "3")
				triple = i;
			else if (num[i] == "4")
				quad = i;
		}

		boolean isFlush = false;
		if (color[0] == "5" || color[1] == "5" || color[2] == "5" || color[3] == "5")
			isFlush = true;
		boolean isStraight = false;
		for (int i = 1; i <= 6; i++) {
			if (num[i] == num[i + 1] == num[i + 2] == num[i + 3] == num[i + 4]) {
				isStraight = true;
			}
		}
		// 각 조건에 해당하는 점수
		if (isFlush && isStraight)
			System.out.printf("%d\n", 900 + maxNum);
		else if (isFlush)
			System.out.printf("%d\n", 600 + maxNum);
		else if (isStraight)
			System.out.printf("%d\n", 500 + maxNum);
		else if (quad != 0)
			System.out.printf("%d\n", 800 + quad);
		else if (triple != 0 && pair1 != 0)
			System.out.printf("%d\n", 700 + 10 * triple + pair1);
		else if (triple != 0)
			System.out.printf("%d\n", 400 + triple);
		else if (pair1 != 0 && pair2 != 0)
			System.out.printf("%d\n", 300 + 10 * Math.max(pair1, pair2) + Math.min(pair1, pair2));
		else if (pair1 != 0)
			System.out.printf("%d\n", 200 + pair1);
		else
			System.out.printf("%d\n", 100 + maxNum);

	}

}
