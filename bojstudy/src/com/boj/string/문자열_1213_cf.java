package com.boj.string;

import java.util.Scanner;

public class 문자열_1213_cf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();

		int[] alpha = new int[26];
		for (int i = 0; i < name.length(); i++) {
			alpha[name.charAt(i) - 'A']++;
		} // 영어이름에 들어가는 알파벳 갯수를 넣어준다.

		int cnt = 0; // 홀수인 알파벳 갯수
		int center = 0;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 != 0) {
				center = i;
				cnt++;
			}// 알파벳 갯수가 홀수이면 가운데에 알파벳을 할당하고, cnt 증가
		}

		if (cnt > 1 || (cnt == 1 && name.length() % 2 == 0)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		} // 홀수인 알파벳이 1보다 크거나, 1이면서 이름 총길이가 짝수이면 팰린드롬을 만들 수 없음!

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alpha[i] / 2; j++) {
				result.append((char) (i + 'A'));
			} // 알파벳 순서대로 넣어줌
		}
		StringBuffer tmp = new StringBuffer(result.toString());
		if (cnt == 1)
			result.append((char) (center + 'A')); // 홀수인 알파벳이 1이면 가운데에 알파벳을 넣어줌
		System.out.println(result.toString() + tmp.reverse());
	}

}
