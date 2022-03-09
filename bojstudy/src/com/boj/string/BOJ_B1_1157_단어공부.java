package com.boj.string;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_1157_단어공부 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		int[] alphabet = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') { // 대문자일 때 
				alphabet[str.charAt(i) - 'A']++;
			}else { // 소문자일 때 
				alphabet[str.charAt(i) - 'a']++;
			}
		}

//		System.out.println(Arrays.toString(alphabet));
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		char answer = '?';
		for(int i = 0; i < alphabet.length; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				answer = (char) (i + 65); // 대문자로 바꿔 
			}else if(max == alphabet[i]) {
				answer = '?';
			}
		}
		
		System.out.println(answer);
		

	}

}
